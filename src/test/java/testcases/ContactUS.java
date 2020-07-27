package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ClickRegisetrationLink;
import pages.ContactUsPage;
import pages.PageBase;

public class ContactUS extends TestBase

{
	PageBase pageBaseobject; 
	ContactUsPage contactUsPageobject; 
	ClickRegisetrationLink homepageobject; 

	String name ="TESTTEST" ; 
	String email="TE33ST@test.com"; 
	String enquiry="Ana bt2t3 mn gwaya" ;

	@Test
	public void sendcontactusdata() throws InterruptedException 
	{
		contactUsPageobject= new ContactUsPage(driver); 	
		contactUsPageobject.contactusform(name, email, enquiry,contactUsPageobject.Contactuslink);
		//Assert.assertTrue(contactUsPageobject.contactusResult.getText().contains("Your enquiry has been successfully sent to the store owner"));
		String result= contactUsPageobject.contactusResult.getText().toString(); 
		Assert.assertEquals(result,"Your enquiry has been successfully sent to the store owner.");
	}

}
