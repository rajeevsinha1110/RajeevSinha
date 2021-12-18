package com.luv2code.springdemo.employeedao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	private  SessionFactory sessionFactory;

	
	public List<Employee> getEmployees() {
		
		Session session =sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee order by name ",Employee.class);
		List<Employee> employees= query.getResultList();
		return employees;
	}


	@Override
	public void saveEmployee(Employee theemployee) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(theemployee);
		
	}


	@Override
	public Employee getEmployee(int theId) {
		
		Session session =sessionFactory.getCurrentSession();
		Employee theemployee = session.get(Employee.class, theId);
		return theemployee;
	}


	@Override
	public void deleteCustomer(int theId) {
		Session session =sessionFactory.getCurrentSession();
		Query query =session.createQuery("delete from  Employee where id=:theempId");
		query.setParameter("theempId",theId);
		
		query.executeUpdate();
		
	}

	

}
