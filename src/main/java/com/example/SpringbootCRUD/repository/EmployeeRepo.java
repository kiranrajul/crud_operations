package com.example.SpringbootCRUD.repository;

import com.example.SpringbootCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    //ALl crud methods
}
