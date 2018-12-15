package com.example.springlomboksample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employee")
    public Iterable<Employee> showEmployees(){
        return repository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee showEmployee(@PathVariable int id) throws Exception {
        return repository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @PostMapping("/employee")
    public Employee loadEmployee(@RequestParam Employee employee) {
        return repository.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void removeEmployee(@PathVariable int id) throws Exception {
        log.info("Removing employee "+repository.findById(id).orElseThrow(EmployeeNotFoundException::new).toString());
        repository.deleteById(id);
        log.info("Removed employee "+id);
    }
}
