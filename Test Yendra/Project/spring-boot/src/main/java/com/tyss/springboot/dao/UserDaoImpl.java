package com.tyss.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tyss.springboot.dto.InboxBean;
import com.tyss.springboot.dto.UserPrimaryBean;
import com.tyss.springboot.dto.UserSecondaryBean;

import lombok.extern.java.Log;

@Repository
@Log
public class UserDaoImpl implements UserDao {

	@PersistenceUnit
	private EntityManagerFactory factory;
	@Autowired
	private BCryptPasswordEncoder  encoder;
	
	@Override
	public boolean registerUserPrimary(UserPrimaryBean primaryBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
	
		transaction.begin();
		try {

			primaryBean.setPassword(encoder.encode(primaryBean.getPassword()));
			
			manager.persist(primaryBean);
			transaction.commit();
			System.out.println("kjhjh");
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
	public boolean sentMessage(InboxBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
	
		transaction.begin();
		try {				
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

	

}
