package com.sura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sura.service.XmlParserService;

@SpringBootApplication
public class SecurinAssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurinAssesmentApplication.class, args);
		XmlParserService xmlservice = new XmlParserService();
		xmlservice.parseXml();
	}

}
