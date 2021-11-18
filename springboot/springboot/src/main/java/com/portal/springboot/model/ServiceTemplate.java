package com.portal.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_template")
public class ServiceTemplate {
	
	@Id
	@Column(name = "id")
	private long id;
	
	@JoinColumn(name = "inbound_traffic_profile", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(optional = false)
	private Profile inboundTraffic;
	
	@JoinColumn(name = "outbound_traffic_profile", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(optional = false)
	private Profile outboundTraffic;
	
	@JoinColumn(name = "vlan_data", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
	private Vlan vlanData;
	
	@JoinColumn(name = "vlan_voip", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
	private Vlan vlanVoip;
	
	@JoinColumn(name = "voip_profile", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(optional = false)
	private Profile voipProfile;
	
	@JoinColumn(name = "voip_traffic_profile", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(optional = false)
	private Profile voipTraffic;

	@Column(name = "description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Profile getInboundTraffic() {
		return inboundTraffic;
	}

	public void setInboundTraffic(Profile inboundTraffic) {
		this.inboundTraffic = inboundTraffic;
	}

	public Profile getOutboundTraffic() {
		return outboundTraffic;
	}

	public void setOutboundTraffic(Profile outboundTraffic) {
		this.outboundTraffic = outboundTraffic;
	}

	public Vlan getVlanData() {
		return vlanData;
	}

	public void setVlanData(Vlan vlanData) {
		this.vlanData = vlanData;
	}

	public Vlan getVlanVoip() {
		return vlanVoip;
	}

	public void setVlanVoip(Vlan vlanVoip) {
		this.vlanVoip = vlanVoip;
	}

	public Profile getVoipProfile() {
		return voipProfile;
	}

	public void setVoipProfile(Profile voipProfile) {
		this.voipProfile = voipProfile;
	}

	public Profile getVoipTraffic() {
		return voipTraffic;
	}

	public void setVoipTraffic(Profile voipTraffic) {
		this.voipTraffic = voipTraffic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceTemplate(long id, Profile inboundTraffic, Profile outboundTraffic, Vlan vlanData, Vlan vlanVoip,
			Profile voipProfile, Profile voipTraffic, String description) {
		super();
		this.id = id;
		this.inboundTraffic = inboundTraffic;
		this.outboundTraffic = outboundTraffic;
		this.vlanData = vlanData;
		this.vlanVoip = vlanVoip;
		this.voipProfile = voipProfile;
		this.voipTraffic = voipTraffic;
		this.description = description;
	}

	public ServiceTemplate() {
		super();
	}
	
	
}
