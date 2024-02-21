package LOGIN_PAGE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//functionality check test cases
public class login_form { 
WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

			
		driver.manage().window().maximize();
		

	}
	@Test(priority=1)//Assert that User is redirected to the expected page after login
	public void testLoginFunctionality() {
	    driver.get("https://demo.applitools.com/#");
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("username");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password");
	     driver.findElement(By.xpath("//a[@id='log-in']")).click();

	    assertEquals("https://demo.applitools.com/app.html", driver.getCurrentUrl());
	    }
	@Test(priority=2)// Example: Click on a link to navigate to twitter page
	public void testNavigationTotwitterPage() {
	    driver.get("https://demo.applitools.com/#");
	    	    
	    WebElement twitterLink = driver.findElement(By.xpath("//img[@src='img/social-icons/twitter.png']"));
	    twitterLink.click();
	    
	    assertEquals(twitterLink,"https://www.demo.applitools.com/twitter");
	    
	    	}
	
	@Test(priority=3)// Example: Click on a link to navigate to facebook page
	public void testNavigationToFBpage() {
	    driver.get("https://demo.applitools.com/#");
	    	    
	    WebElement FbLink = driver.findElement(By.xpath("//img[@src='img/social-icons/facebook.png']"));
	    FbLink.click();
	    
	    assertEquals(FbLink,"https://www.demo.applitools.com/Facebook");
	    
	    	}
	@Test(priority=4)// Example: Click on a link to navigate to Linkedin page
	public void testNavigationToLinkedInpage() {
	    driver.get("https://demo.applitools.com/#");
	    	    
	    WebElement LinkedInLink = driver.findElement(By.xpath("//img[@src='img/social-icons/linkedin.png']"));
	    LinkedInLink.click();
	    
	    assertEquals(LinkedInLink,"https://www.demo.applitools.com/LinkedIn");
	    
	    	}
	@Test(priority=5)//check logo
	public void testLogoCheck() {
	    driver.get("https://www.demo.applitools.com/#");
	    
	   	    WebElement logo = driver.findElement(By.xpath("//img[@src='img/logo-big.png']"));

	    assertNotNull(logo, "Logo element not found on the page");

	    // Check if the logo has a valid source URL
	    String logoSource = logo.getAttribute("img/logo-big.png");
	    assertNotNull(logoSource, "Logo source attribute is null");
	    assertTrue(logoSource.contains("//img[@src='img/logo-big.png']"), "Incorrect logo image source");
	   	}
	
	@Test (priority=6)//remember me button check
	public void testRememberMeFunctionality() {
	    driver.get("https://demo.applitools.com/#");
	    WebElement usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
	    WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
	    WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	    WebElement SigninButton = driver.findElement(By.xpath("//a[@id='log-in']"));

	    // Enter valid credentials
	    usernameInput.sendKeys("admin");
	    passwordInput.sendKeys("password777");

	    // Check the "Remember Me" checkbox
	    rememberMeCheckbox.click();

	    // Click the login button
	    SigninButton.click();

	   	    // Revisit the login page
	    driver.get("https://www.demo.applitools.com/#");

	    // Verify that the username field is pre-filled with the remembered username
	    String rememberedUsername = usernameInput.getAttribute("value");
	    assertEquals("admin", rememberedUsername);
	    
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
	      driver.quit();
	}
}
