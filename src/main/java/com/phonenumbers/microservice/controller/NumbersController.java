package com.phonenumbers.microservice.controller;

import com.phonenumbers.microservice.dto.NumbersDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ui")
public class NumbersController {
    @GetMapping("/numbers")
    NumbersDto create(@RequestBody NumbersDto numbersDto) {
        log.info("Received create number request: {}", numbersDto);
        return new NumbersDto();
    }
}
