package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EnquiryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;;

public class Simple_EnquiryTest {
	
	private WebDriver driver;
	private String baseUrl;
	private EnquiryPOM enquiryPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		enquiryPOM = new EnquiryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void Enquiry() throws InterruptedException, AWTException {
		enquiryPOM.NewLaunch();
		enquiryPOM.sendKeyword("Bangalore, Karnataka, India");
		//enquiryPOM.selectLocation();
		enquiryPOM.search();
		//Click on Drop us a line Button
		enquiryPOM.enquiry();
		//provide name details
		enquiryPOM.entername("manzoor");
		//provide mail id
		enquiryPOM.enteremail("manzoor@gmail.com");
		//provide subject
		enquiryPOM.entersubject("apartments");
		//provide the intended message
		enquiryPOM.yourmessage("looking for apartments");
		//click on submit
		enquiryPOM.submit();
		//verify for the error message as the website is not connected to mail server
		enquiryPOM.validateerrormsg();
		screenShot.captureScreenShot("First");
	}

}
