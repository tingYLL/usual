package com.jdjm.zhy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Component
public class Student {

    private String name;

    private Integer age;

    private String sex;


}
