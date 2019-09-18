package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyAddedPostPOM {

	private WebDriver driver; 
	
	public VerifyAddedPostPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@class='wp-menu-image dashicons-before dashicons-admin-post']")
	private WebElement posts;
	
	@FindBy (xpath="//*[@id='menu-posts']/ul/li[2]")
	private WebElement allposts;

	@FindBy (xpath="//*[@id='menu-posts']/ul/li[3]")
	private WebElement addnew;
	
	@FindBy (xpath="//*[@id='menu-posts']/ul/li[4]")
	private WebElement categories;
	
	@FindBy (xpath="//*[@id='menu-posts']/ul/li[5]")
	private WebElement tags;
	
	@FindBy (name = "post_title")
	private WebElement postTitle;
	
	@FindBy (name = "content")
	private WebElement postdesc;
	
	@FindBy (name = "publish")
	private WebElement publishBtn;

	@FindBy (xpath = "//*[contains(text(),'Post published.')]")
	private WebElement publishmessage;
	
	@FindBy (xpath = "//*//*[@id='the-list']/tr[1]/td[1]/strong/a")
	private WebElement addedpost;
	
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
	
	public void postslinkHover() {
		Actions action = new Actions(driver);
		action.moveToElement(posts).perform();
	}
	
	public void checklinks(){
		String actuallink1 = allposts.getText();
		String actuallink2 = addnew.getText();
		String actuallink3 = categories.getText();
		String actuallink4 = tags.getText();
		String expectedlink1 = "All Posts";
		String expectedlink2 = "Add New";
		String expectedlink3 = "Categories";
		String expectedlink4 = "Tags";
		Assert.assertEquals(actuallink1, expectedlink1);
		Assert.assertEquals(actuallink2, expectedlink2);
		Assert.assertEquals(actuallink3, expectedlink3);
		Assert.assertEquals(actuallink4, expectedlink4);
	}
	
	public void clickAddNew(){
		this.addnew.click();
	}
	
	public void newpost(String PostName) {
		this.postTitle.clear();
		this.postTitle.sendKeys(PostName);
	}
	
	public void postdesc(String PostDesc) {
		this.postdesc.clear();
		this.postdesc.sendKeys(PostDesc);
	}
	
	public void publishpost(){
		this.publishBtn.submit();
		this.publishBtn.click();
	}
	
	public void postpublished() throws InterruptedException{
		Thread.sleep(5000);
		String screen = publishmessage.getText();
		String expected = "Post published. View post";
			Assert.assertEquals(screen, expected);
	}
	
	public void clickAllPosts(){
		this.allposts.click();
	}
	
	public void verifyaddedpost() {
		String screen = addedpost.getText();
		String expected = "New Launches";
			Assert.assertEquals(screen, expected);
	}

}
