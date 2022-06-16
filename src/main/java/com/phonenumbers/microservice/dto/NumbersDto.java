package com.phonenumbers.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumbersDto {
    Integer phoneNumbers;
    String countryName;
}
