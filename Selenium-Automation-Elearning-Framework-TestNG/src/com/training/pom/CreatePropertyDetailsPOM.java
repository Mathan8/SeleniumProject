package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreatePropertyDetailsPOM {
private WebDriver driver; 
	
	public CreatePropertyDetailsPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@class='wp-menu-image dashicons-before dashicons-admin-multisite']")
	private WebElement properties;
	
	@FindBy (xpath="//*[@id='menu-posts-property']/ul/li[2]")
	private WebElement allprops;

	@FindBy (xpath="//*[@id='menu-posts-property']/ul/li[3]")
	private WebElement addnew;
	
	@FindBy (xpath="//*[@id='menu-posts-property']/ul/li[4]")
	private WebElement features;
	
	@FindBy (xpath="//*[@id='menu-posts-property']/ul/li[5]")
	private WebElement regions;
	
	@FindBy (xpath="//*[@id='menu-posts-property']/ul/li[6]")
	private WebElement propsettings;
	
	@FindBy (id="tag-name")
	private WebElement propertyName;
	
	@FindBy (id="tag-slug")
	private WebElement slugName;
	
	@FindBy (id="tag-description")
	private WebElement description;
	
	@FindBy (name="submit")
	private WebElement addNewFeature;
	
	@FindBy (id="tag-search-input")
	private WebElement tagsearch;
	
	@FindBy (id="search-submit")
	private WebElement searchfeature;
	
	@FindBy (xpath = "//*[@aria-label='“Brand New Launches” (Edit)']")
	private WebElement addedfeature;
	
	@FindBy (xpath = "//*[@class='wp-heading-inline']")
	private WebElement addPropertyTitle;
	
	@FindBy (name = "post_title")
	private WebElement propTitle;
	
	@FindBy (name = "content")
	private WebElement propdesc;
	
	@FindBy (xpath = "//*[contains(text(),'Brand New Launches')]/input")
	private WebElement propertycb;
	
	@FindBy (name = "publish")
	private WebElement publishBtn;

	@FindBy (xpath = "//*[contains(text(),'Post published.')]")
	private WebElement publishmessage;
	
	@FindBy(xpath="//*[@href='http://realestate.upskills.in/wp-admin/profile.php']")
	private WebElement admin;
	
	@FindBy(xpath="//*[@id='wp-admin-bar-logout']/a")
	private WebElement logOut;
	
	@FindBy (xpath ="//*[@href='http://realestate.upskills.in/']")
	private WebElement linkRealEstate;
	
	@FindBy (xpath="//*[@class='orig']")
	private WebElement searchbox;
	
	@FindBy (xpath="//*[@class='asl_res_url']")
	private WebElement addedfeaturelink;
	
	@FindBy (xpath="//h2[contains(text(),'Puravankara')]")
	private WebElement addedfeaturetitle;
	
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
	
	public void propertieslinkHover() {
		Actions action = new Actions(driver);
		action.moveToElement(properties).perform();
	}
	
	public void checklinks(){
		String actuallink1 = allprops.getText();
		String actuallink2 = addnew.getText();
		String actuallink3 = features.getText();
		String actuallink4 = regions.getText();
		String actuallink5 = propsettings.getText();
		String expectedlink1 = "All Properties";
		String expectedlink2 = "Add New";
		String expectedlink3 = "Features";
		String expectedlink4 = "Regions";
		String expectedlink5 = "Properties Settings";
		Assert.assertEquals(actuallink1, expectedlink1);
		Assert.assertEquals(actuallink2, expectedlink2);
		Assert.assertEquals(actuallink3, expectedlink3);
		Assert.assertEquals(actuallink4, expectedlink4);
		Assert.assertEquals(actuallink5, expectedlink5);
	}
	
	public void clickfeatures(){
		this.features.click();
	}
	
	public void enterfeaturename(String featurename){
		this.propertyName.clear();
		this.propertyName.sendKeys(featurename);
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
		String actualfeaturename = propertyName.getAttribute("value");
		String actualslugname = slugName.getAttribute("value");
		String actualdesc = description.getAttribute("value");
		String expectedfeaturename = "Brand New Launches";
		String expectedslugname = "launch";
		String expecteddesc = "New Launches of villas, apartments, flats";
		Assert.assertEquals(actualfeaturename, expectedfeaturename);
		Assert.assertEquals(actualslugname, expectedslugname);
		Assert.assertEquals(actualdesc, expecteddesc);
	}

	public void addnewfeature(){
		this.addNewFeature.submit();
	}
	
	public void tagsearch(String featurename){
		this.tagsearch.clear();
		this.tagsearch.sendKeys(featurename);
	}
	
	public void clicksearch(){
		this.searchfeature.click();
	}
	
	public void verifyaddedfeature(){
		String actualfeaturename = addedfeature.getText();
		String expectedfeaturename = "Brand New Launches";
		Assert.assertEquals(actualfeaturename, expectedfeaturename);
	}
	
	public void clickaddnew(){
		this.addnew.click();
	}
	
	public void checkaddnewproppage(){
		String actualtitle = addPropertyTitle.getText();
		String expectedtitle = "Add Property";
			Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	public void enterpropname(String PropertyName) {
		this.propTitle.clear();
		this.propTitle.sendKeys(PropertyName);
	}
	
	public void enterpropdesc(String PropertyDesc) {
		this.propdesc.clear();
		this.propdesc.sendKeys(PropertyDesc);
	}
	
	public void checkbox(){
		this.propertycb.click();
		boolean actual = propertycb.isSelected();
		assertEquals(actual, true);
	}
	
	public void publishproperty(){
		this.publishBtn.submit();
		this.publishBtn.click();
	}
	
	public void verifypropertypublished() throws InterruptedException{
		Thread.sleep(10000);
		String screen = publishmessage.getText();
		String expected = "Post published. View post";
			Assert.assertEquals(screen, expected);
	}
	
	public void adminHover() {
		Actions action = new Actions(driver);
		action.moveToElement(admin).perform();
	}
	
	public void clickLogOut() {
		this.logOut.click();
	}
	
	public void clickrealestate(){
		this.linkRealEstate.click();
	}
	
	public void searchproperty(String addedProperty){
		this.searchbox.clear();
		this.searchbox.sendKeys(addedProperty);
	}
	
	public void verifyaddedfeature2(){
		String actualfeaturename = addedfeaturelink.getText();
		String expectedfeaturename = "Puravankara";
		Assert.assertEquals(actualfeaturename, expectedfeaturename);
		this.addedfeaturelink.click();
	}
	
	public void verifyaddedfeaturetitle(){
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		String actualfeaturename = addedfeaturetitle.getText();
		String expectedfeaturename = "Puravankara For Sale Apartments";
		Assert.assertEquals(actualfeaturename, expectedfeaturename);
	}
}
