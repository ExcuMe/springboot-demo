package com.example.demo.bean;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyj
 * @date 2021/08/06
 */
@Data
public class Student implements Person{

    private String studentName;

    public Student(String studentName){
      this.studentName = studentName;
    }

    @Override
    public void commitFee(){
        System.out.println(studentName + "  commitFee");
    }

    @Override
    public void commitFeeCheck() {
        try{
            // 数钱核对花了5秒钟
            System.out.println(studentName + " startCheck " + new Date());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(studentName + " commitFee " + new Date());
    }


}
