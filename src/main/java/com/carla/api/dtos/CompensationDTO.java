package com.carla.api.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompensationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer salary;
    private String employer;
    private String location;
    private int yearsAtWork;
    private int yearsOfExperience;
    private String title;
    private Integer signInBonus;
    private Integer annualBonus;
    private Integer annualStockBonus;
    private String gender;
    private String additionalComment;
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = this.normalize(salary);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try {
            Date parsedDate = dateFormat.parse(time);
            this.timestamp = parsedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    private Integer normalize(String salary) {
        String pattern = "(?i)(?:^|(?<=\\s))(?:[\\$£]|USD|EUR|GBP|CAD)?\\s?([\\d,]+(?:\\.\\d{2})?)(?:\\s?(?:thousand|k|m(?:illion)?))?\\s?(?:USD|EUR|GBP|CAD)?(?:\\s|\\b)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(salary);
        int returnValue = 0;

        while (m.find()) {
            String match = m.group(1).replaceAll(",", "");
            returnValue = (int) Math.round(Double.parseDouble(match));
        }

        return returnValue;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public int getYearsAtWork() {
        return yearsAtWork;
    }

    public void setYearsAtWork(String yearsAtWork) {
        this.yearsAtWork = normalize(yearsAtWork);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = normalize(yearsOfExperience);
    }

    public Integer getSignInBonus() {
        return signInBonus;
    }

    public void setSignInBonus(String signInBonus) {
        this.signInBonus = normalize(signInBonus);
    }

    public Integer getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(String annualBonus) {
        this.annualBonus = normalize(annualBonus);
    }

    public Integer getAnnualStockBonus() {
        return annualStockBonus;
    }

    public void setAnnualStockBonus(String annualStockBonus) {
        this.annualStockBonus = normalize(annualStockBonus.toString());
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

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
