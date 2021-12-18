package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.employeedao.EmployeeDAO;
import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emplist")
	public String empList(Model theModel) {

		List<Employee> theemployees = employeeService.getEmployees();
		theModel.addAttribute("emp", theemployees);
		return "emp-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormformAdd(Model theModel) {

		Employee employee = new Employee();
		theModel.addAttribute("emp", employee);

		return "employee-Form";
	}
	
	@PostMapping("/saveEmployee")
	public String  saveEmployee(@ModelAttribute("emp")Employee theemployee){
		employeeService.saveEmployee(theemployee);
		return "redirect:/employee/emplist";
	}
	
	@GetMapping("/showFormForUpdate")
	public String  editEmployee(@RequestParam("employeeId")int theId,Model theModel){
		
		Employee theEmployee = employeeService.getEmployee(theId);
		theModel.addAttribute("emp",theEmployee);
		return  "employee-Form";
	}
	
	@GetMapping("/employeeDelete")
	public  String deleteEmployee(@RequestParam("employeeId")int theId){
		
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/emplist";
		
	}
}
