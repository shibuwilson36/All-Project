package com.tyss.hibernateapp.manytoMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tyss.employeapp.dto.Employe;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="project_info")
public class ProjectInfo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int project_id;
	@Column
	private String project_name;
	@Column
	private String technology;
	@Column
	private String location;
	@Column
	private String start_date;
	@Column
	private String end_date;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="emp_project_info",joinColumns = @JoinColumn(name="project_id"),inverseJoinColumns = @JoinColumn(name="empid"))
	private List<Employe> primary;
	

}
