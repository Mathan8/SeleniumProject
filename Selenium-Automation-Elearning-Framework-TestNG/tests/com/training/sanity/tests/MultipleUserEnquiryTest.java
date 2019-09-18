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
import com.training.dataproviders.LoginDataProviders;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MultipleUserEnquiryTest {
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
	
	@Test(dataProvider="excel-inputs",dataProviderClass = LoginDataProviders.class)
	public void Enquiry(String name, String email, String subject, String message) throws InterruptedException, AWTException {
		//Click on NewLaunch link
		enquiryPOM.NewLaunch();
		//Enter the address
		enquiryPOM.sendKeyword("Bangalore, Karnataka, India");
		//enquiryPOM.selectLocation();
		//click on search
		enquiryPOM.search();
		//click on Drop us a line button
		enquiryPOM.enquiry();
		//enter name of the user
		enquiryPOM.entername(name);
		//enter user mail id
		enquiryPOM.enteremail(email);
		//enter the subject
		enquiryPOM.entersubject(subject);
		//enter the message
		enquiryPOM.yourmessage(message);
		//click on Send
		enquiryPOM.submit();
		//validate the error message since there is no server
		enquiryPOM.validateerrormsg();
		screenShot.captureScreenShot("First");
	}

}
