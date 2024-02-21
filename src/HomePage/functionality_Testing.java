package HomePage;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class functionality_Testing {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		driver.get("https://demo.applitools.com/app.html");
		driver.manage().window().maximize();
			}
	//verify Search Functionality
		@Test(priority=1)
		public void searchBox() {
		WebElement SearchBox_btn = driver.findElement(By.xpath("//input[@placeholder='Start typing to search...']"));
		SearchBox_btn.sendKeys("My balance");
		driver.findElement(By.xpath("//input[@placeholder='Start typing to search...']")).submit();
		
		 // Verify that the search results page is displayed
	    WebElement resultsPageHeader = driver.findElement(By.xpath("//h1[contains(text(),'My balance')]"));
	    Assert.assertTrue(resultsPageHeader.isDisplayed(), "Search results page not displayed.");

	    // Verify that the search term is present in the results
	    WebElement searchTermInResults = driver.findElement(By.xpath("//div[contains(text(),'" + "My balance" + "')]"));
	    Assert.assertTrue(searchTermInResults.isDisplayed(), "Search term not found in results.");
		}

	
	@Test (priority=2) //verify if AddAccount button is working or not
	public void AddButton() {
	WebElement AddButton = driver.findElement(By.xpath("//span[normalize-space()='Add Account']"));
	AddButton.click();
	String currentUrl = driver.getCurrentUrl();
	Assert.assertNotEquals(currentUrl,"Add Account is not working");
	}
	
	@Test (priority=3) //verify if MakePaymentButton is working or not
	public void MakePaymentButton() {
	WebElement MakePayButton = driver.findElement(By.xpath("//span[normalize-space()='Make Payment']"));
	MakePayButton.click();
	String currentUrl = driver.getCurrentUrl();
	Assert.assertNotEquals(currentUrl,"Add Account is not working");
	}
	
	//trying to view statement
	@Test(priority=4)
	public void ViewStatement() {
		WebElement ViewButton = driver.findElement(By.xpath("//span[normalize-space()='View Statement']"));
		ViewButton.click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl,"Add Account is not working");
	}
	
	//trying to pay Dues
	@Test(priority=5)
	public void PayDue() {
		WebElement PayDuesButton = driver.findElement(By.xpath("//span[normalize-space()='Pay Now']"));
		PayDuesButton.click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl,"Add Account is not working");
	}
		
	
	
	

	@AfterMethod
	public void closeBrowser() {
		
	      driver.quit();
	}

}
