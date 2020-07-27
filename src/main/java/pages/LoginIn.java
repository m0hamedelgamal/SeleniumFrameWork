package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginIn extends PageBase {

	public LoginIn(WebDriver Wbdriver)
	{
		super(Wbdriver);
	}

	@FindBy(id ="Email")
	WebElement EnterEmail; 
	
	@FindBy(id ="Password")
	WebElement EnterPassword; 
	
	@FindBy(css = "input.button-1.login-button")
	WebElement ClickLogin; 

public void EnterLoginData(String email , String pswd)
{
	SetTextValue(EnterEmail,email);
	SetTextValue(EnterPassword,pswd);
	ClickBTNS(ClickLogin);
}
}
