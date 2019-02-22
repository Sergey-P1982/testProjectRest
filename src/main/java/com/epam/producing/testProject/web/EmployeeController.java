package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exception.EmployeeNotFoundException;
import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
        return new ResponseEntity<>(repository.save(newEmployee), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        return  repository.findById(id)
                .orElseThrow(() ->new EmployeeNotFoundException(id));
    }

//
//    List<Employee> all() {return repository.findAll();}
//    PostMapping("/employees")

}
