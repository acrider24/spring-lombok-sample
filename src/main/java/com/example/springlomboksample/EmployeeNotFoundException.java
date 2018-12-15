package com.example.springlomboksample;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException() {
        super("Employee not found for id");
    }
}
