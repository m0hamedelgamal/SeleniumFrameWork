package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemsPage;
import pages.SearchPage;

public class SearchProductswithAutoCompelte  extends TestBase

{
	String itemtxt="gift"; 
	int productID= 0 ; 
	
	SearchPage searchpageobject; 
	ItemsPage itemspageobject;
	@Test(priority = 1)
	public void searchItems() throws InterruptedException
	{
		searchpageobject= new SearchPage(driver); 
		searchpageobject.SearchWithAutocomplete(itemtxt , productID);
		itemspageobject= new ItemsPage(driver); 
		 Assert.assertTrue(itemspageobject.proudctName.getText().contains("Gift"));
	}




}
