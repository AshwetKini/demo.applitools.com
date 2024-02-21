package LOGIN_PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verify_Url {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		// WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test(priority=1) //verify Correct Url
	public void testCorrectUrl() {
		driver.get("https://demo.applitools.com/");
		String url = driver.getCurrentUrl();
				Assert.assertEquals(url, "https://demo.applitools.com/");
					
	}
	@Test(priority=2)//verify incorrect URL
	public void testInCorrectUrl() {
		driver.get("https://www.demo.applitools.com/");
		String URL = driver.getCurrentUrl();
		Assert.assertNotEquals(URL,"https:www.google.com/");
	
	}
	@Test(priority=3)//verify Redirected to HTTPS:
	public void testRedirectdtoHTTPS() {
		driver.get("http://www.demo.applitools.com/");
		 driver.getCurrentUrl();
		Assert.assertEquals("https://www.demo.applitools.com/","http://www.demo.applitools.com/");
		
	
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		
	      driver.quit();
	}

	
	
	
}
