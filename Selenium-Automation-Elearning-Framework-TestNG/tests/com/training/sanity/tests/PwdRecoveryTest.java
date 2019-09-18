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
import com.training.pom.PwdRecoveryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PwdRecoveryTest {

		private WebDriver driver;
		private String baseUrl;
		private PwdRecoveryPOM pwdRecoveryPOM;
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
			pwdRecoveryPOM = new PwdRecoveryPOM(driver); 
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
		public void validLoginTest() throws InterruptedException {
			//click on the link for login form to appear
			pwdRecoveryPOM.clicklogIn();
			//click on lost password link
			pwdRecoveryPOM.lostyourPWD();
			//provide recovery email
			pwdRecoveryPOM.recoveryMail("manzoor@gmail.com");
			//click on submit
			pwdRecoveryPOM.clicksubmit();
			//verify the error message as the website is not linked to mail server
			pwdRecoveryPOM.verifyerrorpage();
			screenShot.captureScreenShot("First");
		}
	}

