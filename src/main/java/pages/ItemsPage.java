package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends PageBase 
{

	public ItemsPage(WebDriver Wbdriver) 
	{
		super(Wbdriver);
	}

	@FindBy(css = "strong.current-item")
	WebElement ItemBreadCrumb; 

	@FindBy(css = "div.item-box")
	public 	List<WebElement> resultElements; 

	@FindBy(css = "strong.current-item")
	public WebElement proudctName; 

	@FindBy(xpath = "//div[@class='email-a-friend']")
	WebElement emailToFriend ; 

	@FindBy(css = "div.product-price")
	public WebElement itemPrice; 

	@FindBy(linkText = "Add your review")
	WebElement addYourReview; 

	@FindBy(id = "add-to-wishlist-button-45")
	WebElement addToWishListBTN;

	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareListBTN; 

	@FindBy(css = "input.button-1.add-to-cart-button")
	WebElement addToCartBTN; 
	public void sendToFriend()
	{
		ClickBTNS(emailToFriend);
	}
	public void openReviwPage() 
	{
		ClickBTNS(addYourReview);
	}
	public void AddToCart()
	{
		ClickBTNS(addToCartBTN);
	}
	public void AddProductWishList()
	{
		ClickBTNS(addToWishListBTN);
	}
	public void addproductToCompareList()
	{
		ClickBTNS(addToCompareListBTN);
	}
	public void search()
	{
		
	}
}
