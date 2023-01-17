package com.axis.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
		
	@Id
	private int customer_id;
	private String full_name;
	private String mail_id;
	private int mobile_no;
	private String order;
	
	public Customer(int customer_id, String full_name, String mail_id, int mobile_no, String order) {
		super();
		this.customer_id = customer_id;
		this.full_name = full_name;
		this.mail_id = mail_id;
		this.mobile_no = mobile_no;
		this.order = order;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public int getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	
	

	
	
	
}