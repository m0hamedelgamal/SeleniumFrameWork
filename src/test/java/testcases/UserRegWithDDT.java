package testcases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ChangePassword;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;

public class UserRegWithDDT extends TestBase 

{	
	//PageBase PageBaseOject ; 
	ClickRegisetrationLink  ClickRegisteratinObject ;   
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 
	ChangePassword ChangepswdObject; 
 
	@DataProvider(name ="testData")
	public static Object [][] userdata()
	{
		 return new Object[][] {
			 {"Mohamed" ,"Elgaamal","g0mai@xxx.com" ,"asd123456" } , 
			 {"Mohamed" ,"Elgaamal","g0maix1@xxx.com" ,"asd123456" } , 
			 {"Mohamed" ,"Elgaamal","g0maix1@xxx.com" ,"asd123456" } ,
			 {"Mohamed" ,"Elgaamal","g0maixa1@xxx.com" ,"asd123456" } 
		 };}


	@Test (priority = 1 , dataProvider = "testData") 
	public void successfullRegisteration(String firstName ,String lastName ,String eMail, String Pswd ) throws InterruptedException
	{
		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.openRegisterLink();
		Thread.sleep(2020);

		registerationPageObject= new Registeration(driver);
		registerationPageObject.EnterData(firstName, lastName,eMail,Pswd);
		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
		// Logout
		ClickRegisteratinObject.Clicklogout();
		ClickRegisteratinObject.openloginPage();    
		//login
		loginObject = new LoginIn(driver); 
		loginObject.EnterLoginData(eMail,Pswd); 
		
		ClickRegisteratinObject.Clicklogout();

	}
	/*
	@Test(enabled = false)
	public void changepassword()

	{
		ChangepswdObject = new ChangePassword(driver); 
		ChangepswdObject.openMyaccountpage();
		ChangepswdObject.chagnePassword(Pswd, NewPswd);
		Assert.assertTrue(ChangepswdObject.resultconfirmation.getText()
				.contains("Password was changed"));
	}*/}
