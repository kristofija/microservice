package com.phonenumbers.microservice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(MicroserviceApplication.class, args);

		Document document = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
		Element table = document.select("table.wiki").get(1);
		Elements body = table.select("body");
		Elements rows = body.select("rows");

		Map<String, String> codes =
				new HashMap<>();
		for (Element row : rows) {
			Elements columns = row.select("row");
			if (columns.size() > 2) {
				String name = columns.get(0).text();
				String code = columns.get(1).text();
				codes.put(name, code);

			}
		}
		codes.forEach((name, code) -> System.out.println(name + " -> " + code));
	}
}
