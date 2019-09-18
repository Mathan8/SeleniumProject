package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPostPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import net.bytebuddy.asm.Advice.Enter;

public class Medium_AddNewPostTest {
	private WebDriver driver;
	private String baseUrl;
	private AddNewPostPOM addnewpostPOM;
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
		addnewpostPOM = new AddNewPostPOM(driver); 
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
		addnewpostPOM.clicklogIn();
		//Enter user name and password
		addnewpostPOM.sendUserName("admin");
		addnewpostPOM.sendPassword("adminuser@12345");
		//click on Login button
		addnewpostPOM.clickLoginBtn();
		//hover over posts link
		addnewpostPOM.postslinkHover();
		//check for the links under posts
		addnewpostPOM.checklinks();
		//click on categories link
		addnewpostPOM.clickcategories();
		//enter category name
		addnewpostPOM.entercategoryname("Brand New Launches");
		//enter slug name
		addnewpostPOM.enterslugname("launch");
		//enter slug name
		addnewpostPOM.enterdesc("New Launches of villas, apartments, flats");
		//check for the entered values
		addnewpostPOM.checkenteredvalues();
		//click on add new category
		addnewpostPOM.addnewcategory();
		//enter the created category name
		addnewpostPOM.tagsearch("Brand New Launches");
		//click on search category
		addnewpostPOM.clicksearch();
		//hover over posts link
		addnewpostPOM.postslinkHover();
		//click on allposts link
		addnewpostPOM.clickallposts();
		//click on addnew button
		addnewpostPOM.clickaddnew();
		//check page title
		addnewpostPOM.checkaddnewpostpage();
		//enter title for new post
		addnewpostPOM.newpost("New Launches");
		//enter post desc
		addnewpostPOM.postdesc("New Launch in Home");
		//check the created category checkbox
		addnewpostPOM.checkbox();
		//click on publish button
		addnewpostPOM.publishpost();
		//check for post published message
		addnewpostPOM.postpublished();
		//click post link and check for post name provided -- "New Launches"
		addnewpostPOM.verifynewpost("New Launches");
	}
}
