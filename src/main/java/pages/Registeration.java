package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registeration extends PageBase 
{
	public Registeration(WebDriver Wbdriver) 
	{
		super(Wbdriver);
	}
	//Gender
	//@FindBy(id = "gender-male")

	@FindBy(xpath = "/html//input[@id='gender-male']") 
	 WebElement GenderMale;

	@FindBy(xpath = "/html//input[@id='gender-female']")
	//@FindBy(id = "gender-female")
	WebElement GenderFemale;

	//Full name 
	@FindBy(xpath = "/html//input[@id='FirstName']")
	//@FindBy(id = "FirstName")
	 WebElement FName;

	@FindBy(xpath ="/html//input[@id='LastName']")
	//@FindBy(id = "LastName")
	 WebElement LName;

	@FindBy(name = "DateOfBirthDay") 
	WebDriver DateOfBirth; 

	//Date
	@FindBy(name = "DateOfBirthMonth") 
	WebDriver DateOfBirthMonth; 

	@FindBy(name = "DateOfBirthYear") 
	WebDriver DateOfBirthYear; 
	//Email
	@FindBy(id ="Email") 
	WebElement Email; 

	//PAssword
	@FindBy(id ="Password") 
	WebElement Password; 

	@FindBy(id ="ConfirmPassword") 
	WebElement ConfirmPassword; 

	@FindBy(id ="register-button") 
	WebElement registerButton; 
	@FindBy(css = "div.result")
	public WebElement Successregister; 


	//,String Day,String Month,String year
	public void EnterData(String fname,String lname,String mail,String pswd)
	{
		ClickBTNS(GenderMale);
		SetTextValue(FName, fname);
		SetTextValue(LName, lname);
		SetTextValue(Email,mail);
		SetTextValue(Password,pswd);
		SetTextValue(ConfirmPassword,pswd);
		/*Select DOB= new Select((WebElement) DateOfBirth);
		DOB.selectByValue(Day);
		Select MOB= new Select((WebElement) DateOfBirth);
		MOB.selectByValue(Month);
		Select YOB= new Select((WebElement) DateOfBirth);
		YOB.selectByValue(year);
		//DateOfBirth.selectByValue(Day);
		//DateOfBirthMonth.selectByValue(Month);
		//DateOfBirthYear.selectByValue(year);*/
		ClickBTNS(registerButton);
	}
}
