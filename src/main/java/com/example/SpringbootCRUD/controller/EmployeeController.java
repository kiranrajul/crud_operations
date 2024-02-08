package com.example.SpringbootCRUD.controller;

import com.example.SpringbootCRUD.exception.ResourceNotFound;
import com.example.SpringbootCRUD.model.Employee;
import com.example.SpringbootCRUD.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud/register")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeerepo;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeerepo.findAll();
    }
    //Creating
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeerepo.save(employee);
    }
    //getting details by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee=employeerepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee with" +id+ "doesn't exist"));
        return ResponseEntity.ok(employee);
    }
    //update
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeerepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not exit with id"  +id));
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        updateEmployee.setDOB(employeeDetails.getDOB());
        employeerepo.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployees(@PathVariable long id) {
        Employee employee= employeerepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee doesn't exist"  +id));
        employeerepo.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
