package com.phonenumbers.microservice.services;

import com.phonenumbers.microservice.dto.FindCountryRequest;
import com.phonenumbers.microservice.dto.FindCountryResponse;
import com.phonenumbers.microservice.dto.NumbersDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

@AllArgsConstructor
public class WikiTable {


    Map<String, String> getWikiTable () throws IOException {
        Document document = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
        Element table = document.select("table.wikitable").get(1);
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");

        Map<String, String> codes = new HashMap<>();
        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() > 2) {
                String name = columns.get(0).text();
                String code = columns.get(1).text().replaceAll("\\s", "");
                codes.put(code, name);

            }
        }
        //codes.forEach((code, name) -> System.out.println(code + " -> " + name));
        return codes;

    }

    String phoneNumberConvert (String phoneNumber) {
        String number = phoneNumber;
        //String number = phoneNumber.split("\\)", 2) [0];
        return number;
    }

    String searchCountry(String phoneNumber, Map<String, String> codes) {
        String country = "";
        String number = phoneNumberConvert(phoneNumber);
        String numberForSearch = number;
        //String numberForSearch = number.replaceAll("\\s", "");
        Set<Map.Entry<String, String>> set = codes.entrySet();
        for (Map.Entry<String, String> search : set) {
            if(numberForSearch == search.getValue()) {
                country = set.toString();
            }
        }
        return country;
    }

    public FindCountryResponse findCountry(FindCountryRequest request) throws IOException {
        var country = request.getPhoneNumber();
        Map<String, String> wikiTable = getWikiTable();
        var countryForResponse = searchCountry(country,wikiTable);
        var response = new FindCountryResponse();
        response.setCountry(countryForResponse);
        return response;
    }

}
