package com.phonenumbers.microservice.controller;

import com.phonenumbers.microservice.dto.FindCountryRequest;
import com.phonenumbers.microservice.services.WikiTable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//@Slf4j
//@RestController
//@RequestMapping("/ui")
@Controller
@AllArgsConstructor

public class NumbersUIController {

    //private final WikiTable wikiTable;


    /*@GetMapping("/numbers")
    NumbersDto create(@RequestBody NumbersDto numbersDto) {
        log.info("Received create number request: {}", numbersDto);
        return new NumbersDto();
    }*/

    @GetMapping("/findCountry")
    public String getCountryView(Model model)  {
        model.addAttribute("country", new FindCountryRequest());
        return "findCountry";
    }

    @PostMapping("/findCountry")
    public String getCountry(@ModelAttribute FindCountryRequest request) throws IOException {
        WikiTable wikiTable = new WikiTable();
        wikiTable.findCountry(request);
        return "findCountry";
    }
}
