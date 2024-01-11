package com.jdjm.zhy;


import com.jdjm.zhy.entity.TStudent;
import com.jdjm.zhy.testTransactional.TestTransaction;
import com.jdjm.zhy.utils.SpringContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Context1 {

    public static void main(String[] args) {
        SpringApplication.run(Context1.class, args);
    }

}
