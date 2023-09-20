package com.jdjm.zhy;


import com.jdjm.zhy.entity.Student;
import com.jdjm.zhy.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Context1 {

    public static void main(String[] args) {
        SpringApplication.run(Context1.class, args);

        Student student = (Student)SpringContextUtils.getBean("student");
//        Student student = (Student)SpringContextUtils.getBean(Student.class);
        student.setName("jjjj");
        System.out.println(student);
    }

}
