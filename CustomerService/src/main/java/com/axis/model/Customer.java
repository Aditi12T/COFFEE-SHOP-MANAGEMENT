package com.axis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="customer")
public class Customer {
	
	//line 17 is commented by me
	//@GeneratedValue(strategy  = GenerationType.AUTO)
    //@GenericGenerator(name = "system-id", strategy = "id")
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotEmpty(message = "Please provide a name")
	private String name;
	

	@Column(name="username")
	@NotEmpty(message = "Please provide a user name")
	private String username;
	
	@Column(name="phoneno")
	@NotEmpty(message = "Please provide an phone no")
	private String phoneno;
	
	@Id
	@Column(name="email", nullable = false)
	@Email(message="please provide a valid email")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	
	@Column(name="password")
	private String password;
	
	

	public Customer(int id, @NotEmpty(message = "Please provide a name") String name,
			@NotEmpty(message = "Please provide a user name") String username,
			@NotEmpty(message = "Please provide an phone no") String phoneno,
			@Email(message = "please provide a valid email") @NotEmpty(message = "Please provide an e-mail") String email,
			String password, @NotEmpty(message = "Please provide an country name") String country) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
		
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		
}