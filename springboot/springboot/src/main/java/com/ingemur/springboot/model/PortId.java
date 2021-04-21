package com.ingemur.springboot.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PortId {

	@Column(name ="id")
	private String portid;
	
	@Column(name ="olt")
	private String olt;

	public String getIp_address() {
		return portid;
	}

	public void setIp_address(String ip_address) {
		this.portid = ip_address;
	}

	public String getOlt() {
		return olt;
	}

	public void setOlt(String olt) {
		this.olt = olt;
	}

	public PortId(String portid, String olt) {
		super();
		this.portid = portid;
		this.olt = olt;
	}

	public PortId() {
		super();
	}
	
}
