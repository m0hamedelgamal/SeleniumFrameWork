package testcases;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.jsondatareader;
import pages.ChangePassword;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;

public class UserRegWithDDTwithJsonDataFile extends TestBase 

{		
	ClickRegisetrationLink  ClickRegisteratinObject ;   
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 
	ChangePassword ChangepswdObject; 

	@Test (priority = 1) 
	public void successfullRegisteration() throws InterruptedException, IOException, ParseException
	{
		jsondatareader jsnreader= new jsondatareader(); 
		jsnreader.jsonReader();
		
		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.openRegisterLink();
		Thread.sleep(2020);
		registerationPageObject= new Registeration(driver);
		registerationPageObject.EnterData(jsnreader.firstName,jsnreader.lastName,jsnreader.eMail,jsnreader.Pswd);
		
		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
		// Logout
		ClickRegisteratinObject.Clicklogout();
		ClickRegisteratinObject.openloginPage();    
		//login
		loginObject = new LoginIn(driver); 
		loginObject.EnterLoginData(jsnreader.eMail,jsnreader.Pswd); 
		//LogOut
		ClickRegisteratinObject.Clicklogout();
	}}
