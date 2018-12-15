package com.example.springlomboksample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Slf4j
@Configuration
public class LoadDatabase implements CommandLineRunner {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Running");
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(log::info);
        log.info("Done");

        repository.save(new Employee("Joey Diaz","Comedian"));
        repository.save(new Employee("Joe Rogan","Comedian"));
        repository.save(new Employee("Jen Jones","Server"));

        log.info("Show Employees");
        repository.findAll().forEach(employee -> log.info(employee.toString()));
    }
}
