package com.mycomp.batchmq.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @CsvBindByPosition(position = 1)
    private String lastName;
    @CsvBindByPosition(position = 0)
    private String firstName;
}
