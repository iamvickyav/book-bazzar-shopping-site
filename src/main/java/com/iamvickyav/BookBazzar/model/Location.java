package com.iamvickyav.BookBazzar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iamvickyav.BookBazzar.dto.PostOffice;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {
    private String status;
    private String pincode;
    private String location;
    private String state;

    public Location() {
    }

    public Location(String status) {
        this.status = status;
    }

    public Location(PostOffice postOffice) {
        this.status = "SUCCESS";
        this.pincode = postOffice.getPincode();
        this.location = postOffice.getBlock();
        this.state = postOffice.getState();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
