package com.portal.springboot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vlan")
public class Vlan {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vlanData")
	private Collection<ServiceTemplate> serviceTemplateDataCollection;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vlanVoip")
	private Collection<ServiceTemplate> serviceTemplateVoipCollection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<ServiceTemplate> getServiceTemplateDataCollection() {
		return serviceTemplateDataCollection;
	}

	public void setServiceTemplateDataCollection(Collection<ServiceTemplate> serviceTemplateDataCollection) {
		this.serviceTemplateDataCollection = serviceTemplateDataCollection;
	}

	public Collection<ServiceTemplate> getServiceTemplateVoipCollection() {
		return serviceTemplateVoipCollection;
	}

	public void setServiceTemplateVoipCollection(Collection<ServiceTemplate> serviceTemplateVoipCollection) {
		this.serviceTemplateVoipCollection = serviceTemplateVoipCollection;
	}

	public Vlan() {
		super();
	}

	public Vlan(Integer id, String description, Collection<ServiceTemplate> serviceTemplateDataCollection,
			Collection<ServiceTemplate> serviceTemplateVoipCollection) {
		super();
		this.id = id;
		this.description = description;
		this.serviceTemplateDataCollection = serviceTemplateDataCollection;
		this.serviceTemplateVoipCollection = serviceTemplateVoipCollection;
	}
	
}
