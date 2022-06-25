package com.demo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "patient")

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long patientId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="phone_no")
	private String phoneNo;

	@Column(name="address")
	private String address;
	
	@Column(name="age")
	private String age;
	
	@Column(name="sex")
	private String sex;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_doctors", 
	joinColumns = { @JoinColumn (name = "patient_id")},
	inverseJoinColumns = { @JoinColumn (name = "doctor_id")})
	private Set<Doctor> doctors = new HashSet<Doctor>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="room_id")
	private Room room;


	public Patient(String patientName, String phoneNo, String address, String age, String sex, Set<Doctor> doctors,
			Room room) {
		super();
		this.patientName = patientName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.age = age;
		this.sex = sex;
		this.doctors = doctors;
		this.room = room;
	}




	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Set<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
