package com.luv2code.springdemo.employeedao;

import java.util.List;

import com.luv2code.springdemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee>  getEmployees();

	public void saveEmployee(Employee theemployee);

	public Employee getEmployee(int theId);

	public void deleteCustomer(int theId);
	
	
}
