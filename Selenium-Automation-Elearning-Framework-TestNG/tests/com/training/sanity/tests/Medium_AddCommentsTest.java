package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCommentsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_AddCommentsTest {
	private WebDriver driver;
	private String baseUrl;
	private AddCommentsPOM addcommentsPOM;
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
		addcommentsPOM = new AddCommentsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		}
		
	
	@Test
	public void addComments() throws InterruptedException {
		//click the link for login page
		addcommentsPOM.clicklogIn();
		//Enter user name and password
		addcommentsPOM.sendUserName("admin");
		addcommentsPOM.sendPassword("adminuser@12345");
		//click on Login button
		addcommentsPOM.clickLoginBtn();
		//hover over posts link
		addcommentsPOM.postslinkHover();
		//check for the links under posts
		addcommentsPOM.checklinks();
		//click on categories link
		addcommentsPOM.clickcategories();
		//enter category name
		addcommentsPOM.entercategoryname("Brand New Launches");
		//enter slug name
		addcommentsPOM.enterslugname("launch");
		//enter slug name
		addcommentsPOM.enterdesc("New Launches of villas, apartments, flats");
		//check for the entered values
		addcommentsPOM.checkenteredvalues();
		//click on add new category
		addcommentsPOM.addnewcategory();
		//enter the created category name
		addcommentsPOM.tagsearch("Brand New Launches");
		//click on search category
		addcommentsPOM.clicksearch();
		//hover over posts link
		addcommentsPOM.postslinkHover();
		//click on allposts link
		addcommentsPOM.clickallposts();
		//click on addnew button
		addcommentsPOM.clickaddnew();
		//check page title
		addcommentsPOM.checkaddnewpostpage();
		//enter title for new post
		addcommentsPOM.newpost("New Launches");
		//enter post desc
		addcommentsPOM.postdesc("New Launch in Home");
		//check the created category checkbox
		addcommentsPOM.checkbox();
		//click on publish button
		addcommentsPOM.publishpost();
		//check for post published message
		addcommentsPOM.postpublished();
		//click post link and check for post name provided -- "New Launches"
		addcommentsPOM.verifynewpost("New Launches");
		//click on Blog link
		addcommentsPOM.clickblog();
		//Verify last added post
		addcommentsPOM.VerifyAddedPost("New Launches");
		//Click on Read more under the last added post
		addcommentsPOM.clickreadmore();
		//enter comment
		addcommentsPOM.entercomment("Great");
		//post the comment
		addcommentsPOM.postComment();
	}
	
	@Test(dependsOnMethods = {"addComments"})
	public void verifyaddedcomments(){
		//click the link for login page
		addcommentsPOM.clicklogIn();
		//Enter user name and password
		addcommentsPOM.sendUserName("admin");
		addcommentsPOM.sendPassword("adminuser@12345");
		//click on Login button
		addcommentsPOM.clickLoginBtn();
		//click on comments link
		addcommentsPOM.clickcomments();
		//verify added comment
		addcommentsPOM.VerifyAddedComment("Great");
		//verify commented post
		addcommentsPOM.VerifyCommentedPost("New Launches");
	}
}