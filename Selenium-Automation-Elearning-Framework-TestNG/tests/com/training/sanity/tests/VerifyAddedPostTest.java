package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.VerifyAddedPostPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class VerifyAddedPostTest {
	private WebDriver driver;
	private String baseUrl;
	private VerifyAddedPostPOM verifyaddedpostPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		verifyaddedpostPOM = new VerifyAddedPostPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	
	@Test
	public void addNewPost() throws InterruptedException {
		//click the link for login page
		verifyaddedpostPOM.clicklogIn();
		//Enter user name and password
		verifyaddedpostPOM.sendUserName("admin");
		verifyaddedpostPOM.sendPassword("adminuser@12345");
		//click on Login button
		verifyaddedpostPOM.clickLoginBtn();
		//hover over posts link
		verifyaddedpostPOM.postslinkHover();
		//check for the links under posts
		verifyaddedpostPOM.checklinks();
		//click on categories link
		verifyaddedpostPOM.clickAddNew();
		//enter title for new post
		verifyaddedpostPOM.newpost("New Launches");
		//enter post desc
		verifyaddedpostPOM.postdesc("New Launch in Home");
		//click on publish button
		verifyaddedpostPOM.publishpost();
		//check for post published message
		verifyaddedpostPOM.postpublished();
		//click on All posts link
		verifyaddedpostPOM.clickAllPosts();
		//verify added post
		verifyaddedpostPOM.verifyaddedpost();
	}
}
