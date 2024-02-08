package com.example.SpringbootCRUD;

import com.example.SpringbootCRUD.model.Employee;
import com.example.SpringbootCRUD.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setName("kiran");
		employee.setEmailId("kiran@gmail.com");
		employee.setDOB("2001-03-14");
		employeeRepo.save(employee);

	}
}
