package com.sura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sura.service.XmlParserService;

@SpringBootApplication
public class SecurinAssesmentApplication {
//This is where the app starts and i used the xml parser once to store into the db 
	public static void main(String[] args) {
		  ConfigurableApplicationContext context = SpringApplication.run(SecurinAssesmentApplication.class, args);

	        //XmlParserService parser = context.getBean(XmlParserService.class);
	       //parser.parseXml();

	}

}
