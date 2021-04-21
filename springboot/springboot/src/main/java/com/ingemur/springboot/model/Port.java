package com.ingemur.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "port")
public class Port {

	@EmbeddedId
	protected PortId id;
	
	@Column(name = "slot")
	private String slot;
	
	@Column(name = "pon")
	private String pon;
	
	@Column(name = "description")
	private String description;
	
	@JoinColumn(name = "olt", referencedColumnName = "ip_address", nullable = false, insertable = false, updatable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Olt olt;

	public PortId getId() {
		return id;
	}

	public void setId(PortId id) {
		this.id = id;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getPon() {
		return pon;
	}

	public void setPon(String pon) {
		this.pon = pon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Olt getOlt() {
		return olt;
	}

	public void setOlt(Olt olt) {
		this.olt = olt;
	}

	public Port(PortId id, String slot, String pon, String description, Olt olt) {
		super();
		this.id = id;
		this.slot = slot;
		this.pon = pon;
		this.description = description;
		this.olt = olt;
	}

	public Port() {
		super();
	}
	
	
	
}
