package com.tyss.employeapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employeapp.dto.Employe;
import com.tyss.hibernateapp.onetoone.EmployeSecondaryInfo;

public class TestOneToOne {
	public static void main(String[] args) {
		
		Employe primary=new Employe();

		primary.setEmpid(708);
		primary.setEname("Nidhin");
		primary.setPassword("good");
		primary.setAge(20);
		primary.setMobile(55555555555l);
		primary.setSalary(55.2);

		
		
		EmployeSecondaryInfo secondaryInfo=new EmployeSecondaryInfo();
		secondaryInfo.setPrimary(primary);
		secondaryInfo.setEmergency_con_no(9562645921l);
		secondaryInfo.setGardian_name("Nidhin");
		secondaryInfo.setGardian_no(89526458l);
		secondaryInfo.setGender("Male");
		secondaryInfo.setBlood_group("A+");
		secondaryInfo.setGovt_id("22555");
		secondaryInfo.setIs_phy_challnged(true);
		secondaryInfo.setIsmaried(true);
		secondaryInfo.setJob_location("Bnglr");
		secondaryInfo.setKnown_lang("English");
		secondaryInfo.setNationality("India");
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
//			manager.persist(secondaryInfo);
			Employe employe=manager.find(Employe.class,708 );
			System.out.println(employe.getSecondary().getBlood_group());
			transaction.commit();
//			System.out.println("added");

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
			factory.close();
		}


	}

}
