package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ChangePassword extends PageBase{

	public ChangePassword(WebDriver Wbdriver) 
	{
		super(Wbdriver);
	}

	@FindBy(linkText = "My account")
	WebElement OpenMyaccount; 
	@FindBy(linkText ="Change password")
	WebElement changePSWDbtn ;  
	@FindBy(id="OldPassword")
	WebElement oldpswdtxt; 
	@FindBy(id="NewPassword") 
	WebElement newpswdtxt; 
	@FindBy(id="ConfirmNewPassword")
	WebElement Confirmnewpswdtxt; 
	@FindBy(xpath = "//input[@class='button-1 change-password-button']")
	WebElement confirmChangingPswdbtn; 
	@FindBy(xpath ="//div[@class='result']")
	public WebElement resultconfirmation; 

	
	public void openMyaccountpage()
	{
		ClickBTNS(OpenMyaccount);
		
	}
	
	public void chagnePassword(String oldpassword , String newpassword)
	{

		ClickBTNS(changePSWDbtn);
		SetTextValue(oldpswdtxt,oldpassword);
		SetTextValue(newpswdtxt, newpassword);
		SetTextValue(Confirmnewpswdtxt, newpassword);
		ClickBTNS(confirmChangingPswdbtn);

	}

}
