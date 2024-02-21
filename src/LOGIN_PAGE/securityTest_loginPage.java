package LOGIN_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class securityTest_loginPage {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		 driver.get("https://demo.applitools.com/#");
			
		driver.manage().window().maximize();
		

	}
	  @Test (priority=1) //valid login
	    public void testValidLogin() {
	      driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	      driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123");
	       driver.findElement(By.xpath("//a[@id='log-in']")).click();
	      String expectedUrl = "https://demo.applitools.com/app.html";
	      String  actualUrl= driver.getCurrentUrl();
	      if(actualUrl.equalsIgnoreCase(expectedUrl)) {
	    	  System.out.println("Test passed");
	      }else
	      { 
	    	  System.out.println("Test failed"); } 
	    }

	  @Test (priority=2) // try to loggin without username and password
	  public void loginwithoutCredentials() {
		  //direct click on login button
		  driver.findElement(By.xpath("//a[@id='log-in']")).click();
		  
		  String expectedUrl = "https://demo.applitools.com/#";
		  String actualUrl = driver.getCurrentUrl();
		  Assert.assertEquals(actualUrl, expectedUrl);
		  if(actualUrl.equals(expectedUrl)) {
			  System.out.println("Test case is passed");
		  }else
		  {
		  System.out.println("Test case is failed");
	  }

	  }
	  	@Test (priority=3)//enter valid username and invalid password
	  	public void ValiduserandInvalidPas() {
	  		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	  		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("aaaaaa");
	  		driver.findElement(By.xpath("//a[@id='log-in']")).click();
	  		
	  		String expectedUrl = "https://demo.applitools.com/#";
			  String actualUrl = driver.getCurrentUrl();
			  Assert.assertEquals(actualUrl, expectedUrl);
			  if(actualUrl.equals(expectedUrl)) {
				  System.out.println("test case is passed,It should display error message");
			  }else
			  {
			  System.out.println("Test case is failed");
		  }

	  		
	  	}
	  	@Test (priority=4)//enter Invalid username and valid password
	  	public void InValiduserandvalidPas() {
	  		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	  		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin@123");
	  		driver.findElement(By.xpath("//a[@id='log-in']")).click();
	  		
	  		String expectedUrl = "https://demo.applitools.com/#";
			  String actualUrl = driver.getCurrentUrl();
			  Assert.assertEquals(actualUrl, expectedUrl);
			  if(actualUrl.equals(expectedUrl)) {
				  System.out.println("test case is passed,It should display error message");
			  }else
			  {
			  System.out.println("Test case is failed");
		  }

	  		
	  	}
	  	@Test (priority=5)//enter valid username and more than 20 characters in password
	  	public void boundryequilvalance() {
	  		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	  		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("daskpofopsdkfksdkposp31313131");
	  		driver.findElement(By.xpath("//a[@id='log-in']")).click();
	  		
	  		String expectedUrl = "https://demo.applitools.com/#";
			  String actualUrl = driver.getCurrentUrl();
			  Assert.assertEquals(actualUrl, expectedUrl);
			  if(actualUrl.equals(expectedUrl)) {
				  System.out.println("test case is passed,It should display error message");
			  }else
			  {
			  System.out.println("Test case is failed");
		  }

	  		
	  	}
	  	@Test (priority=6)//enter specials characters in UserName and Password 
	  	public void SpecialChar() {
	  		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("!@#$%^%^*(&*()_");
	  		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("!@#$%^&*(()");
	  		driver.findElement(By.xpath("//a[@id='log-in']")).click();
	  		
	  		String expectedUrl = "https://demo.applitools.com/#";
			  String actualUrl = driver.getCurrentUrl();
			  Assert.assertEquals(actualUrl, expectedUrl);
			  if(actualUrl.equals(expectedUrl)) {
				  System.out.println("test case is passed,It should display error message");
			  }else
			  {
			  System.out.println("Test case is failed");
		  }

	  		
	  	}
	  
	  
	  
	  
	  
	@AfterMethod
	public void closeBrowser() {
		
	      driver.quit();
	}







}
