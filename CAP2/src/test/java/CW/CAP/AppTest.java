package CW.CAP;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.util.Timeout;
public class AppTest 
{
	public WebDriver driver;
	@Given("^open chrome$")
	public void open_chrome() throws InterruptedException
	{

		System.out.println("Hello");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\KITTU\\Downloads\\eclipse\\chromedriver.exe");
		// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability("marionette", true);
		driver= new ChromeDriver();
		System.out.println("chrome opened");
		driver.get("https://freeCRM.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("method 1 finished");
		System.out.println("user entered login page");
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		Thread.sleep(1000);
	}

	@When("user enters in loginpage")
	public void user_enters_in_loginpage() throws InterruptedException 
	{
		String title = driver.getTitle();
		System.out.println("Login Page :  "+ title);

	}
	@Then("^enters \"(.*)\" and \"(.*)\"$")
	public void enters(String uname ,String pwd) throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println(uname+" : " + pwd);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email' and @type='text']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[contains(text(),'Login') and @class='ui fluid large blue submit button']")).click();
		String title = driver.getTitle();
		System.out.println("Home Page :  "+ title);
		Thread.sleep(1000);

	}
	@After
	@Then("^logout FreeCRM$")
	public void logout_FreeCRM() throws InterruptedException
	{	
		try
		{	   
			driver.findElement(By.xpath("//div[@class='ui basic button floating item dropdown']")).click();
			driver.findElement(By.xpath("//i[@class='power icon']")).click();
			driver.close();
			driver.quit();

		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
		System.out.println("Class finished: Brower closed");

	}
	@Given("^User click on conatacts tab$")
	public void User_click_on_conatacts_tab()
	{

		driver.findElement(By.xpath("//i[@class='users icon']")).click();
		System.out.println("user clicked on contacts");

	}
	@When("^select new contact button$")
	public void select_new_contact_button()
	{
		driver.findElement(By.xpath("//a[@href='/contacts/new']")).click();
	}
	@Then("^enters user details$")
	public void enters_user_details(DataTable obj) throws InterruptedException
	{
		//wait(2000);
		for(Map<String,String> data:obj.asMaps(String.class,String.class))
		{
			driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(data.get("fname"));
			driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(data.get("lname"));
			driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(data.get("email"));
			driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
			Thread.sleep(2000);
			User_click_on_conatacts_tab();
			select_new_contact_button();
		}
	}
}