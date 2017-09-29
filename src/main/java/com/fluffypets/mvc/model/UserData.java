package com.fluffypets.mvc.model;

import java.time.LocalDate;

public class UserData {
    private Integer userDataId;
    private Integer userId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private Boolean married;
    private String district;
    private String area;
    private String street;
    private String app;
    private String primaryNumber;
    private String secondaryNumber;

    public UserData(Integer userDataId, Integer userId, String fullName, LocalDate dateOfBirth, String gender, Boolean married,
                    String district, String area, String street, String app, String primaryNumber, String secondaryNumber) {
        this.userDataId = userDataId;
        this.userId = userId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.married = married;
        this.district = district;
        this.area = area;
        this.street = street;
        this.app = app;
        this.primaryNumber = primaryNumber;
        this.secondaryNumber = secondaryNumber;
    }
    public UserData(Integer userId, String fullName, LocalDate dateOfBirth, String gender, Boolean married,
                    String district, String area, String street, String app, String primaryNumber, String secondaryNumber) {
        this.userId = userId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.married = married;
        this.district = district;
        this.area = area;
        this.street = street;
        this.app = app;
        this.primaryNumber = primaryNumber;
        this.secondaryNumber = secondaryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;

        UserData userData = (UserData) o;

        if (!getUserId().equals(userData.getUserId())) return false;
        if (!getFullName().equals(userData.getFullName())) return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(userData.getDateOfBirth()) : userData.getDateOfBirth() != null)
            return false;
        if (!getGender().equals(userData.getGender())) return false;
        if (!getMarried().equals(userData.getMarried())) return false;
        if (!getDistrict().equals(userData.getDistrict())) return false;
        if (!getArea().equals(userData.getArea())) return false;
        if (!getStreet().equals(userData.getStreet())) return false;
        if (!getApp().equals(userData.getApp())) return false;
        return getPrimaryNumber().equals(userData.getPrimaryNumber()) && (getSecondaryNumber() != null ? getSecondaryNumber().equals(userData.getSecondaryNumber()) : userData.getSecondaryNumber() == null);
    }

    @Override
    public int hashCode() {
        int result = getUserId().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + getGender().hashCode();
        result = 31 * result + getMarried().hashCode();
        result = 31 * result + getDistrict().hashCode();
        result = 31 * result + getArea().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getApp().hashCode();
        result = 31 * result + getPrimaryNumber().hashCode();
        result = 31 * result + (getSecondaryNumber() != null ? getSecondaryNumber().hashCode() : 0);
        return result;
    }

    public Integer getUserDataId() {
        return userDataId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public String getSecondaryNumber() {
        return secondaryNumber;
    }

    public void setUserDataId(Integer userDataId) {
        this.userDataId = userDataId;
    }

    public void setSecondaryNumber(String secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }
}