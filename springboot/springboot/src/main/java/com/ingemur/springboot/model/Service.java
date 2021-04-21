package com.ingemur.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "service")
public class Service {

	@Id
	@Column(name = "serviceid", nullable = false)
	private Integer id;
	
	@Column(name = "onu_sn", nullable = false, length = 16)
	private String onuSn;
	
	@Column(name = "line1_user", length = 32)
	private String line1User;
	
	@Column(name = "line1_password", length = 32)
	private String line1Password;
	
	@Column(name = "line1_phone", length = 9)
	private String line1Phone;
	
	@Column(name = "line1_active", nullable = false)
	private boolean line1Active;
	
	@Column(name = "line2_user", length = 32)
	private String line2User;
	
	@Column(name = "line2_password", length = 32)
	private String line2Password;
	
	@Column(name = "line2_phone", length = 9)
	private String line2Phone;
	
	@Column(name = "line2_active", nullable = false)
	private boolean line2Active;
	
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "data_active", nullable = false)
    private boolean dataActive;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "onu_id", nullable = false)
    private int onuId;

    @Column(name = "bridge", nullable = false)
    private boolean bridge;

    @Column(name = "catv", nullable = false)
    private boolean catv;
    
    @JoinColumn(name = "customer", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    
    @JoinColumn(name = "line_profile", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(optional = false)
    private Profile lineProfile;
    
    @JoinColumns({
	    @JoinColumn(name = "portid", referencedColumnName = "id", nullable = false),
	    @JoinColumn(name = "portolt", referencedColumnName = "olt", nullable = false)})
    @ManyToOne(optional = false)
    private Port port;
    
    @JoinColumn(name = "server_profile", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(optional = false)
    private Profile serverProfile;
    
    @JoinColumn(name = "service_template", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ServiceTemplate serviceTemplate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOnuSn() {
		return onuSn;
	}

	public void setOnuSn(String onuSn) {
		this.onuSn = onuSn;
	}

	public String getLine1User() {
		return line1User;
	}

	public void setLine1User(String line1User) {
		this.line1User = line1User;
	}

	public String getLine1Password() {
		return line1Password;
	}

	public void setLine1Password(String line1Password) {
		this.line1Password = line1Password;
	}

	public String getLine1Phone() {
		return line1Phone;
	}

	public void setLine1Phone(String line1Phone) {
		this.line1Phone = line1Phone;
	}

	public boolean isLine1Active() {
		return line1Active;
	}

	public void setLine1Active(boolean line1Active) {
		this.line1Active = line1Active;
	}

	public String getLine2User() {
		return line2User;
	}

	public void setLine2User(String line2User) {
		this.line2User = line2User;
	}

	public String getLine2Password() {
		return line2Password;
	}

	public void setLine2Password(String line2Password) {
		this.line2Password = line2Password;
	}

	public String getLine2Phone() {
		return line2Phone;
	}

	public void setLine2Phone(String line2Phone) {
		this.line2Phone = line2Phone;
	}

	public boolean isLine2Active() {
		return line2Active;
	}

	public void setLine2Active(boolean line2Active) {
		this.line2Active = line2Active;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isDataActive() {
		return dataActive;
	}

	public void setDataActive(boolean dataActive) {
		this.dataActive = dataActive;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOnuId() {
		return onuId;
	}

	public void setOnuId(int onuId) {
		this.onuId = onuId;
	}

	public boolean isBridge() {
		return bridge;
	}

	public void setBridge(boolean bridge) {
		this.bridge = bridge;
	}

	public boolean isCatv() {
		return catv;
	}

	public void setCatv(boolean catv) {
		this.catv = catv;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Profile getLineProfile() {
		return lineProfile;
	}

	public void setLineProfile(Profile lineProfile) {
		this.lineProfile = lineProfile;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public Profile getServerProfile() {
		return serverProfile;
	}

	public void setServerProfile(Profile serverProfile) {
		this.serverProfile = serverProfile;
	}

	public ServiceTemplate getServiceTemplate() {
		return serviceTemplate;
	}

	public void setServiceTemplate(ServiceTemplate serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}

	public Service() {
		super();
        this.startDate = new Date();
	}

	public Service(Integer id, String onuSn, String line1User, String line1Password, String line1Phone,
			boolean line1Active, String line2User, String line2Password, String line2Phone, boolean line2Active,
			Date startDate, Date endDate, boolean dataActive, int status, int onuId, boolean bridge, boolean catv,
			Customer customer, Profile lineProfile, Port port, Profile serverProfile, ServiceTemplate serviceTemplate) {
		super();
		this.id = id;
		this.onuSn = onuSn;
		this.line1User = line1User;
		this.line1Password = line1Password;
		this.line1Phone = line1Phone;
		this.line1Active = line1Active;
		this.line2User = line2User;
		this.line2Password = line2Password;
		this.line2Phone = line2Phone;
		this.line2Active = line2Active;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dataActive = dataActive;
		this.status = status;
		this.onuId = onuId;
		this.bridge = bridge;
		this.catv = catv;
		this.customer = customer;
		this.lineProfile = lineProfile;
		this.port = port;
		this.serverProfile = serverProfile;
		this.serviceTemplate = serviceTemplate;
	}
	
    
    
}
