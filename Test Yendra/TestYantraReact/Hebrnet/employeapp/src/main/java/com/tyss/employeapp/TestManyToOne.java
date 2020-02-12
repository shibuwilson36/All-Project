package com.tyss.employeapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employeapp.dto.Employe;
import com.tyss.hibernateapp.manytoone.AddressPK;
import com.tyss.hibernateapp.manytoone.EmployeAdderess;
import com.tyss.hibernateapp.onetoone.EmployeSecondaryInfo;

public class TestManyToOne {
	public static void main(String[] args) {

		Employe primary=new Employe();

		primary.setEmpid(709);
		primary.setEname("Nidhin");
		primary.setPassword("good");
		primary.setAge(20);
		primary.setMobile(55555555555l);
		primary.setSalary(55.2);

		AddressPK addressPK=new AddressPK();
		addressPK.setEmp_id(primary.getEmpid());
		addressPK.setAddress_type("perment");

		EmployeAdderess adderess=new EmployeAdderess();
		adderess.setPrimary(primary);
		adderess.setAddress1("Kannur");
		adderess.setAddress2("Kerala");
		adderess.setCity("kannur");
		adderess.setHouse_no("5225");
		adderess.setLandmark("jhgjghy");
		adderess.setLandmark("oijhug");
		adderess.setPincode(670633);
		adderess.setAddressPK(addressPK);

		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			Employe employe=manager.find(Employe.class, 707);
			//adderess.setPrimary(employe);
			System.out.println(employe.getAdderess().get(0).getAddress1());
			//manager.persist(adderess);
			//			Employe employe=manager.find(Employe.class,708 );
			//			System.out.println(employe.getSecondary().getBlood_group());
			transaction.commit();
			System.out.println("added");

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
			factory.close();
		}


	}

}
