package com.projectNanuram.helper;

import java.util.List;

public class DataHelper {

    private String district;

    private List<String> Districts;

    public DataHelper() {
    }

    public DataHelper(String district , List<String> districts) {
        this.district = district;
        Districts = districts;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<String> getDistricts() {
        return Districts;
    }

    public void setDistricts(List<String> districts) {
        Districts = districts;
    }
}
