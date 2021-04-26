package com.ingemur.springboot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "olt")

public class Olt {
	
	@Id
	@Column(name = "ip_address")
	private String ipAddress;
	
	@Column(name = "community")
	private String rwCommunity;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "olt_port")
	private Collection<Port> ports;
	
	public Olt() {
		super();
	}

	public Olt(String ipAddress, String rwCommunity, String description) {
		super();
		this.ipAddress = ipAddress;
		this.rwCommunity = rwCommunity;
		this.description = description;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRwCommunity() {
		return rwCommunity;
	}

	public void setRwCommunity(String rwCommunity) {
		this.rwCommunity = rwCommunity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
