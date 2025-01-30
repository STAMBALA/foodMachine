package com.food.machine.service;

import com.food.machine.entity.EmployeeDetailsEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDetailsEntity> filterSalaryBase(double salaryThreshold);
    EmployeeDetailsEntity saveEmployees(EmployeeDetailsEntity employeeDetails);
}
