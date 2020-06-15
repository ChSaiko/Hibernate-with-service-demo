package com.sftl.springboot.cruddemo.service;

import java.util.List;

import com.sftl.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> finAll();

	public Employee findById(int theId);

	public void saveEmploye(Employee theEmployee);

	public void deleteEmployee(int theId);
}
