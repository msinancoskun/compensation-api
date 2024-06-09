package com.carla.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Annual Base Pay")
    private String salary;

    @JsonProperty("Employer")
    private String employer;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("Years at Employer")
    private String yearsAtWork;

    @JsonProperty("Years of Experience")
    private String yearsOfExperience;

    @JsonProperty("Job title")
    private String title;

    @JsonProperty("Signing Bonus")
    private String signInBonus;

    @JsonProperty("Annual Bonus")
    private String annualBonus;

    @JsonProperty("Annual Stock Value/Bonus")
    private String annualStockBonus;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Additional Comment")
    @Column(length = 2000)
    private String additionalComment;

    @JsonProperty("Timestamp")
    private String timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public String getYearsAtWork() {
        return yearsAtWork;
    }

    public void setYearsAtWork(String yearsAtWork) {
        this.yearsAtWork = yearsAtWork;
    }

    public String getSignInBonus() {
        return signInBonus;
    }

    public void setSignInBonus(String signInBonus) {
        this.signInBonus = signInBonus;
    }

    public String getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(String annualBonus) {
        this.annualBonus = annualBonus;
    }

    public String getAnnualStockBonus() {
        return annualStockBonus;
    }

    public void setAnnualStockBonus(String annualStockBonus) {
        this.annualStockBonus = annualStockBonus;
    }

}