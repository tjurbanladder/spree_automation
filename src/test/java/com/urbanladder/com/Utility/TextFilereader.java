package com.urbanladder.com.Utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextFilereader 

{


	public ArrayList<String> getList(String filePath) {
		ArrayList<String> urlList = new ArrayList<String>();
		  try{
	
			  	FileInputStream fstream = new FileInputStream(filePath);
			  	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			  	String strLine;

					//Read File Line By Line
					while ((strLine = br.readLine()) != null)   
					{
					 urlList.add(strLine);
					}

					//Close the input stream
					br.close();
			}
		  catch (Exception e) 
		  {
				e.printStackTrace();
		  }
		return urlList;
	}
}