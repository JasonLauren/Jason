package CW.CAP;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="C:\\Users\\KITTU\\eclipse-workspace\\CAP\\src\\test\\java\\CW\\CAP\\login.feature",
		dryRun=false,
		monochrome=true,
		plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
		)
public class Running 
{

}
