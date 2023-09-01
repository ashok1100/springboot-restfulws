package com.ashok.springbootrestfulwebservices.controller;


import java.util.List;

import com.ashok.springbootrestfulwebservices.dto.EmployeeDto;
import com.ashok.springbootrestfulwebservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employee = employeeService.findAllEmployees();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable("id") Long empId) {
        EmployeeDto employee = employeeService.getEmployeeByid(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long empId,
                                                          @RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(empId);
        EmployeeDto savedEmployee = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId) {
        employeeService.deleteEmployeeById(empId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
