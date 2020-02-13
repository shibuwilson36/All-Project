package com.tyss.mailsimulation.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tyss.mailsimulation.Exception.EmailAlreadyException;
import com.tyss.mailsimulation.Exception.EmailNotExistException;
import com.tyss.mailsimulation.dto.InboxBean;
import com.tyss.mailsimulation.dto.UserInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class MailDaoImpl implements MailDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	@Autowired
	private BCryptPasswordEncoder  encoder;

	@Override
	public boolean register(UserInfoBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		log.info(bean.getEmail());
		log.info(Integer.toString(bean.getId()));
		transaction.begin();
		try {

			bean.setPassword(encoder.encode(bean.getPassword()));
			System.out.println("kjhjh");
			manager.persist(bean);
			transaction.commit();
			System.out.println("kjhjh");
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			throw new EmailAlreadyException("Email already exict");
		}
	}

	@Override
	public UserInfoBean auth(String email, String password) {
		String jpql="select e from UserInfoBean e where e.email=:email";
		EntityManager manager=factory.createEntityManager();	

		try {

			TypedQuery<UserInfoBean> query=manager.createQuery(jpql,UserInfoBean.class);	
			query.setParameter("email",email);

			UserInfoBean bean=query.getSingleResult();
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

	@Override
	public List<InboxBean> getUserInbox(int userId) {

		String jpql="select e from MailInfoBean e where toId=:toId";
		EntityManager manager=factory.createEntityManager();	

		try {

			TypedQuery<InboxBean> query=manager.createQuery(jpql,InboxBean.class);	
			query.setParameter("toId",userId);

			List<InboxBean> bean=query.getResultList();

			return bean;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}
	}

	@Override
	public List<InboxBean> getUserSentBox(int fromId) {
		String jpql="select e from MailInfoBean e where fromId=:fromId";
		EntityManager manager=factory.createEntityManager();	

		try {

			TypedQuery<InboxBean> query=manager.createQuery(jpql,InboxBean.class);	

			query.setParameter("fromId",fromId);

			List<InboxBean> bean=query.getResultList();
			return bean;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}
	}

	@Override
	public int getToId(String email) {

		String jpql="select e from UserInfoBean e where email=:email";
		EntityManager manager=factory.createEntityManager();	

		try {

			TypedQuery<UserInfoBean> query=manager.createQuery(jpql,UserInfoBean.class);	

			query.setParameter("email",email);

			UserInfoBean bean=query.getSingleResult();
			return bean.getId();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			throw new EmailNotExistException("email not found");
		}
	}

	@Override
	public boolean ChangePassword(UserInfoBean beans) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			UserInfoBean bean=manager.find(UserInfoBean.class, beans.getId());
			bean.setPassword(encoder.encode(beans.getPassword()));

			manager.persist(bean);
			transaction.commit();
		
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			throw new EmailAlreadyException("Email already exict");
		}
	}

}
