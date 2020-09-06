package com.iamvickyav.BookBazzar.service;

import com.iamvickyav.BookBazzar.client.RestClient;
import com.iamvickyav.BookBazzar.dto.PinCodeResponse;
import com.iamvickyav.BookBazzar.dto.PostOffice;
import com.iamvickyav.BookBazzar.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LocationService {

    @Value("${pincode.api.url}")
    String url;

    @Autowired
    RestClient restClient;

    @Cacheable(cacheNames = "locationByPinCodeCache")
    public Optional<Location> getLocationInfoByPinCode(Integer pincode){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pincode", pincode.toString());

        ResponseEntity<List<PinCodeResponse>> response = restClient.makeRequestForList(url, HttpMethod.GET, null, new HashMap<>(),
                new ParameterizedTypeReference<List<PinCodeResponse>>() {}, paramMap);

        List<PinCodeResponse> pinCodeResponses = response.getBody();

        if(!pinCodeResponses.isEmpty()) {
            PinCodeResponse pinCodeResponse = pinCodeResponses.get(0);
            if(pinCodeResponse.getStatus().equalsIgnoreCase("Success")) {
                PostOffice postOffice = pinCodeResponse.getPostOffices().get(0);
                Location location = new Location(postOffice);
                return Optional.of(location);
            }
        }
        return Optional.empty();
    }
}
