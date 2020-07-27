package pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class compareItemsPage extends PageBase {

	public compareItemsPage (WebDriver Wbdriver) 
	{
		super(Wbdriver);
	}

	@FindBy(css = "a.clear-list")
	WebElement clearList;
	@FindBy(css = "div.no-data")
	public WebElement noDataEmptyTemp; 

	@FindBy(tagName = "tr")
	List<WebElement> rows ; 
	@FindBy(tagName = "td")
	List<WebElement> columns; 


	public void clearList()
	{
		ClickBTNS(clearList);	
	}

	public void compareProduct()
	{
		System.out.println("Number of Rows " + rows.size());
		System.out.println("Number of columns  " + columns.size());

		for(WebElement pageRows:rows )
		{
			System.out.println(pageRows.getText()+"\t"); 

			for(WebElement pageCol:columns)
			{
				System.out.println(pageCol.getText()+"\t"); 
			}}}}
