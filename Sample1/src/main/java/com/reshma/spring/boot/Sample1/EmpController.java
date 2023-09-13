package com.reshma.spring.boot.Sample1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	@Autowired
	private IEmpRepository emprepo;

	// mapping the getAllEmployees() method to /employees
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		// finds all the products
		List<Employee> emps = emprepo.getAllEmployees();
		// returns the product list
		System.out.println(emps);
		return emps;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getName() + "sat");

		emprepo.addEmployee(emp);

		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}
}