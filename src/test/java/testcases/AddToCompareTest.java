package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ItemsPage;
import pages.SearchPage;
import pages.compareItemsPage;

public class AddToCompareTest extends TestBase
{
	SearchPage searchpageobject; 
	ItemsPage itemspageobject;
	compareItemsPage compareItemsObject; 
	String productname= "gift" ; 

	@Test(priority = 0)
	public void additemsToCompareList() throws InterruptedException
	{
		//Search for product
		searchpageobject= new SearchPage(driver); 
		itemspageobject= new ItemsPage(driver); 

		int size=searchpageobject.productnumbers(productname) ; 
		System.out.println(size);
		for (int i = 0; i < size; i++) 
		{
			searchpageobject.SearchWithAutocomplete(productname,i);
			itemspageobject.addproductToCompareList();
			Thread.sleep(2000);
		}
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
	}	
	@Test (priority = 1)
	public void compareAddedElements()
	{
		compareItemsObject= new compareItemsPage(driver); 
		compareItemsObject.compareProduct();
		compareItemsObject.clearList();

	}
	@Test(priority = 2)
	public void clearCompareList()
	{
		
		compareItemsObject.clearList();
		Assert.assertTrue(compareItemsObject.noDataEmptyTemp.getText()
				.contains("You have no items to compare."));
	}
}
