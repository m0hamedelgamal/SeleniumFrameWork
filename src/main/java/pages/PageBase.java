package pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase 

{
	// driver used to read elements 
	protected WebDriver driver ; 
	public JavascriptExecutor   jse ;  
	public Select menuSelect;  
	public Actions myactions; 

	public PageBase(WebDriver Wbdriver)
	{
		PageFactory.initElements(Wbdriver,this);
	}
	protected static void ClickBTNS(WebElement btn)
	{
		btn.click();
	}

	protected static void SetTextValue(WebElement flltext , String txt)
	{
		flltext.sendKeys(txt);
	}

	public void scrollToAneelement(WebElement desiredElement)
	{
		jse.executeScript("arguments[0].scrollIntoView(true);",desiredElement); 
	}

	public void cleartextField(WebElement txtfield)
	{
		txtfield.clear();
	}


	public void uploadfile() throws AWTException
	{
		String filename=""; 
		String filePath=""; 
		Robot robot= new Robot(); 
	}

	public void ExplicitWaitFunction(int seconds ,WebElement WaitedElement)
	{
		WebDriverWait ex_Wait= new WebDriverWait(driver,seconds); 
		//ex_Wait.until(ExpectedConditions.invisibilityOfElementLocated((By) WaitedElement)); 
	}
	public void FlunetWaitFunction(int Timeout,int TimeToPull)
	{
		Wait<WebDriver> FL_Wait= new FluentWait<WebDriver>(driver)
				.withTimeout(Timeout, TimeUnit.SECONDS)
				.pollingEvery(TimeToPull, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
	}

}
