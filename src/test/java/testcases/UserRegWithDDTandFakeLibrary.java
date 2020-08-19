package testcases;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ChangePassword;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;

public class UserRegWithDDTandFakeLibrary extends TestBase 

{		
	ClickRegisetrationLink  ClickRegisteratinObject ;   
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 
	ChangePassword ChangepswdObject; 


	@Test (priority = 1) 
	public void successfullRegisteration() throws InterruptedException, IOException, ParseException
	{

		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.openRegisterLink();
		Thread.sleep(2020);
		registerationPageObject= new Registeration(driver); 
		Faker faker = new Faker(); 
		String firstName=faker.name().firstName(); 
		String lastName=faker.name().lastName();
		String eMail=faker.internet().emailAddress(); 
		String Pswd=faker.internet().password(6,10,true,true,true);
		System.out.println(firstName + "//" + lastName +"//"+ eMail+"//"+Pswd);

		registerationPageObject.EnterData(firstName,lastName,eMail,Pswd);

		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
		// Logout
		ClickRegisteratinObject.Clicklogout();
		ClickRegisteratinObject.openloginPage();    
		//login
		loginObject = new LoginIn(driver); 
		loginObject.EnterLoginData(eMail,Pswd); 
		//LogOut
		
		ClickRegisteratinObject.Clicklogout();
	}}
