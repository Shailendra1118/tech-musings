package com.mycomp.batchmq.config;

import com.mycomp.batchmq.listener.JobNotificationListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.integration.config.annotation.EnableBatchIntegration;
import org.springframework.batch.integration.partition.RemotePartitioningManagerStepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Slf4j
@EnableBatchProcessing
@EnableBatchIntegration
@Configuration
public class ManagerConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepExecutionListener stepExecutionListener;


    @Autowired
    private RemotePartitioningManagerStepBuilderFactory managerStepBuilderFactory;

    @Bean
    public JobExecutionListener jobExecutionListener(){
        return new JobNotificationListener();
    }


    @Bean
    @StepScope
    public Partitioner partitioner(){
        return  new PartitionerImpl();
    }

    /*
     * Configure outbound flow (requests going to workers)
     */
    @Bean
    public DirectChannel outgoingRequestsToWorkers() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow outboundFlowToWorker(AmqpTemplate amqpTemplate) {
        return IntegrationFlows
                .from(outgoingRequestsToWorkers())
                .handle(Amqp.outboundAdapter(amqpTemplate).routingKey("outgoingRequestsToWorkers"))
                .get();
    }

    /*
     * Configure inbound flow (replies coming from workers)
     */
    @Bean
    public DirectChannel incomingRepliesFromWorkers() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow inboundFlowFromWorker(ConnectionFactory connectionFactory) {
        return IntegrationFlows
                .from(Amqp.inboundAdapter(connectionFactory, "incomingRepliesFromWorkers"))
                .channel(incomingRepliesFromWorkers())
                .get();
    }

    @Bean
    public Step importUsageJobManager() throws Exception {
        return managerStepBuilderFactory.get("importUsageJob.manager")
                .<String, String>partitioner("step1", partitioner())
                .gridSize(2)
                .outputChannel(outgoingRequestsToWorkers())
                .inputChannel(incomingRepliesFromWorkers())
                .listener(stepExecutionListener)
                .build();
    }
}
