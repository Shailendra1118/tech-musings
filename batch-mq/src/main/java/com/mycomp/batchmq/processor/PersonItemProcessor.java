package com.mycomp.batchmq.processor;


import com.mycomp.batchmq.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        log.info("Converting to upper case for firstName={} lastName={}", item.getFirstName(), item.getLastName());
        return Person.builder().firstName(item.getFirstName().toUpperCase()).lastName(item.getLastName().toUpperCase()).build();
    }
}
