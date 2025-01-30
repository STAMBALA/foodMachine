package com.food.machine.Repository;

import com.food.machine.entity.EmployeeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetailsEntity, Long> {
    @Query("SELECT s FROM EmployeeDetailsEntity s WHERE s.salary < :salary")
    List<EmployeeDetailsEntity> findEmployeesWithSalaryLessThan(@Param("salary") double salary);
}

