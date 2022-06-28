package com.phonenumbers.microservice.controller;

import com.phonenumbers.microservice.dto.FindCountryRequest;
import com.phonenumbers.microservice.dto.FindCountryResponse;
import com.phonenumbers.microservice.dto.NumbersDto;
import com.phonenumbers.microservice.services.WikiTable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class NumbersController {

    //private final WikiTable wikiTable;


    @PostMapping
    public FindCountryResponse find(@RequestParam(required = false) String phoneNumber) throws IOException {
        var request = new FindCountryRequest(phoneNumber);
        WikiTable wikiTable = new WikiTable();
        return wikiTable.findCountry(request);
    }

}
