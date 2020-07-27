package pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ClickRegisetrationLink extends PageBase {

	public ClickRegisetrationLink(WebDriver Wbdriver) 
	{
		super(Wbdriver);
		jse=(JavascriptExecutor)driver; 
		myactions= new Actions(Wbdriver); 
	}

	@FindBy(linkText ="Register") 
	WebElement openRegister; 
	@FindBy(linkText = "Log out") 
	WebElement Logoutbtn; 
	@FindBy(linkText = "Log in")  
	WebElement OpenLoginPage; 
	@FindBy(id = "customerCurrency")
	WebElement currencyList; 
	@FindBy(xpath = "//div[@class='header-logo']//a//img")
	public WebElement nopcommercehome; 
	
	@FindBy(how = How.CSS ,using ="span.price.actual-price")
	public List<WebElement> displayedCurrency ; 

	@FindBy(linkText = "Computers")
	WebElement computerslink; 
	@FindBy(linkText = "Notebooks")
	WebElement Notebooksbtn; 
	@FindBy(linkText = "Wishlist")
	WebElement wishList; 

	public void openRegisterLink()
	{
		ClickBTNS(openRegister);
	}

	public void Clicklogout()
	{
		ClickBTNS(Logoutbtn);
	}

	public void openloginPage()
	{

		ClickBTNS(OpenLoginPage);
	}

	public void changeCurrency()
	{
		menuSelect= new Select(currencyList); 	
		menuSelect.selectByVisibleText("Euro");
	}
	public void openMenuItems()
	{
	/*	myactions.moveToElement(computerslink)
		.moveToElement(Notebooksbtn)
		.click()
		.build()
		.perform(); */
		
		myactions.moveToElement(computerslink).perform();
		myactions.moveToElement(Notebooksbtn).click().build().perform();
		

	}
	
	


}
