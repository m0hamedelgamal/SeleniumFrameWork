package steps;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;
import testcases.TestBase;

public class registeration extends TestBase 
{
	ClickRegisetrationLink  ClickRegisteratinObject ;   
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 

	@Given("user in the registration page")
	public void user_in_the_registration_page() 
	{
		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.openRegisterLink();
		Assert.assertTrue(driver.getCurrentUrl().contains("register")); 
	}



	/*@When("Completing the Registrration data")
	public void completing_the_registrration_data() 
	{
		registerationPageObject= new Registeration(driver); 

	 * Faker faker = new Faker(); String firstName=faker.name().firstName(); String
	 * lastName=faker.name().lastName(); String
	 * eMail=faker.internet().emailAddress(); String
	 * Pswd=faker.internet().password(6,10,true,true,true);
		registerationPageObject.EnterData(firstName, lastName, eMail, Pswd);} */

	@When("add Registeration data {string}, {string},{string},{string}")
	public void add_registeration_data(String fname, String lname, String email, String pswd) 
	{
		registerationPageObject= new Registeration(driver); 
		registerationPageObject.EnterData(fname,lname,email,pswd);
	}

	@When("click Register")
	public void click_register() 
	{

	}
	@Then("User registered and logged in successfully")
	public void user_registered_and_logged_in_successfully() 
	{
		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
	}
}
