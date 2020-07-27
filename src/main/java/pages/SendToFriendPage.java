package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendToFriendPage extends PageBase
{
	public SendToFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FriendEmail")
	WebElement friendsEmail; 
	@FindBy(id = "PersonalMessage")
	WebElement pMessage; 
	@FindBy(name = "send-email")
	WebElement sendEmailbtn; 
	@FindBy(css = "div.result")
	WebElement submiMessage; 

	public void SendItmeTofriend(String FriendEmail ,String PersonalMessage )
	{
		SetTextValue(friendsEmail, FriendEmail);
		SetTextValue(pMessage, PersonalMessage);
		ClickBTNS(sendEmailbtn);
	}


}
