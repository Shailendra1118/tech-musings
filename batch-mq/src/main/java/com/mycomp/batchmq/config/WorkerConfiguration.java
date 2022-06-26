package com.mycomp.batchmq.config;

import com.mycomp.batchmq.bean.Person;
import com.mycomp.batchmq.processor.PersonItemProcessor;
import com.mycomp.batchmq.reader.PersonItemReader;
import com.mycomp.batchmq.writer.PersonItemWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.integration.config.annotation.EnableBatchIntegration;
import org.springframework.batch.integration.partition.RemotePartitioningWorkerStepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.retry.policy.CircuitBreakerRetryPolicy;

@Slf4j
@EnableBatchProcessing
@EnableBatchIntegration
@Configuration
public class WorkerConfiguration {
    @Autowired
    public StepExecutionListener stepExecutionListener;


    @Autowired
    private RemotePartitioningWorkerStepBuilderFactory workerStepBuilderFactory;

    @StepScope
    @Bean
    public PersonItemReader reader() {
        return new PersonItemReader();
    }

    @StepScope
    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @StepScope
    @Bean
    public PersonItemWriter writer() {
        return new PersonItemWriter();
    }

    /*
     * Configure inbound flow (requests coming from the manager)
     */
    @Bean
    public DirectChannel incomingRequestsFromManager() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow inboundFlowFromManager(ConnectionFactory connectionFactory) {
        return IntegrationFlows
                .from(Amqp.inboundAdapter(connectionFactory, "outgoingRequestsToWorkers"))
                .channel(incomingRequestsFromManager())
                .get();
    }

    /*
     * Configure outbound flow (replies going to the manager)
     */
    @Bean
    public DirectChannel outgoingRepliesToManager() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow outboundFlowToManager(AmqpTemplate amqpTemplate) {
        return IntegrationFlows
                .from(outgoingRepliesToManager())
                .handle(Amqp.outboundAdapter(amqpTemplate).routingKey("incomingRepliesFromWorkers"))
                .get();
    }


    @Bean
    public Step step1() {
        return workerStepBuilderFactory.get("step1")
                .inputChannel(incomingRequestsFromManager())
                .outputChannel(outgoingRepliesToManager())
                .<Person, Person>chunk(PartitionerImpl.PAGE_SIZE)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .retryLimit(3)
                .retryPolicy(new CircuitBreakerRetryPolicy())
                .retry(Exception.class)
                .listener(stepExecutionListener)
                .build();
    }
}
