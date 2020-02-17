package com.tyss.customermanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Repository;

import com.tyss.customermanagement.dto.CustomerInfoBean;
import com.tyss.customermanagement.dto.PartnerInfoBean;
import com.tyss.customermanagement.exception.EmailAlreadyException;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceUnit
	private EntityManagerFactory factory;
	static Logger log=LogManager.getLogger("customer");


	@Override
	public boolean register(PartnerInfoBean bean) {
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
			throw new EmailAlreadyException("Email already exict");

		}
	}



	@Override
	public boolean addPartner(PartnerInfoBean bean, int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			PartnerInfoBean beans=manager.find(PartnerInfoBean.class,id );
			List<PartnerInfoBean> partnerInfoBeans=beans.getPartner();
			partnerInfoBeans.add(bean);
			beans.setPartner(partnerInfoBeans);
			manager.persist(beans);
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


	@Override
	public boolean addCustomer(CustomerInfoBean bean,int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			PartnerInfoBean beans=manager.find(PartnerInfoBean.class,id );
			List<CustomerInfoBean> customerInfoBean=beans.getCustomer();
			customerInfoBean.add(bean);
			beans.setCustomer(customerInfoBean);
			manager.persist(beans);
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


	@Override
	public PartnerInfoBean  getPartnerDetails(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			PartnerInfoBean beans=manager.find(PartnerInfoBean.class, id);			
			transaction.commit();	
			return beans;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}
	}


	@Override
	public boolean deletePartner(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {

			PartnerInfoBean beans=manager.find(PartnerInfoBean.class, id);
			beans.setStatus(true);
			manager.persist(beans);
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
	public boolean deleteCustomer(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {

			CustomerInfoBean beans=manager.find(CustomerInfoBean.class, id);
			beans.setStatus(true);
			manager.persist(beans);
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
	public boolean editCustomer(CustomerInfoBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			CustomerInfoBean beans=manager.find(CustomerInfoBean.class, bean.getCustomeId());
			beans.setEmail(bean.getEmail());
			beans.setMobile(bean.getMobile());
			beans.setName(bean.getName());
			beans.setAddress(beans.getAddress());
			beans.setDateOfBirth(bean.getDateOfBirth());
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
	public List<CustomerInfoBean> findCustomer(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			PartnerInfoBean beans=manager.find(PartnerInfoBean.class, id);			
			transaction.commit();	
			List<CustomerInfoBean> list=beans.getCustomer();
			return list;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}

	}


	@Override
	public CustomerInfoBean getCustomer(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();

		transaction.begin();
		try {
			CustomerInfoBean beans=manager.find(CustomerInfoBean.class, id);			
			transaction.commit();	
			return beans;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}
	}



	@Override
	public List<PartnerInfoBean> getAllPartnerDetails() {



		try {
			EntityManager manager=factory.createEntityManager();
			manager=factory.createEntityManager();
			String jpql="select m from PartnerInfoBean m";
			TypedQuery<PartnerInfoBean> query=manager.createQuery(jpql,PartnerInfoBean.class);
			List<PartnerInfoBean> list= query.getResultList();


			return list;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}










}
