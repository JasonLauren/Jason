package CW.CAP;



import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

 
public class AppTest 
{
  
   @Given("^open chrome$")
    public void open_chrome()
    {
	   WebDriver driver;
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KITTU\\Downloads\\eclipse\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://freeCRM.com");
        driver.manage().window().maximize();
        
        
    }
}
