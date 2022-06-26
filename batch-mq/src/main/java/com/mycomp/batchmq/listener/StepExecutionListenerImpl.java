package com.mycomp.batchmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepExecutionListenerImpl implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Execution started for stepName={} of jobName={} with jobId={}", stepExecution.getStepName(),
                stepExecution.getJobExecution().getJobInstance().getJobName(),
                stepExecution.getJobExecution().getJobId());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("Completed stepName={} stepId={}, startTime={}, endTime={}, readCount={}, writeCount={}, readSkipCount={}, " +
                "writeSkipCount={} exitCode={} jobName={}, jobId={}", stepExecution.getStepName(), stepExecution.getId(),
                stepExecution.getStartTime(), stepExecution.getEndTime(), stepExecution.getReadCount(),
                stepExecution.getWriteCount(), stepExecution.getReadSkipCount(), stepExecution.getWriteSkipCount(),
                stepExecution.getExitStatus().getExitCode(),
                stepExecution.getJobExecution().getJobInstance().getJobName(),
                stepExecution.getJobExecution().getJobId());
        return null;
    }
}
