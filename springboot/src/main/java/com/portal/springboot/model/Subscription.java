package com.portal.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "adirmu_status")
    private boolean adirmuStatus;

    @Column(name = "adirmu_startdate")
    private Date adirmuStartDate;

    @Column(name = "adirmu_enddate")
    private Date adirmuEndDate;

    @Column(name = "account")
    private String account;

    @Column(name = "periodity")
    @Enumerated(EnumType.STRING)
    private Periocity periocity;

    @Column(name = "cash")
    private boolean cash;

    @Column(name = "payment_day")
    private Date paymentDay;

    @Column(name = "reason")
    private String reason;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Subscription() {
        super();
    }

    public Subscription(boolean adirmuStatus, Date adirmuStartDate, Date adirmuEndDate, String account,
            Periocity periocity, boolean cash, Date paymentDay, String reason, Customer customer) {
        this.adirmuStatus = adirmuStatus;
        this.adirmuStartDate = adirmuStartDate;
        this.adirmuEndDate = adirmuEndDate;
        this.account = account;
        this.periocity = periocity;
        this.cash = cash;
        this.paymentDay = paymentDay;
        this.reason = reason;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public boolean isAdirmuStatus() {
        return adirmuStatus;
    }

    public void setAdirmuStatus(boolean adirmuStatus) {
        this.adirmuStatus = adirmuStatus;
    }

    public Date getAdirmuStartDate() {
        return adirmuStartDate;
    }

    public void setAdirmuStartDate(Date adirmuStartDate) {
        this.adirmuStartDate = adirmuStartDate;
    }

    public Date getAdirmuEndDate() {
        return adirmuEndDate;
    }

    public void setAdirmuEndDate(Date adirmuEndDate) {
        this.adirmuEndDate = adirmuEndDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Periocity getPeriocity() {
        return periocity;
    }

    public void setPeriocity(Periocity periocity) {
        this.periocity = periocity;
    }

    public boolean isCash() {
        return cash;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }

    public Date getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Date paymentDay) {
        this.paymentDay = paymentDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
