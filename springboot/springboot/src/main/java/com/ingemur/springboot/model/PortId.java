package com.ingemur.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PortId implements Serializable{

	@Column(name ="id")
	private String id;
	
	@Column(name ="olt")
	private String olt;

	public String getIp_address() {
		return id;
	}

	public void setIp_address(String ip_address) {
		this.id = ip_address;
	}

	public String getOlt() {
		return olt;
	}

	public void setOlt(String olt) {
		this.olt = olt;
	}

	public PortId(String portid, String olt) {
		super();
		this.id = portid;
		this.olt = olt;
	}

	public PortId() {
		super();
	}
	
}
