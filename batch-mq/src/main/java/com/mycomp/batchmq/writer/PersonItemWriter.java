package com.mycomp.batchmq.writer;

import java.util.List;

import com.mycomp.batchmq.bean.Person;
import com.mycomp.batchmq.entity.PersonEntity;
import com.mycomp.batchmq.repository.PersonEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PersonItemWriter implements ItemWriter<Person> {
    @Autowired
    private PersonEntityRepository personEntityRepository;


    @Override
    public void write(List<? extends Person> items) throws Exception {
        log.info("Writing records={}", items.size());
        items.stream().forEach(person -> {
            log.info("Writing data for firstName={} lastName={}", person.getFirstName(), person.getLastName());
            personEntityRepository.saveAndFlush(PersonEntity.builder().firstName(person.getFirstName()).lastName(person.getLastName()).build());
        });
    }
}
