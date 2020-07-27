package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClickRegisetrationLink;
import pages.ItemsPage;
import pages.LoginIn;
import pages.Registeration;
import pages.SearchPage;
import pages.SendToFriendPage;

public class EmailToFriendTest extends TestBase
{
	Registeration registerationPageObject; 
	LoginIn loginpageObject; 
	ClickRegisetrationLink  homepageobject ;   
	ItemsPage itemspageobject;
	SearchPage searchpageobject; 
	SendToFriendPage sendToFriendPageobject; 


	// 1-Registeration  
	String firstName="Mohmae7ad"; 
	String lastName="Ealgaaamal" ; 
	String eMail="tesssasast@3xx.com"; 
	String Pswd="asd123456"; 
	String NewPswd="123456"; 
	int proudctId =0 ; 
			@Test (priority = 1) 
	public void userRegisteration() throws InterruptedException
	{
		homepageobject= new ClickRegisetrationLink(driver); 
		homepageobject.openRegisterLink();
		Thread.sleep(2020);
		registerationPageObject= new Registeration(driver);
		registerationPageObject.EnterData(firstName, lastName,eMail,Pswd);
		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
		Thread.sleep(1000);
	}

	// 2- Search 

	String itemtxt="gift"; 
	@Test(priority = 2)
	public void searchItems() throws InterruptedException
	{
		searchpageobject= new SearchPage(driver); 
		searchpageobject.SearchWithAutocomplete(itemtxt , proudctId);
	}

	// 3- email to friend
	String Friend_email="test@test1.com"; 
	String personalMSG= "saba7 el fol yasa7by "; 
	@Test(priority=3)
	public void emailtofriend()
	{
		itemspageobject= new ItemsPage(driver);
		itemspageobject.sendToFriend();
		sendToFriendPageobject= new SendToFriendPage(driver); 
		sendToFriendPageobject.SendItmeTofriend(Friend_email, personalMSG);
	}

}
