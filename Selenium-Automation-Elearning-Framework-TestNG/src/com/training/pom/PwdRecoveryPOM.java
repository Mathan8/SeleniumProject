package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PwdRecoveryPOM {

		private WebDriver driver;

		public PwdRecoveryPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//*[@href='http://realestate.upskills.in/my-profile/']")
		private WebElement logIn;
		
		@FindBy(xpath = "//*[@class='lost_password']/a")
		private WebElement lostPWD;
		
		@FindBy(name="user_login")
		private WebElement email;
		
		@FindBy(name="submit")
		private WebElement submit;
		
		@FindBy(xpath = "//*[@id='error-page']/p")
		private WebElement errorPage;
		
		public void clicklogIn(){
			this.logIn.click();
		}
		
		public void lostyourPWD() throws InterruptedException{
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(5000);
			this.lostPWD.click();
		}
		
		public void recoveryMail(String recoverymailID){
			this.email.clear();
			this.email.sendKeys(recoverymailID);
		}		
		
		public void clicksubmit(){
			this.submit.submit();
		}
		
		public void verifyerrorpage(){
			String actual = errorPage.getText();
			System.out.println(actual);
			String expected = ("The email could not be sent.\nPossible reason: your host may have disabled the mail() function.");
			Assert.assertEquals(actual, expected);
			
		}
}
