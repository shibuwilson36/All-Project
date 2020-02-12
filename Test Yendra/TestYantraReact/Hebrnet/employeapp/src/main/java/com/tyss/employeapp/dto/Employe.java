package com.tyss.employeapp.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import com.tyss.hibernateapp.manytoMany.ProjectInfo;
import com.tyss.hibernateapp.manytoone.AddressPK;
import com.tyss.hibernateapp.manytoone.EmployeAdderess;
import com.tyss.hibernateapp.onetoone.EmployeSecondaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name="employe_primary_info")
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int empid;
	@Column
	private String ename;
	@Column
	private int age;
	@Column
	private double salary;
	@Column
	private long mobile;
	@Column
	private String password;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "primary")
	private EmployeSecondaryInfo secondary;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "primary")
	private List<EmployeAdderess> adderess;
	
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "primary")
	private List<ProjectInfo> projectInfos;

	
//	public int getEmpid() {
//		return empid;
//	}
//	public void setEmpid(int empid) {
//		this.empid = empid;
//	}
//	public String getEname() {
//		return ename;
//	}
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public double getSalary() {
//		return salary;
//	}
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//	public long getMobile() {
//		return mobile;
//	}
//	public void setMobile(long mobile) {
//		this.mobile = mobile;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}


}
