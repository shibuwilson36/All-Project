package com.tyss.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springboot.dto.ProductInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class ProductInfoDaoImpl implements ProductInfoDao {
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	

	@Override
	public boolean addProduct(ProductInfoBean bean) {
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
	public boolean updateProduct(ProductInfoBean beans) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
System.out.println(beans);
			ProductInfoBean bean=manager.find(ProductInfoBean.class, beans.getId());
			bean.setProductName(beans.getProductName());
			bean.setPrice(beans.getPrice());
			bean.setQuntity(beans.getQuntity());
			bean.setDescription(beans.getDescription());
			bean.setProductImage(beans.getProductImage());
			System.out.println("hjyguy"+bean);
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
	public List<ProductInfoBean> getAllProduct() {
		String jpql="select e from ProductInfoBean e";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<ProductInfoBean> query=manager.createQuery(jpql,ProductInfoBean.class);	
		
		try {
			List< ProductInfoBean> beans=query.getResultList();
			return beans;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ProductInfoBean> searchProduct(String name) {
		String jpql="select e from ProductInfoBean e where e.productName=:name";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<ProductInfoBean> query=manager.createQuery(jpql,ProductInfoBean.class);	
		query.setParameter("name",name);
		try {
			List< ProductInfoBean> beans=query.getResultList();
			return beans;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		ProductInfoBean bean=manager.find(ProductInfoBean.class, id);
		manager.remove(bean);
		transaction.commit();
		return true;
	}

}
