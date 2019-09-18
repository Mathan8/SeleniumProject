package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@href='http://realestate.upskills.in/my-profile/']")
	private WebElement logIn;
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@class='wrap']/h1")
	private WebElement dashBoard;
	
	@FindBy(xpath="//*[@href='http://realestate.upskills.in/wp-admin/profile.php']")
	private WebElement admin;
	
	@FindBy(xpath="//*[@id='wp-admin-bar-logout']/a")
	private WebElement logOut;
	
	public void clicklogIn(){
		this.logIn.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void dashBoard() {
		this.dashBoard.getText();
	}
	
	public void adminHover() {
		Actions action = new Actions(driver);
		action.moveToElement(admin).perform();
		Select se=new Select(admin); 
		se.selectByVisibleText("us");
	}
	
	public void clickLogOut() {
		this.logOut.click();
	}
}
