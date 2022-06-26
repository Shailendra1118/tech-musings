package com.mycomp.batchmq.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
public class PartitionerImpl implements Partitioner {
    public static final int RECORD_COUNT = 10;
    public static final int PAGE_SIZE = 2;
    public static final int GRID_SIZE = RECORD_COUNT / PAGE_SIZE;
    @Value("#{stepExecution}")
    private StepExecution context;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        String reportDate = context.getJobParameters().getString("reportDate");
        String id = context.getJobParameters().getString("id");
        log.info("Partitioner gets job parameters id={} reportDate={}", id, reportDate);

        Map<String, ExecutionContext> result = new HashMap<>();

        log.info("Total record={}  and gridSize={}", RECORD_COUNT, GRID_SIZE);
        int offset = 0;

        for (int i = 0; i < GRID_SIZE; i++) {
            ExecutionContext context = new ExecutionContext();
            context.putInt("offset", offset);
            context.putInt("pageSize", PAGE_SIZE);
            offset += PAGE_SIZE;
            result.put("partition" + i, context);
        }
        return result;
    }
}
