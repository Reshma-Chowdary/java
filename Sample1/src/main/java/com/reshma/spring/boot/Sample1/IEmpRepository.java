package com.reshma.spring.boot.Sample1;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IEmpRepository {
	public List<Employee> getAllEmployees();

	public void addEmployee(Employee emp);

}
