package com.gdg.bhopal.admissionapp;

import java.io.Serializable;

public class AdmissionApp implements Serializable {

    String institute_name;
    String course;
    String student_name;
    String father_name;
    String mother_name;
    String occupation;
    String income;
    String dob;
    String category;
    String address;
    String mobile;

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public String getCourse() {
        return course;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getIncome() {
        return income;
    }

    public String getDob() {
        return dob;
    }

    public String getCategory() {
        return category;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public AdmissionApp(String institute_name, String course, String student_name, String father_name, String mother_name, String occupation, String income, String dob, String category, String address, String mobile) {
        this.institute_name = institute_name;
        this.course = course;
        this.student_name = student_name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.occupation = occupation;
        this.income = income;
        this.dob = dob;
        this.category = category;
        this.address = address;
        this.mobile = mobile;
    }
}
