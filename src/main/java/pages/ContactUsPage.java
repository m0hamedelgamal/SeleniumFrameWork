package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver Wbdriver)
	{
		super(Wbdriver);
		jse=(JavascriptExecutor) Wbdriver; 
	}

	@FindBy(linkText = "Contact us")
	public WebElement Contactuslink; 

	@FindBy(id = "FullName")
	WebElement ContactNamefield; 

	@FindBy(id = "Email")
	WebElement ContactEmailfield ; 

	@FindBy(css = "textarea.enquiry")
	WebElement enquiryField;  

	@FindBy(name = "send-email")
	WebElement contactusSubmitbutton; 

	@FindBy(css = "div.result")
	public WebElement contactusResult; 

	public void contactusform(String name , String email , String enquiry, WebElement desiredElement  ) throws InterruptedException 
	{
		scrollToAneelement(desiredElement); 
		ClickBTNS(Contactuslink);
		Thread.sleep(3000);
		SetTextValue(ContactNamefield,name );
		SetTextValue(ContactEmailfield,email);
		SetTextValue(enquiryField,enquiry);
		ClickBTNS(contactusSubmitbutton);
	}
}
