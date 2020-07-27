package testcases;

import org.testng.annotations.Test;

import pages.ClickRegisetrationLink;

public class ProduvtHover extends TestBase
{
	ClickRegisetrationLink homepage; 

	@Test
	public void openMenuItems()
	{
		homepage= new ClickRegisetrationLink(driver); 
		homepage.openMenuItems();
	}
}
