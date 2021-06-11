package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BloodBank implements Map<String, Object> {
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

    public void put(String aPlus, int aplus, String bPlus, int bplus, String oPlus, int oplus, String abPlus, int abplus, String aMinus, int aminus, String bMinus, int bminus, String oMinus, int ominus, String abMinus, int abminus) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        return false;
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return false;
    }

    @Nullable
    @Override
    public Object get(@Nullable Object key) {
        return null;
    }

    @Nullable
    @Override
    public Object put(String key, Object value) {
        return null;
    }

    @Nullable
    @Override
    public Object remove(@Nullable Object key) {
        return null;
    }

    @Override
    public void putAll(@NonNull Map<? extends String, ?> m) {

    }

    @Override
    public void clear() {

    }

    @NonNull
    @Override
    public Set<String> keySet() {
        return null;
    }

    @NonNull
    @Override
    public Collection<Object> values() {
        return null;
    }

    @NonNull
    @Override
    public Set<Entry<String, Object>> entrySet() {
        return null;
    }
}
