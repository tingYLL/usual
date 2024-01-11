package com.jdjm.zhy;

import com.jdjm.zhy.testTransactional.TestTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class myTest2 {

    @Autowired
    private TestTransaction testTransaction;

    @Test
    public void test2(){
        testTransaction.test2();
    }
}
