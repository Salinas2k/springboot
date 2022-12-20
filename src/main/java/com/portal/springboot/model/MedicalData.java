package com.portal.springboot.model;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medical_data")
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "diabetes_type")
    @Enumerated(EnumType.STRING)
    private Diabetes diabetesType;

    @Column(name = "debut_date")
    private Date debutDate;

    @Column(name = "patology")
    private String patology;

    @Column(name = "handicap")
    private boolean handicap;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public MedicalData() {
        super();
    }

    public MedicalData(Diabetes diabetesType, Date debutDate, String patology, boolean handicap) {
        this.diabetesType = diabetesType;
        this.debutDate = debutDate;
        this.patology = patology;
        this.handicap = handicap;
    }

    public long getId() {
        return id;
    }

    public Diabetes getDiabetesType() {
        return diabetesType;
    }

    public void setDiabetesType(Diabetes diabetesType) {
        this.diabetesType = diabetesType;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public String getPatology() {
        return patology;
    }

    public void setPatology(String patology) {
        this.patology = patology;
    }

    public boolean isHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}