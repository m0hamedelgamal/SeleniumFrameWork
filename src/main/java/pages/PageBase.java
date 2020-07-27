package pages;
import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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


}
