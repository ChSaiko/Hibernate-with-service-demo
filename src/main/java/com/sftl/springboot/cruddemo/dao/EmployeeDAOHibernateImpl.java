package com.sftl.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sftl.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entityManager
	private EntityManager entityManager;

	/*
	 * set up constructor injection, here when we have one constructor the
	 * @Autowired is a option because spring when retrieve one constructor know that
	 * is a DI
	 */
	/*
	 * we can do the DEPENDENCY INJECTION with setter method or constructor, we
	 * should declare the DI in the DAOImpl public void
	 * setEntityManager(EntityManager entityManager) { this.entityManager =
	 * entityManager; }
	 */
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	// @Transactional // Handles transaction management so we don't have to manually
	// start and commit transaction(entityManager.commit.begin.rolback)
	public List<Employee> findAll() {
		// get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		// return the result
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteEmployee(int theID) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theID);
		theQuery.executeUpdate();
	}

}
