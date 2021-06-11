package com.example.bloodbank;

public class BloodBank {
    private String Location;
    private String Phone;
    private String Email;
    private Integer APlus;
    private Integer BPlus;
    private Integer OPlus;
    private Integer ABPlus;
    private Integer AMinus;
    private Integer BMinus;
    private Integer OMinus;
    private Integer ABMinus;

    public BloodBank() {
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAPlus() {
        return APlus;
    }

    public void setAPlus(Integer APlus) {
        this.APlus = APlus;
    }

    public Integer getBPlus() {
        return BPlus;
    }

    public void setBPlus(Integer BPlus) {
        this.BPlus = BPlus;
    }

    public Integer getOPlus() {
        return OPlus;
    }

    public void setOPlus(Integer OPlus) {
        this.OPlus = OPlus;
    }

    public Integer getABPlus() {
        return ABPlus;
    }

    public void setABPlus(Integer ABPlus) {
        this.ABPlus = ABPlus;
    }

    public Integer getAMinus() {
        return AMinus;
    }

    public void setAMinus(Integer AMinus) {
        this.AMinus = AMinus;
    }

    public Integer getBMinus() {
        return BMinus;
    }

    public void setBMinus(Integer BMinus) {
        this.BMinus = BMinus;
    }

    public Integer getOMinus() {
        return OMinus;
    }

    public void setOMinus(Integer OMinus) {
        this.OMinus = OMinus;
    }

    public Integer getABMinus() {
        return ABMinus;
    }

    public void setABMinus(Integer ABMinus) {
        this.ABMinus = ABMinus;
    }
}
