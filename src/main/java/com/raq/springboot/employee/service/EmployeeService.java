package com.raq.springboot.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raq.springboot.employee.dao.EmployeeDAO;
import com.raq.springboot.employee.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeDAO.findAll().forEach(employees::add);
		System.out.println("EmployeeService.getEmployees() invoked " + employees );
		return employees;
	}
	
	public Employee getEmployee(int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		System.out.println("EmployeeService.getEmployee(id) invoked " + employee );
		return employee.get();
	}

	public void addEmployee(Employee employee) {
		employeeDAO.save(employee);
		System.out.println("EmployeeService.addEmployee() invoked " + employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDAO.save(employee);
		System.out.println("EmployeeService.updateEmployee() invoked " + employee);
		
	}

	public void deleteEmployee(int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		employeeDAO.delete(employee.get());
		System.out.println("EmployeeService.deleteEmployee() invoked " + id);
	}
}
