package com.mycomp.batchmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobNotificationListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Job={} with jobId={} is going to execute", jobExecution.getJobInstance().getJobName(),
                jobExecution.getJobInstance().getInstanceId());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Job={} with jobId={} started at={} and finished at={} with exit status={}",
                jobExecution.getJobInstance().getJobName(), jobExecution.getJobInstance().getInstanceId(),
                jobExecution.getStartTime(), jobExecution.getEndTime(), jobExecution.getExitStatus().getExitCode());
    }
}
