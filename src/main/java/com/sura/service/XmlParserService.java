package com.sura.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sura.model.CpeDictnary;

@Service
public class XmlParserService {
	@Autowired
	CpeDbService cpeDbService;			//USE DOMPARSER TO PARSE THE XML FILE 
	public void parseXml(){
		try {
			File cpeDictnary = new File("src/main/java/sample.xml");
			DocumentBuilderFactory documentFactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document xmlDocument = documentBuilder.parse(cpeDictnary);
			xmlDocument.getDocumentElement().normalize();		//TYPICAL JAVA VERBOSE STEPS
			
			NodeList nodes = xmlDocument.getElementsByTagName("CPE_Entry"); 
			//System.out.println(xmlDocument.getDocumentElement().getNodeName());
			for(int i=0;i < nodes.getLength();i++) {
				Node node = nodes.item(i);
				Element element = (Element) node;
				//RETRIVING THE CHILD TAGS
				String title = element.getElementsByTagName("Title").item(0).getTextContent();
                String cpe22Uri = element.getElementsByTagName("CPE_22_URI").item(0).getTextContent();
                String cpe23Uri = element.getElementsByTagName("CPE_23_URI").item(0).getTextContent();
                String deprecated22 = element.getElementsByTagName("CPE_22_Deprecated").item(0).getTextContent();
                String deprecated23 = element.getElementsByTagName("CPE_23_Deprecated").item(0).getTextContent();
                
                NodeList references = element.getElementsByTagName("Link");
                //RETRIVING THE CHILLD TAGS OF REFERNCE SINCE IT HAS MULTIPLE TAGS INSIDE IT 
                List<String> refers = new java.util.ArrayList<>();
                for (int j = 0; j < references.getLength(); j++) {
                    refers.add(references.item(j).getTextContent());
                }
                
                //System.out.println(title+cpe22Uri+cpe23Uri+deprecated22+deprecated23);
                //for(String s : refers) System.out.println(s);
                
                //CONVERTOT FOR STRING TO DATE
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate deprecated22Date = LocalDate.parse(deprecated22, formatter);
                LocalDate deprecated23Date = LocalDate.parse(deprecated23, formatter);
               // System.out.println(deprecated22Date+" "+deprecated23Date);
                
                //MANNUAL OBJECT CREATION FOR EACH ENTRY AND SETTING FEILDS 
                CpeDictnary cpeEntry = new CpeDictnary();
                cpeEntry.setCpe23Uri(cpe23Uri);
                cpeEntry.setCpe24Uri(cpe22Uri);
                cpeEntry.setDeprecatedDate22(deprecated22Date);
                cpeEntry.setDeprecatedDate23(deprecated23Date);
                cpeEntry.setReference(refers);
                cpeEntry.setTitle(title);
                
               // System.out.println(cpeEntry);
                
                //SAVING INTO THE DB  WITH ID GENRATED FOR EACH VALUE 
                cpeEntry.setId(String.valueOf(i+1));
                cpeDbService.saveCpe(cpeEntry);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace(); //LUCKILY NO EXCEPTION THROWN TILL NOW 
		}
		
	}
	
}
