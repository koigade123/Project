package com.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")

public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private long doctorId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="location")
	private String location;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="dept_id")
	private Department department;

	public Doctor(String name, String specialization, String phoneNo, String location, Department department) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.phoneNo = phoneNo;
		this.location = location;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
