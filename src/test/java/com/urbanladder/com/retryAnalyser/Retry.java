package com.urbanladder.com.retryAnalyser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	final static Logger LOG = LoggerFactory.getLogger(Retry.class);
	Properties Config;
    private int retryCount = 0;
    private int maxRetryCount = 0;

// Below method returns 'true' if the test method has to be retried else 'false' 
//and it takes the 'Result' as parameter of the test method that just ran
   
    public boolean retry(ITestResult result) {
    	loadproperties();
        if (retryCount < maxRetryCount) {
            LOG.info("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
    
    public void loadproperties()
    {
    	try{
    		Config = new Properties();
        	FileInputStream fn = new FileInputStream("/Users/tarunjain/Documents/WorkSpace/spree_automation/src/test/resources/config.properties");
        	Config.load(fn);
        	maxRetryCount = Integer.parseInt(Config.getProperty("RETRYCOUNT"));
    	}
    	catch(IOException ie)
    	{
    		LOG.error(ie.toString());
    	}
    	
    	
    }
    
    
    public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
}