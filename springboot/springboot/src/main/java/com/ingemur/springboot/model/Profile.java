package com.ingemur.springboot.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "profile_id", nullable = false) 
	private int profileId;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inboundTraffic")
	private Collection<ServiceTemplate> collectionInboundTrafficProfiles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "outboundTraffic")
	private Collection<ServiceTemplate> collectionOutboundTrafficProfiles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "voipTraffic")
	private Collection<ServiceTemplate> collectionVoipTrafficProfiles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "voipProfile")
	private Collection<ServiceTemplate> collectionVoipProfiles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<ServiceTemplate> getCollectionInboundTrafficProfiles() {
		return collectionInboundTrafficProfiles;
	}

	public void setCollectionInboundTrafficProfiles(Collection<ServiceTemplate> collectionInboundTrafficProfiles) {
		this.collectionInboundTrafficProfiles = collectionInboundTrafficProfiles;
	}

	public Collection<ServiceTemplate> getCollectionOutboundTrafficProfiles() {
		return collectionOutboundTrafficProfiles;
	}

	public void setCollectionOutboundTrafficProfiles(Collection<ServiceTemplate> collectionOutboundTrafficProfiles) {
		this.collectionOutboundTrafficProfiles = collectionOutboundTrafficProfiles;
	}

	public Collection<ServiceTemplate> getCollectionVoipTrafficProfiles() {
		return collectionVoipTrafficProfiles;
	}

	public void setCollectionVoipTrafficProfiles(Collection<ServiceTemplate> collectionVoipTrafficProfiles) {
		this.collectionVoipTrafficProfiles = collectionVoipTrafficProfiles;
	}

	public Collection<ServiceTemplate> getCollectionVoipProfiles() {
		return collectionVoipProfiles;
	}

	public void setCollectionVoipProfiles(Collection<ServiceTemplate> collectionVoipProfiles) {
		this.collectionVoipProfiles = collectionVoipProfiles;
	}

	public Profile() {
		super();
	}

	public Profile(long id, int profileId, String description,
			Collection<ServiceTemplate> collectionInboundTrafficProfiles,
			Collection<ServiceTemplate> collectionOutboundTrafficProfiles,
			Collection<ServiceTemplate> collectionVoipTrafficProfiles,
			Collection<ServiceTemplate> collectionVoipProfiles) {
		super();
		this.id = id;
		this.profileId = profileId;
		this.description = description;
		this.collectionInboundTrafficProfiles = collectionInboundTrafficProfiles;
		this.collectionOutboundTrafficProfiles = collectionOutboundTrafficProfiles;
		this.collectionVoipTrafficProfiles = collectionVoipTrafficProfiles;
		this.collectionVoipProfiles = collectionVoipProfiles;
	}

	
	
	
}
