package com.tyss.empspringmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tyss.empspringmvc.dto.EmployeeInfoBean;

import lombok.extern.java.Log;
@Log
@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	
//	private EntityManagerFactory factory=Persistence.createEntityManagerFactory("employee-unit");
	@PersistenceUnit
	private EntityManagerFactory factory;
//	private BCryptPasswordEncoder  encoder=new BCryptPasswordEncoder();
	@Autowired
	private BCryptPasswordEncoder  encoder;

	@Override
	public EmployeeInfoBean auth(String email, String password) {
		
		String jpql="select e from EmployeeInfoBean e where e.email=:email";
		EntityManager manager=factory.createEntityManager();	
		
		try {
			
			TypedQuery<EmployeeInfoBean> query=manager.createQuery(jpql,EmployeeInfoBean.class);	
			query.setParameter("email",email);
			
			EmployeeInfoBean bean=query.getSingleResult();
			if(encoder.matches(password, bean.getPassword())) {
				return bean;
			}else{
				return null;
			}
			
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}
		
		
	}

	@Override
	public boolean register(EmployeeInfoBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
//			String password=bean.getPassword();
			
			bean.setPassword(encoder.encode(bean.getPassword()));
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return false;
		}
		
	}

	@Override
	public boolean changePassword(int id, String password) {
		
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
			
			EmployeeInfoBean bean=manager.find(EmployeeInfoBean.class, id);	
			bean.setPassword(encoder.encode(password));
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return false;
		}
	}

	@Override
	public List<EmployeeInfoBean> search(String name) {
		
		String jpql="select e from EmployeeInfoBean e where e.name=:name";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<EmployeeInfoBean> query=manager.createQuery(jpql,EmployeeInfoBean.class);	
		query.setParameter("name",name);
		try {
			List< EmployeeInfoBean> beans=query.getResultList();
			return beans;
		} catch (Exception e) {
			return null;
		}
	
	}
	
}
