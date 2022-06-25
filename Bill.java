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
@Table(name = "bills")

public class Bill 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_no")
	private long billNo;
	
	@Column(name="amount")
	private double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="patient_id")
	private Patient patient;

	public Bill(double amount, Patient patient) {
		super();
		this.amount = amount;
		this.patient = patient;
	}

	public long getBillNo() {
		return billNo;
	}

	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
