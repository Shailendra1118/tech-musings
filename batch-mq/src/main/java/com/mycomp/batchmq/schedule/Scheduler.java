package com.mycomp.batchmq.schedule;

import java.util.HashMap;
import java.util.Map;

//import org.checkerframework.checker.units.qual.A;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.integration.partition.RemotePartitioningManagerStepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepExecutionListener stepExecutionListener;
    @Autowired
    private JobExecutionListener jobExecutionListener;
    @Autowired
    private RemotePartitioningManagerStepBuilderFactory managerStepBuilderFactory;
    @Autowired
    private Step importUsageJobManager;
    private Long id = 1l;

    @Scheduled(fixedRate = 3000)
    public void start() throws Exception {
        //Build parameters
        Map<String, JobParameter> parameters = new HashMap<>();
        parameters.put("id", new JobParameter(id++));
        parameters.put("reportDate", new JobParameter("date"));

        jobLauncher.run(importUsageJob(), new JobParameters(parameters));
    }

    public Job importUsageJob() throws Exception {
        return jobBuilderFactory.get("importUsageJob")
                .incrementer(new RunIdIncrementer())
                .flow(importUsageJobManager)
                .end()
                .listener(jobExecutionListener)
                .build();
    }
}
