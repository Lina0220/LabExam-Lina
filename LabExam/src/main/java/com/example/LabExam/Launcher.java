package com.example.LabExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentRepo studentRepo = (StudentRepo) context.getBean("studentRepo");

        studentRepo.createDBAndTable();

        Student student = new Student(1, "Lina Abdulfetha", "linuaman2017@gmail.com");
        studentRepo.insertIntoTable(student);

        System.out.println("Database and table created, student inserted.");
    }
}


