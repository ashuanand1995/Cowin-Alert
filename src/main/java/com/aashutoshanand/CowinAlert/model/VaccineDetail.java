package com.aashutoshanand.CowinAlert.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "center_id", "name", "address", "state_name", "district_name", "block_name", "pincode", "from",
		"to", "lat", "long", "fee_type", "session_id", "date", "available_capacity", "available_capacity_dose1",
		"available_capacity_dose2", "fee", "min_age_limit", "allow_all_age", "vaccine", "slots" })

public class VaccineDetail {

    private String centreName;
    private String address;
    private String districtName;
    private Integer pincode;
    private String date;
    private String timePeriod;
    private String feeType;
    private String vaccineName;
    private Integer availableCapacityDose1;
    private Integer availableCapacityDose2;
    
    public String getCentreName() {
        return centreName;
    }
    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public Integer getPincode() {
        return pincode;
    }
    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTimePeriod() {
        return timePeriod;
    }
    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }
    public String getFeeType() {
        return feeType;
    }
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
    public String getVaccineName() {
        return vaccineName;
    }
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    public Integer getAvailableCapacityDose1() {
        return availableCapacityDose1;
    }
    public void setAvailableCapacityDose1(Integer availableCapacityDose1) {
        this.availableCapacityDose1 = availableCapacityDose1;
    }
    public Integer getAvailableCapacityDose2() {
        return availableCapacityDose2;
    }
    public void setAvailableCapacityDose2(Integer availableCapacityDose2) {
        this.availableCapacityDose2 = availableCapacityDose2;
    }
	

}
