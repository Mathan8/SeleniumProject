package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class EnquiryPOM {
	private WebDriver driver;
	
	public EnquiryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains (text(),'New Launch')]")
	private WebElement newLaunch;
	
	@FindBy(name="keyword_search")
	private WebElement keywordSearch;
	
	@FindBy (xpath="//*[contains (text(),'Search')]")
	private WebElement search;
	
	@FindBy (xpath="//*[@class='info-box margin-bottom-10']/p/a")
	private WebElement enquiry;
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(name="id:comments")
	private WebElement message;
	
	@FindBy(css="[type='submit'][value='Send']")
	private WebElement submit;
	
	@FindBy(xpath="//*[@class='wpcf7-form failed']/div[4]")
	private WebElement errorMessage;
	
	public void NewLaunch() {
		this.newLaunch.click();
	}
	
	public void sendKeyword(String location) {
		this.keywordSearch.clear();
		this.keywordSearch.sendKeys(location);
	}
	
	public void selectLocation() throws AWTException {
	Robot r=new Robot();
		
	   //Press Down
	   r.keyPress(KeyEvent.VK_DOWN);
	   
	 //Release Down
	   r.keyRelease(KeyEvent.VK_DOWN);
	 
	   // Press Enter
	   r.keyPress(KeyEvent.VK_ENTER);
	 
	   // Release Enter
	   r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void search() {
		this.search.click();
	}
	
	public void enquiry() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		this.enquiry.click();
	}
	
	public void entername(String FirstName) {
		this.name.clear();
		this.name.sendKeys(FirstName);
	}
	
	public void enteremail(String EmailID) {
		this.email.clear();
		this.email.sendKeys(EmailID);
	}
	
	public void entersubject(String Subject) {
		this.subject.clear();
		this.subject.sendKeys(Subject);
	}
	
	public void yourmessage(String Message) {
		this.message.clear();
		this.message.sendKeys(Message);
	}
	
	public void submit() throws InterruptedException{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		this.submit.submit();
	}
	
	public void validateerrormsg() {
		//waitForElement(By.xpath("//*[@class='wpcf7-form failed']/div[4]"), 5);
		String actual = errorMessage.getText();
		System.out.println(actual);
		String expected = "There was an error trying to send your message. Please try again later.";
		Assert.assertEquals(actual, expected);
	}
}
