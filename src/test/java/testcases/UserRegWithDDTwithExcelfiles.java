package testcases;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelDataReader;
import data.ExcelReader;
import data.jsondatareader;
import pages.ChangePassword;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;

public class UserRegWithDDTwithExcelfiles extends TestBase 

{		
	//PageBase PageBaseOject ; 
	ClickRegisetrationLink  ClickRegisteratinObject ;   
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 
	ChangePassword ChangepswdObject; 
	
	@DataProvider(name="excelreader")
	public Object[][] userData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelDataReader ER = new ExcelDataReader();
		return ER.getTestDataFromExcel();
	}

	@Test (priority = 1,dataProvider = "excelreader") 
	public void successfullRegisteration(String firstname , String lastname , String email , String password) throws InterruptedException, IOException, ParseException
	{
		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.openRegisterLink();
		Thread.sleep(2020);
		registerationPageObject= new Registeration(driver);

		registerationPageObject.EnterData(firstname,lastname,email,password);
		
		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
		// Logout
		ClickRegisteratinObject.Clicklogout();
		ClickRegisteratinObject.openloginPage();    
		//login
		loginObject = new LoginIn(driver); 
		loginObject.EnterLoginData(email,password); 
		ClickRegisteratinObject.Clicklogout();
	}}
