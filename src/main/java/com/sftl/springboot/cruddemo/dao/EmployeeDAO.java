package com.sftl.springboot.cruddemo.dao;

import java.util.List;

import com.sftl.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteEmployee(int theID);
}
