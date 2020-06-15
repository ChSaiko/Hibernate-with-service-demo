package com.sftl.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sftl.springboot.cruddemo.dao.EmployeeDAO;
import com.sftl.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	//DI
	private EmployeeDAO employeeDAO;
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}
	@Override
	@Transactional
	public List<Employee> finAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional

	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional

	public void saveEmploye(Employee theEmployee) {
			employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional

	public void deleteEmployee(int theId) {
		employeeDAO.deleteEmployee(theId);
	}

}
