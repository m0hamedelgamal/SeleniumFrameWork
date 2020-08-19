package testRunner;
import io.cucumber.testng.CucumberOptions;
import testcases.TestBase;


@CucumberOptions(features="src\\test\\java\\features",
					glue= {"steps"},
					plugin =  {"pretty","html:target\\cucumber-html-report"})
public class Runner extends TestBase
{

}
