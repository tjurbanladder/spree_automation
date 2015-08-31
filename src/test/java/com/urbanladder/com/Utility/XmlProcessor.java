package com.urbanladder.com.Utility;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
 
public class XmlProcessor {
 
  public static void main(String argv[]) {

  }
  
  public ArrayList<StringBuilder> getList(String nodeName, String filePath) {
	  ArrayList<StringBuilder> urlList = new ArrayList<StringBuilder>();
	  try{
		  File fXmlFile = new File(filePath);
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		  Document doc = dBuilder.parse(fXmlFile);
		  doc.getDocumentElement().normalize();
		  
		  NodeList nList = doc.getElementsByTagName(nodeName);
		  
		  for (int temp = 0; temp < nList.getLength(); temp++) {
			  Node nNode = nList.item(temp);
			  StringBuilder str = new StringBuilder(nNode.getTextContent().trim());
//			  if(nodeName == "loc")
//			  {
//			  str.replace(0, 11, "https://stg1-hercules");
//			  }
//			  else
//			  {
//				  str.replace(0, 13, "https://stg1-hercules.");
//			  }
			  urlList.add(str);
		
			  }
	  }
	  catch (Exception e) {
			e.printStackTrace();
		    }
	  
	  return urlList;
  }
 
}