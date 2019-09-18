package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreatePropertyDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


	public class CreatePropertyDetailsTest {
		private WebDriver driver;
		private String baseUrl;
		private CreatePropertyDetailsPOM createpropertydetailsPOM;
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
			createpropertydetailsPOM = new CreatePropertyDetailsPOM(driver);
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
		public void validLoginTest() throws InterruptedException {
			//click the link for login page
			createpropertydetailsPOM.clicklogIn();
			//Enter user name and password
			createpropertydetailsPOM.sendUserName("admin");
			createpropertydetailsPOM.sendPassword("adminuser@12345");
			//click on Login button
			createpropertydetailsPOM.clickLoginBtn();
			//hover over properties link
			createpropertydetailsPOM.propertieslinkHover();
			//check for the links under properties
			createpropertydetailsPOM.checklinks();
			//click on features link
			createpropertydetailsPOM.clickfeatures();
			//enter feature name
			createpropertydetailsPOM.enterfeaturename("Brand New Launches");
			//enter slug name
			createpropertydetailsPOM.enterslugname("launch");
			//enter slug name
			createpropertydetailsPOM.enterdesc("New Launches of villas, apartments, flats");
			//check for the entered values
			createpropertydetailsPOM.checkenteredvalues();
			//click on add new feature
			createpropertydetailsPOM.addnewfeature();
			//enter the created feature name
			createpropertydetailsPOM.tagsearch("Brand New Launches");
			//click on search feature
			createpropertydetailsPOM.clicksearch();
			//verify added feature name
			createpropertydetailsPOM.verifyaddedfeature();
			//hover over properties link
			createpropertydetailsPOM.propertieslinkHover();
			//click on addnew link
			createpropertydetailsPOM.clickaddnew();
			//check page title
			createpropertydetailsPOM.checkaddnewproppage();
			//enter title for new property
			createpropertydetailsPOM.enterpropname("Puravankara");
			//enter property desc
			createpropertydetailsPOM.enterpropdesc("Home town");
			//check the created property checkbox
			createpropertydetailsPOM.checkbox();
			//click on publish button
			createpropertydetailsPOM.publishproperty();
			//check for post published message
			createpropertydetailsPOM.verifypropertypublished();
			createpropertydetailsPOM.adminHover();
			createpropertydetailsPOM.clickLogOut();
			createpropertydetailsPOM.clickrealestate();
			createpropertydetailsPOM.searchproperty("Puravankara");
			createpropertydetailsPOM.verifyaddedfeature2();
			createpropertydetailsPOM.verifyaddedfeaturetitle();
		}
	}

