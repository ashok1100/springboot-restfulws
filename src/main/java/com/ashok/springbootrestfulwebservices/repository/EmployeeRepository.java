package com.ashok.springbootrestfulwebservices.repository;

import com.ashok.springbootrestfulwebservices.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Optional<Employee> findByEmail(String email);
}
