package testcases;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import data.ExcelDataReader;
import data.ExcelReader;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;
import pages.ChangePassword;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;

public class UserRegWithDDTwithCSVFiles extends TestBase 

{		
	ClickRegisetrationLink  ClickRegisteratinObject ;
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 
	ChangePassword ChangepswdObject; 
	CSVReader csv_reader ; 

	@Test (priority = 1) 
	public void successfullRegisteration()throws InterruptedException, CsvValidationException, IOException
	{
		FileReader FR = new FileReader(System.getProperty("user.dir")+
				"\\src\\test\\java\\data\\CSV.csv"); 
		csv_reader= new CSVReader(FR); 
		String[] csvcell;

		while((csvcell=csv_reader.readNext())!=null)
		{
			String firstName= csvcell[0]; 
			String lastName=csvcell[1];
			String eMail=csvcell[2];
			String Pswd=csvcell[3];
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

	}}
