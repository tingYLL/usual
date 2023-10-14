package com.jdjm.zhy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee>{
    private Integer id;
    private Integer age;
    private String name;
    private MyDate myDate;
    @Override
    public int compareTo(Employee employee) {
        return this.getAge().compareTo(employee.getAge());
    }
}
