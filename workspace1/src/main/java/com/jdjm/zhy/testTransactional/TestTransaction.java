package com.jdjm.zhy.testTransactional;

import com.jdjm.zhy.entity.TStudent;
import com.jdjm.zhy.mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestTransaction {
    @Autowired
    private TStudentMapper tSudentMapper;

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public  void test2(){
        for (int i = 0; i < 3; i++) {
            try {
                all(i);
            }catch (Exception e){
                System.out.println("回滚"+i);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void all(int i){
           this.insert("张三"+i);
           if(i == 1){
               this.insertEx("李四"+i);
           }else{
               this.insert("李四"+i);
           }
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void insert(String name){
        tSudentMapper.insert(new TStudent(name));
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void insertEx(String name){
        tSudentMapper.insert(new TStudent(name));
        throw new RuntimeException("ERROR!");
    }
}
