package com.example.demo.proxy;

import com.example.demo.bean.Person;
import com.example.demo.bean.Student;

/**
 * @author wuyj38634
 * @date 2021/08/06
 */
public class StudentStaticProxy implements Person {

    // 被代理的学生对象
    private Student student;

    public StudentStaticProxy(Person student){
        // 只代理学生对象
        if(student.getClass() == Student.class) {
            this.student = (Student) student;
        }
    }

    @Override
    public void commitFee(){
        System.out.println(student.getStudentName() + "最近表现不错，成绩有进步");
        this.student.commitFee();
    }

    @Override
    public void commitFeeCheck() {
        this.student.commitFeeCheck();
    }
}
