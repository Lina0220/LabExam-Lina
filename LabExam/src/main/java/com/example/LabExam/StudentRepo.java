package com.example.LabExam.;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public StudentRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createDBAndTable() {
        String createDB = "CREATE DATABASE IF NOT EXISTS LabExamDB";
        String useDB = "USE LabExamDB"; // Add this line to select the database
        String createTable = "CREATE TABLE IF NOT EXISTS Student (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))";

        jdbcTemplate.execute(createDB);
        jdbcTemplate.execute(useDB);
        jdbcTemplate.execute(createTable);
    }

    public void insertIntoTable(Student student) {
        String insertSQL = "INSERT INTO Student (name, email) VALUES (?, ?)";
        jdbcTemplate.update(insertSQL, student.getName(), student.getEmail());
    }
}




