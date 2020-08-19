package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ClickRegisetrationLink;
import pages.ItemsPage;
import pages.SearchPage;

public class ChangeCurrency extends TestBase
{
	ClickRegisetrationLink homePage; 
	SearchPage searchpageobject; 
	ItemsPage itemspageobject;
	int proudctId=0; 

	@Test
	public void changeCurrency() throws InterruptedException

	{
		homePage= new ClickRegisetrationLink(driver); 
		homePage.changeCurrency();

	}

	String itemtxt="gift"; 
	@Test(priority = 2)
	public void searchItems() throws InterruptedException
	{
		searchpageobject= new SearchPage(driver); 
		searchpageobject.SearchWithAutocomplete(itemtxt , proudctId);
		itemspageobject=new ItemsPage(driver); 
		Assert.assertTrue(itemspageobject.itemPrice.getText().contains("€"));
		System.out.println(itemspageobject.itemPrice.getText());
	}




}
