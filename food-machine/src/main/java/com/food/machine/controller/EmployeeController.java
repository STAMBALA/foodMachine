package com.food.machine.controller;

import com.food.machine.entity.EmployeeDetailsEntity;
import com.food.machine.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @PostMapping("/id")
    public ResponseEntity<EmployeeDetailsEntity> createEmployee(@RequestBody EmployeeDetailsEntity employeeDetails) {
        EmployeeDetailsEntity createdEmployee = employeeService.saveEmployees(employeeDetails);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/low-salary")
    public List<EmployeeDetailsEntity> getLowSalaryEmployees(@RequestParam double salary) {
        return employeeService.filterSalaryBase(salary);
    }
}