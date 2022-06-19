package com.phonenumbers.microservice.services;

import com.phonenumbers.microservice.dto.NumbersDto;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
public class WikiTable {

    private NumbersDto numbersDto;



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
                String code = columns.get(1).text();
                codes.put(name, code);

            }
        }
        codes.forEach((name, code) -> System.out.println(name + " -> " + code));
        return codes;

    }

}
