package com.sura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sura.service.XmlParserService;

@SpringBootApplication
public class SecurinAssesmentApplication {

	public static void main(String[] args) {
		  ConfigurableApplicationContext context = SpringApplication.run(SecurinAssesmentApplication.class, args);

	        //XmlParserService parser = context.getBean(XmlParserService.class);
	       //parser.parseXml();

	}

}
