package com.phonenumbers.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class NumbersDto {
    Integer phoneNumbers;
    String countryName;
}
