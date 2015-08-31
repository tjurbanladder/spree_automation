package com.urbanladder.com.Utility;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
/**
 * This program demonstrates how to capture a screenshot (full screen)
 * as an image which will be saved into a file.
 * @author www.codejava.net
 *
 */
public class ScreenshotCapture {
	
	final static Logger LOG = LoggerFactory.getLogger(ScreenshotCapture.class);
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    static Date date = new Date();
    public static void takescreenshot (String testcase) {
        try {
            Robot robot = new Robot();
            String filepath = "/Users/tarunjain/Documents/WorkSpace/spree_automation/Screenshots/";
            String format = "png";
            String fileName = testcase+"_"+System.currentTimeMillis()+"."+format;
             
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(filepath+fileName));
            LOG.info(filepath+fileName);
          
        } catch (Exception ex) {
        	  LOG.error(ex.toString());
        }
    }
}
