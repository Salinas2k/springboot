package com.portal.springboot.model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Column(name = "email")
	private String email;

	@Column(name = "date_birth")
	private Date dateBirth;

	@Column(name = "phone")
	private String phone;

	@Column(name = "surname")
	private String surname;

	@Column(name = "profession")
	private String profession;

	@Column(name = "company")
	private String company;

	@Column(name = "volunteer")
	private boolean volunteer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Collection<Contact> contactCollection;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Subscription subscription;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private MedicalData medicalData;

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Activities> activitiesCollection;

	public Customer() {
		super();
	}

	public Customer(String name, String address, String email, Date dateBirth, String phone, String surname,
			String profession, String company) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.dateBirth = dateBirth;
		this.phone = phone;
		this.surname = surname;
		this.profession = profession;
		this.company = company;
		this.volunteer = false;
		this.medicalData = null;
	}

	public Customer(String name, String address, String email, Date dateBirth, String phone, String surname,
			String profession, String company, boolean volunteer) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.dateBirth = dateBirth;
		this.phone = phone;
		this.surname = surname;
		this.profession = profession;
		this.company = company;
		this.volunteer = volunteer;
		this.medicalData = null;
	}

	public Customer(String name, String address, String email, Date dateBirth, String phone, String surname,
			String profession, String company, boolean volunteer, MedicalData medicalData) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.dateBirth = dateBirth;
		this.phone = phone;
		this.surname = surname;
		this.profession = profession;
		this.company = company;
		this.volunteer = volunteer;
		this.medicalData = medicalData;
	}

	public long getId() {
		return id;
	}

	public Date getDateBirth() {
		return this.dateBirth;
	}

	public void setDateBirth(Date newDateBirth) {
		this.dateBirth = newDateBirth;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVolunteer() {
		return volunteer;
	}

	public void setVolunteer(boolean volunteer) {
		this.volunteer = volunteer;
	}

	public Collection<Contact> getContactCollection() {
		return contactCollection;
	}

	public void setContactCollection(Collection<Contact> contactCollection) {
		this.contactCollection = contactCollection;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public MedicalData getMedicalData() {
		return medicalData;
	}

	public void setMedicalData(MedicalData medicalData) {
		this.medicalData = medicalData;
	}

	public Collection<Activities> getActivitiesCollection() {
		return activitiesCollection;
	}

	public void setActivitiesCollection(Collection<Activities> activitiesCollection) {
		this.activitiesCollection = activitiesCollection;
	}
}
