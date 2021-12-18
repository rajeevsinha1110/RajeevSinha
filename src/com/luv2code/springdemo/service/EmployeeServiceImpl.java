package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.employeedao.EmployeeDAO;
import com.luv2code.springdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	
	@Transactional
	public List<Employee> getEmployees() {
		
		return employeeDAO.getEmployees();
	}


	@Transactional
	public void saveEmployee(Employee theemployee) {
		employeeDAO.saveEmployee(theemployee);
		
	}


	@Transactional
	public Employee getEmployee(int theId) {
		
		return employeeDAO.getEmployee(theId);
	}


	@Transactional
	public void deleteEmployee(int theId) {
		employeeDAO.deleteCustomer(theId);
		
	}


	
}
