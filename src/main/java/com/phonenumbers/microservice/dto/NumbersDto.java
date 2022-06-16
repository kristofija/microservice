package com.phonenumbers.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumbersDto {
    Integer phoneNumbers;
    String countryName;
}
