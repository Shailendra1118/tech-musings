package com.mycomp.batchmq.reader;

import java.io.FileReader;
import java.util.List;

import com.mycomp.batchmq.bean.Person;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@Slf4j
public class PersonItemReader implements ItemReader<Person>, ItemStream {
    private List<Person> persons;


    int currentIndex = 0;
    int offset;
    int pageSize;

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException,
            NonTransientResourceException {
        if (currentIndex >=  pageSize) {
            return null;
        }
        log.info("Reading detail for line={} firstName={} lastName={}", currentIndex,
                persons.get(currentIndex).getFirstName(),
                persons.get(currentIndex).getLastName());
        Person person =
                Person.builder().firstName(persons.get(offset + currentIndex).getFirstName()).lastName(persons.get(offset + currentIndex).getLastName()).build();

        currentIndex++;
        return person;
    }


    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        offset = executionContext.getInt("offset");
        pageSize = executionContext.getInt("pageSize");
        currentIndex = 0;
        try {
            if(persons == null){
                log.info("Loading records for offset={} pagesize={}", offset, pageSize);
                persons = new CsvToBeanBuilder(new FileReader("/Users/abid.khan/Desktop/Projects/batch-mq/src/main/resources/sample-data.csv"))
                        .withType(Person.class).build().parse();
            }

        } catch (Exception ex) {
            log.error("Failed to load job parameters due to={}", ex);
        }
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {

    }
}
