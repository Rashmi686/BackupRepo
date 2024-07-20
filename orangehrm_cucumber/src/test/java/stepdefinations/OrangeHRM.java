package stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OrangeHRM 
{
	public static WebDriver driver;
	
		@Given("^i open browser with the url \"([^\"]*)\"$")
		public void launchApp(String url) 
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");		
			
			driver = new ChromeDriver ();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
		    
		}

		@Then("^i should see login page$")
		public void i_should_see_login_page() 
		{
			if(driver.findElement(By.id("btnLogin")).isDisplayed())
					{
				System.out.println("System displayed Login page");
					}
		   
		}

		@When("^i enter username as \"([^\"]*)\"$")
		public void i_enter_username_as(String uname) 
		{
			driver.findElement(By.id("txtUsername")).sendKeys(uname);
		}

		@When("^i enter password as \"([^\"]*)\"$")
		public void i_enter_password_as(String pwd) 
		{
			driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		}

		@When("^i click login$")
		public void i_click_login() 
		{
			driver.findElement(By.id("btnLogin")).click();
		}
		

		@Then("^i should see admin module$")
		public void i_should_see_admin_module() 
		{
		   if(driver.findElement(By.linkText("Admin")).isDisplayed())
		   {
			   System.out.println("System displayed Admin Module");
		   }
		}
		@When("^i click logout$")
		public void i_click_logout() 
		{
		   driver.findElement(By.partialLinkText("Welcome")).click();
		   driver.findElement(By.partialLinkText("Logout")).click();
		}

		@When("^i close browser$")
		public void i_close_browser() 
		{
		   driver.close();
		}
		
		@Then("^i should see error message$")
		public void i_should_see_error_message() 
		{
		   String errmsg = driver.findElement(By.id("spanMessage")).getText();
		   if(errmsg.toLowerCase().contains("invalid") || errmsg.toLowerCase().contains("empty"))
				   {
			   System.out.println("System showing expected error msg");
				   }
		}

}
