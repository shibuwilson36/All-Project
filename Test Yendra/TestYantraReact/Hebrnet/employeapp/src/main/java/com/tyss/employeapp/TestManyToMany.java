package com.tyss.employeapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employeapp.dto.Employe;
import com.tyss.hibernateapp.manytoMany.ProjectInfo;
import com.tyss.hibernateapp.onetoone.EmployeSecondaryInfo;

public class TestManyToMany {
	public static void main(String[] args) {
		
		Employe primary=new Employe();

		
		primary.setEname("Nidhin");
		primary.setPassword("good");
		primary.setAge(20);
		primary.setMobile(55555555555l);
		primary.setSalary(55.2);
		
//		Employe primary2=new Employe();
//		
//		primary2.setEname("Shibu");
//		primary2.setPassword("good");
//		primary2.setAge(20);
//		primary2.setMobile(55555555555l);
//		primary2.setSalary(55.2);
//		
		List<Employe> list=new ArrayList<Employe>();
		list.add(primary);
//		list.add(primary2);
		
		ProjectInfo projectInfo=new ProjectInfo();
		projectInfo.setPrimary(list);
		
		
		projectInfo.setProject_name("Robo");
		projectInfo.setEnd_date("1999-05-05");
		projectInfo.setStart_date("1999-05-05");
		projectInfo.setLocation("Bnglr");
		projectInfo.setTechnology("java");
		
		ProjectInfo projectInfo2=new ProjectInfo();
		projectInfo2.setPrimary(list);
		projectInfo2.setProject_name("Robo");
		projectInfo2.setEnd_date("1999-05-05");
		projectInfo2.setStart_date("1999-05-05");
		projectInfo2.setLocation("Bnglr");
		projectInfo2.setTechnology("java");
		 List< ProjectInfo> projectInfos=new ArrayList<ProjectInfo>();
		 projectInfos.add(projectInfo);
		 projectInfos.add(projectInfo2);
		 
		primary.setProjectInfos(projectInfos);
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
//			manager.persist(projectInfo);
			manager.persist(primary);
		
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
