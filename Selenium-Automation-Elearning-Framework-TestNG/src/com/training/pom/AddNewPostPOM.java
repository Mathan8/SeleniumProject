package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddNewPostPOM {
	private WebDriver driver; 
	
	public AddNewPostPOM(WebDriver driver) {
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
	
	@FindBy (id="tag-name")
	private WebElement categoryName;
	
	@FindBy (id="tag-slug")
	private WebElement slugName;
	
	@FindBy (id="tag-description")
	private WebElement description;
	
	@FindBy (name="submit")
	private WebElement addNewCategory;
	
	@FindBy (id="tag-search-input")
	private WebElement tagsearch;
	
	@FindBy (id="search-submit")
	private WebElement searchcategory;
	
	@FindBy(xpath = "//*[@class='page-title-action']")
	private WebElement addNew;
	
	@FindBy (xpath = "//*[@class='wp-heading-inline']")
	private WebElement addnewpostTitle;
	
	@FindBy (name = "post_title")
	private WebElement postTitle;
	
	@FindBy (name = "content")
	private WebElement postdesc;
	
	@FindBy (xpath = "//*[contains(text(),'Brand New Launches')]/input")
	private WebElement categorycb;
	
	@FindBy (name = "publish")
	private WebElement publishBtn;

	@FindBy (xpath = "//*[contains(text(),'Post published.')]")
	private WebElement publishmessage;
	
	@FindBy (xpath = "//*[contains(text(),'Post published.')]/a")
	private WebElement postlink;
	
	@FindBy (xpath = "//*[@class='post-content']/a/h3")
	private WebElement postname;
	
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
	
	public void clickcategories(){
		this.categories.click();
	}
	
	public void entercategoryname(String categoryname){
		this.categoryName.clear();
		this.categoryName.sendKeys(categoryname);
	}
	
	public void enterslugname(String slugname){
		this.slugName.clear();
		this.slugName.sendKeys(slugname);
	}
	
	public void enterdesc(String desc){
		this.description.clear();
		this.description.sendKeys(desc);
	}
	
	public void checkenteredvalues(){
		String actualcategoryname = categoryName.getAttribute("value");
		String actualslugname = slugName.getAttribute("value");
		String actualdesc = description.getAttribute("value");
		String expectedcategoryname = "Brand New Launches";
		String expectedslugname = "launch";
		String expecteddesc = "New Launches of villas, apartments, flats";
		Assert.assertEquals(actualcategoryname, expectedcategoryname);
		Assert.assertEquals(actualslugname, expectedslugname);
		Assert.assertEquals(actualdesc, expecteddesc);
	}

	public void addnewcategory(){
		this.addNewCategory.submit();
	}
	
	public void tagsearch(String categoryname){
		this.tagsearch.clear();
		this.tagsearch.sendKeys(categoryname);
	}
	
	public void clicksearch(){
		this.searchcategory.click();
	}
	
	public void clickallposts(){
		this.allposts.click();
	}
	
	public void clickaddnew() throws InterruptedException{
		Thread.sleep(3000);
		this.addNew.click();
	}
	
	public void checkaddnewpostpage(){
		String actualtitle = addnewpostTitle.getText();
		String expectedtitle = "Add New Post";
			Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	public void newpost(String PostName) {
		this.postTitle.clear();
		this.postTitle.sendKeys(PostName);
	}
	
	public void postdesc(String PostDesc) {
		this.postdesc.clear();
		this.postdesc.sendKeys(PostDesc);
	}
	
	public void checkbox(){
		this.categorycb.click();
		boolean actual = categorycb.isSelected();
		assertEquals(actual, true);
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
	
	public void verifynewpost(String PostName){
		this.postlink.click();
		String actualpostname = postname.getText();
		String expectedpostname = PostName;
		Assert.assertEquals(actualpostname, expectedpostname);
	}
}
