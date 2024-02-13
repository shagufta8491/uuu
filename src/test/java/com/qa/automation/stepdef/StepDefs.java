package com.qa.automation.stepdef;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.qa.automation.PageObjectsFile.LandingPageObject;

//import io.cucumber.core.logging.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import  junit.framework.Assert;
import org.junit.Assert;


public class StepDefs {
	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	
	
	//private WebDriver driver;
	Scenario scn;

	WebDriver driver ;
	String baseUrl = "http://automationexercise.com";
	int implictlywaitTimeoutSec = 20;
	WebDriverWait wait;
	@Before
	public void setUp(Scenario scn) throws Exception
	

	{
		this.scn = scn;
		//JavaScriptExecutorUtil javaScriptExecutorUtil;
		//String browserName = WebDriverFactory.getBrowserName();
	//	driver = WebDriverFactory.setUpBrowser(browserName);
		//scn.log("browser get invoked");
	//	landingPageObject = new LandingPageObject(driver);
//		productPageObject = new ProductPageObject(driver);
//		headerSectionPageObject = new HeaderSectionPageObject(driver);
//		signUpOrLoginPageObject = new SignUpOrLoginPageObject(driver);
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Firstproject\\chromedriver.exe");
		ChromeOptions opt = new  ChromeOptions();
		opt.setBinary("C:\\Users\\Admin\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		 driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implictlywaitTimeoutSec,TimeUnit.SECONDS);
	 }
		
	
	@After(order = 1)
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser got closed");
	}
	@After(order = 2)
	public void takescreenshot(Scenario scn) {
		if(scn.isFailed())
		{
		TakesScreenshot scrnShot = (TakesScreenshot)driver;
		byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
		}
		else
		{
			scn.log("The test c"
					+ "ase get passed,no screenshot get atttached");
		}

	}
	
	@Given("user navigate to the home application url")
	public void user_navigate_to_the_home_application_url() {
		driver.get(baseUrl);
		driver.getTitle();
		logger.info("user navigate to the home application url");

		
	    	}
	@Then("on homepage list of buttons are displayed")
	public void on_homepage_list_of_buttons_are_displayed(List <String> Btnlist) {
		List<String> expectedButtonsNameList = Btnlist;
	    List<WebElement> actButtonsNameListEle = driver.findElements(By.xpath("//div[@class='col-sm-8']//li//a"));
	    for (int i = 0; i < expectedButtonsNameList.size(); i++) 

	    	Assert.assertEquals(true, actButtonsNameListEle.get(i).getText().contains(expectedButtonsNameList.get(i)));
	
		
		
	  }

	
	@Given("User navigate to url")
	public void user_navigate_to_url() 
	{
		driver.get(baseUrl);
		driver.getTitle();
		
	}
		@Given("User enter email address {string} in input")
	public void user_enter_email_address_in_input(String userregistersubscribe) {
		WebElement subscribe= driver.findElement(By.id("susbscribe_email"));
				subscribe.sendKeys("shagufta.princess@gmail.com");
	    }

	@Given("User click on arrow button")
	public void user_click_on_arrow_button() {
		WebElement subscribebutton =driver.findElement(By.id("subscribe"));
		subscribebutton.click();
		logger.info("clicked on the arrow button");

	    }
	@Then("User Verify success message {string} is visible")
	public void user_verify_success_message_is_visible(String subscribemsg) {
		WebElement subscribetxt = driver.findElement(By.id("success-subscribe"));
		Assert.assertEquals(subscribemsg, subscribetxt.getText());
		
	   }


@Then("user click on signup\\/login button")
public void user_click_on_signup_login_button() {
	WebElement signuploginbtn=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
	signuploginbtn.click();
	logger.info("clicked on the Signup button");

}


@When("user enter email  {string} and {string}" )
public void user_enter_email_and(String EmailId, String password) {
	WebElement EmailIdEle = driver.findElement(By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']"));
	//Assert.assertEquals(EmailId,EmailIdEle.getText());
	EmailIdEle.sendKeys(EmailId);
	
	WebElement passwordEle = driver.findElement(By.xpath("//input[@placeholder='Password' and @data-qa='login-password']"));
	//Assert.assertEquals(password,passwordEle.getText());
	
	passwordEle.sendKeys(password);

  }

@When("user click on login button")
public void user_click_on_login_button() {
	WebElement loginbtn=driver.findElement(By.xpath("//button[@data-qa='login-button']" ));
	loginbtn.click();
    }

@Given("User navigatee to url")
public void user_navigatee_to_url() 
{
	driver.get(baseUrl);
	driver.getTitle();
	
}

@Given("User click on signup\\/logiin button")
public void user_click_on_signup_logiin_button() {
	WebElement signuploginbtn=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
	signuploginbtn.click();
	logger.info("clicked on the signup button");
}

@When("User enter valid {string} and {string} for logiin")
public void user_enter_valid_and_for_logiin(String ValidEmailId, String Validpassword) {
	WebElement EmailIdEle = driver.findElement(By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']"));
		EmailIdEle.sendKeys(ValidEmailId);
	
	WebElement passwordEle = driver.findElement(By.xpath("//input[@placeholder='Password' and @data-qa='login-password']"));
		
	passwordEle.sendKeys(Validpassword);
	logger.info("entered correct registered emilid as " +ValidEmailId );
	logger.info("entered correct registered emilid as " +Validpassword );
   
}

@When("User click on logiin button")
public void user_click_on_logiin_button() {
	WebElement signuploginbtn=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
	signuploginbtn.click();
	 logger.info("user click on login button");
}


@Then("User verify with {string} just after Logged in as button")
public void user_verify_with_just_after_logged_in_as_button(String username) {
	WebElement user = driver.findElement(By.xpath("//a[text()= ' Logged in as ']/b"));
	Assert.assertEquals(username,user.getText().trim());
	
   
}

@Then("User click on logoutt button")
public void user_click_on_logoutt_button() {
	WebElement logout=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
   logger.info("user click on logout button");
}
}


