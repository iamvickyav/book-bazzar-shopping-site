package com.iamvickyav.BookBazzar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PinCodeResponse {

    @JsonProperty("Status")
    String status;

    @JsonProperty("PostOffice")
    List<PostOffice> postOffices;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PostOffice> getPostOffices() {
        return postOffices;
    }

    public void setPostOffices(List<PostOffice> postOffices) {
        this.postOffices = postOffices;
    }
}
