package com.iamvickyav.BookBazzar.controller;

import com.iamvickyav.BookBazzar.model.BookFacetResponse;
import com.iamvickyav.BookBazzar.model.Location;
import com.iamvickyav.BookBazzar.model.PLPResponse;
import com.iamvickyav.BookBazzar.service.LocationService;
import com.iamvickyav.BookBazzar.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/location")
@Validated
@CrossOrigin
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/pincode/{pincode}", method = RequestMethod.GET)
    ResponseEntity<Location> getLocationByZipCode(@PathVariable("pincode") @Min(100000) @Max(999999) Integer pincode) {
        Optional<Location> locationOptional = locationService.getLocationInfoByPinCode(pincode);

        if(locationOptional.isPresent()) {
            return ResponseEntity.ok(locationOptional.get());
        } else {
            return ResponseEntity.ok(new Location("FAILURE"));
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    ResponseEntity process(){
        PLPResponse response = searchService.process();
        return ResponseEntity.ok(response);
    }
}
