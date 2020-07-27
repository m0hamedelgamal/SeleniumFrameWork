package testcases;
import org.testng.annotations.Test;
import pages.ItemsPage;
import pages.SearchPage;

public class SearchForItems extends TestBase 

{
	SearchPage SearchPageobject ; 
	ItemsPage itemspageResult;
	String itemname="gift"; 

	@Test
	public void userCanSearchforProducts()

	{
		SearchPageobject= new SearchPage(driver);
		itemspageResult = new ItemsPage(driver); 
		SearchPageobject.itemSearchname(itemname);
		System.out.println(itemspageResult.resultElements.size());
	}

}
