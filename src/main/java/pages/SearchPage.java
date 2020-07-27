package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase 
{
	public SearchPage(WebDriver Wbdriver) 
	{
		super(Wbdriver);
	}

	@FindBy(id = "small-searchterms") 
	WebElement searchfieldtxt ; 

	@FindBy (css = "input.button-1.search-box-button")
	WebElement cickSearch ; 

	@FindBy(className ="ui-menu-item")
	public List<WebElement> autocmpleteitemlist ; 

	public void itemSearchname(String SearchitemName)
	{
		SetTextValue(searchfieldtxt,SearchitemName);
		ClickBTNS(cickSearch);
	}

	/*public void getnumberofitems(String itemname) throws InterruptedException
	{
		SetTextValue(searchfieldtxt, itemname);
		Thread.sleep(1000);
	}*/
	
	public int productnumbers(String itemname) throws InterruptedException
	{
		SetTextValue(searchfieldtxt, itemname);
		Thread.sleep(2000);
		return autocmpleteitemlist.size(); 
	}
	public void SearchWithAutocomplete(String itemname , int productId) throws InterruptedException
	
	{
		cleartextField(searchfieldtxt);
		SetTextValue(searchfieldtxt, itemname);
		Thread.sleep(2000);
		autocmpleteitemlist.get(productId).click();
	}}


