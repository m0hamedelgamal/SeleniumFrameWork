package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClickRegisetrationLink;
import pages.ItemsPage;
import pages.OrderReviewPage;
import pages.Registeration;
import pages.SearchPage;

public class OrderReview extends TestBase
{ 
	ClickRegisetrationLink  homepageobject ;
	Registeration registerationPageObject; 
	SearchPage searchpageobject; 
	ItemsPage itemspageobject;
	OrderReviewPage orderReviewPGObject; 

	// 1-Registeration  
	String firstName="Mohmae7ad"; 
	String lastName="Ealgaaamal" ; 
	String eMail="teast@3xx.com"; 
	String Pswd="asd123456"; 
	String NewPswd="123456"; 
	int proudctId=0; 

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
	String title= "newReview"; 
	String reviewtext="this is the new review"; 
	@Test(priority = 3)
	public void addItemReviw()
	{
		itemspageobject	= new ItemsPage(driver); 
		itemspageobject.openReviwPage();
		orderReviewPGObject = new OrderReviewPage(driver); 
		orderReviewPGObject.addRate(title, reviewtext);
		Assert.assertTrue(orderReviewPGObject.reviewnotification
				.getText().contains("added"));
		homepageobject.nopcommercehome.click();
	}


}
