package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UserProfile {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		 driver.get("https://demo.applitools.com/app.html#");
		
			
		driver.manage().window().maximize();
		

	}
	@Test(priority=1)// Verify if the User Profile dropdown Button is working
	public void DropDownCheck() {
		 //locate the dropdown element
		 WebElement dropdown = driver.findElement(By.xpath("//div[@class='os-icon os-icon-chevron-down']"));
		 Select select = new Select(dropdown);
		 
		 String expectedSelectedOption = "Option 1";
		 //select an option from the dropdown
		 select.selectByVisibleText(expectedSelectedOption);
		 
		 //Get the selected Option
		 WebElement selectedOption = select.getFirstSelectedOption();
		 String actualSelectedOption = selectedOption.getText();
		 
		 Assert.assertEquals("Dropdown selected button is not working as expected",expectedSelectedOption,actualSelectedOption);
	}
	
	
	
	// if dropdown button is working :-
	@Test(priority=2)//verify the dropdown button is showing the options or not
	public void OptionsCheck() {
		 //locate the dropdown element
		 WebElement dropdown = driver.findElement(By.xpath("//div[@class='os-icon os-icon-chevron-down']"));
		 Select select = new Select(dropdown);
		WebElement defaultOption = select.getFirstSelectedOption();
		String expectedDefaultOption = "profile";
		String actualDefaultOption = defaultOption.getText();
		
		Assert.assertEquals(expectedDefaultOption,actualDefaultOption);
		if(actualDefaultOption.equals(expectedDefaultOption)) {
			System.out.println("It should Display all the options");
		}
		else {
			System.out.println("Dropdown button is not enabled");
		}
	}

	  
		@AfterMethod
		public void closeBrowser() {
			
		      driver.quit();
		}





}
