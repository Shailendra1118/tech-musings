package com.mycomp.batchmq.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name= "persons")
public class PersonEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;
}
