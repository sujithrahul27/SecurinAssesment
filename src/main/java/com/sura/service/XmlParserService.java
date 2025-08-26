package com.sura.service;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.model.CpeDictnary;

@Service
public class XmlParserService {
	@Autowired
	CpeDbService cpeDbService;			//USE DOMPARSER TO PARSE THE XML FILE 
	public void parseXml(){
		try {
			FileInputStream xmlFileStream = new FileInputStream("src/main/java/official-cpe-dictionary_v2.3 (3).xml.gz");
			GZIPInputStream xmlFile = new GZIPInputStream(xmlFileStream);
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(xmlFile);
			String title = null;
			List<String> references = new ArrayList<>();
			String cpe23Uri = null;
			String deprecatedDate = null;
			DateTimeFormatter formater =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Long id = (long) 1;
			while(reader.hasNext()) {
				
				int event = reader.next();
				
				if(event == XMLStreamConstants.START_ELEMENT) {
					String tagName = reader.getLocalName();
					if(tagName == "cpe-item") {
						
					}
					if(tagName.equalsIgnoreCase("title")) {
						title = reader.getElementText();
					}
					if(tagName.equalsIgnoreCase("reference") && reader.getAttributeValue(null, "href") != null)
						references.add(reader.getAttributeValue(null, "href"));
					if(tagName.equalsIgnoreCase("cpe23-item") && reader.getAttributeValue(null, "name") != null) {
						cpe23Uri = reader.getAttributeValue(null, "name");
					//	System.out.println("uri extraced");
					}
						
					if(tagName.equalsIgnoreCase("deprecation") && reader.getAttributeValue(null, "date") !=null)
						deprecatedDate = reader.getAttributeValue(null, "date").substring(0, 10);
				}
				
				if(event == XMLStreamConstants.END_ELEMENT ) {
					String tagName = reader.getLocalName();
					if(tagName.equalsIgnoreCase("cpe-item")) {
						LocalDate date = null;
						if(deprecatedDate != null) {
							date = LocalDate.parse(deprecatedDate, formater);
						}
//						System.out.println("Title : "+title);
//						System.out.println("references");
//					for(String s : references) System.out.println(s);
//						System.out.println("cpe23uri :"+ cpe23Uri);
						//System.out.println("Date :"+deprecatedDate);
					//	System.out.println("Goat Date "+date);
						
						CpeDictnary cpeItem = new CpeDictnary();
						cpeItem.setCpe23Uri(cpe23Uri);
						cpeItem.setDeprecatedDate23(date);
						cpeItem.setId(id++);
						cpeItem.setReference(String.join(",", references));
						cpeItem.setTitle(title);
						cpeDbService.saveCpe(cpeItem);
						cpeItem = null;
						cpe23Uri = null;
						date = null;
						title = null;
						deprecatedDate = null;
						
						
						
						
						
						references = new ArrayList<>();
					}
					
				}
				
			}
			System.out.println("sucess.................");
		}
		catch(Exception e) {
			e.printStackTrace(); //LUCKILY NO EXCEPTION THROWN TILL NOW 
		}
		
	}
	
}
