package com.vodafone.garage.controller;

import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.model.GarageRequest;
import com.vodafone.garage.model.GarageResponse;
import com.vodafone.garage.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/garage")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public GarageResponse setGarageControl(@RequestBody GarageRequest request){
        try {
            return garageService.getGarageState(request);
        }catch (Exception e){
            GarageResponse response = new GarageResponse();
            response.setMessage("You entered the wrong command");
            return response;
        }

    }
}
