package com.qa.automation.pageobjects;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;

import com.qa.automation.reusableUtilities.JavaScriptUtil;



public class LandingpageObjects {
	String baseUrl = "http://automationexercise.com";
	private static final Logger logger = LogManager.getLogger(LandingpageObjects.class);
	private WebDriver driver;
	private WebDriverWait wait;
	Scenario scn;
	JavaScriptUtil javaScriptUtil;
	public void LandingpageObjects(WebDriver driver) {
		this.driver = driver;
		int implictlywaitTimeoutSec = 20;
		wait = new WebDriverWait(driver, 15);
		javaScriptUtil = new JavaScriptUtil(driver);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Firstproject\\chromedriver.exe");
		ChromeOptions opt = new  ChromeOptions();
		opt.setBinary("C:\\Users\\Admin\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		 driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implictlywaitTimeoutSec,TimeUnit.SECONDS);
	
	
	}

	
	private By landingPageLogo = By.xpath("//img[@alt='Website for automation practice']");
	private By loggedInUserNameTxt = By.xpath("//a[text()= ' Logged in as ']/b");
	private By prodBtn = By.xpath("//a[text()=' Products']");
	private By cartBtn = By.xpath("//a[text()=' Cart']");
	private By signUpBtn = By.xpath("//a[text()=' Signup / Login']");
	private By subscriptionText = By.xpath("//h2[text()='Subscription']");
	private By emailSubscription = By.xpath("//input[@id='susbscribe_email']");
	private By arrowBtn = By.xpath("//button[@id='subscribe']");
	private By successTxt = By.xpath("//div[text()='You have been successfully subscribed!']");
	private By HomepageBtns = By.xpath("//ul[@class='nav navbar-nav']");
	private By actButtonsNameList = By.xpath("//div[@class='col-sm-8']//li//a");

public void HomepageTitle()
{
	
String ExpectedTitle="Automation Exercise";
String ActualTitle=driver.getTitle();
Assert.assertEquals(ExpectedTitle,ActualTitle);
driver.get(baseUrl);

}

public void validateHomepageButtonList(List<String> Btnlist)
{
	List<String> expectedButtonsNameList = Btnlist;
    List<WebElement> actButtonsNameListEle = driver.findElements(By.xpath("//div[@class='col-sm-8']//li//a"));
    for (int i = 0; i < expectedButtonsNameList.size(); i++) 

    	Assert.assertEquals(true, actButtonsNameListEle.get(i).getText().contains(expectedButtonsNameList.get(i)));

}}