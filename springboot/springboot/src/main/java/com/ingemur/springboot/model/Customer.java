package com.ingemur.springboot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "mail")
	private String mail;

	@Column(name = "poblation")
	private String poblation;

	@Column(name = "province")
	private String province;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<Service> serviceCollection;

	public Customer() {
		super();
	}

	public Customer(String name, String address, String mail, String poblation, String province) {
		super();
		this.name = name;
		this.address = address;
		this.mail = mail;
		this.poblation = poblation;
		this.province = province;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPoblation() {
		return poblation;
	}

	public void setPoblation(String poblation) {
		this.poblation = poblation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public Collection<Service> getServiceCollection() {
		return serviceCollection;
	}
	
	public void setServiceCollection(Collection<Service> serviceCollection) {
		this.serviceCollection = serviceCollection;
	}
}
