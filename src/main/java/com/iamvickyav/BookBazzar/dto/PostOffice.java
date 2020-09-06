package com.iamvickyav.BookBazzar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOffice {

    @JsonProperty("Block")
    String block;

    @JsonProperty("State")
    String state;

    @JsonProperty("Pincode")
    String pincode;

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
