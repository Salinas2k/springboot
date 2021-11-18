package com.portal.springboot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "port")
public class Port {

	@EmbeddedId
	protected PortId portId;
	
	@Column(name = "slot")
	private String slot;
	
	@Column(name = "pon")
	private String pon;
	
	@Column(name = "description")
	private String description;
	
	@JoinColumn(name = "olt", referencedColumnName = "ip_address", nullable = false, insertable = false, updatable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Olt olt_port;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "port")
    private Collection<Service> serviceCollection;

	public PortId getId() {
		return portId;
	}

	public void setId(PortId id) {
		this.portId = id;
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
		return olt_port;
	}

	public void setOlt(Olt olt) {
		this.olt_port = olt;
	}

	public Port(PortId id, String slot, String pon, String description, Olt olt) {
		super();
		this.portId = id;
		this.slot = slot;
		this.pon = pon;
		this.description = description;
		this.olt_port = olt;
	}

	public Port() {
		super();
	}
	
	
	
}
