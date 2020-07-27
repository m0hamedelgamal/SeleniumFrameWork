package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderReviewPage extends PageBase {

	public OrderReviewPage(WebDriver Wbdriver) {
		super(Wbdriver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitle; 
	@FindBy (id="AddProductReview_ReviewText")
	WebElement reviewText; 
	@FindBy(id = "addproductrating_4")
	WebElement ratingOptions; 
	@FindBy(name = "add-review")
	WebElement submitReview; 
	@FindBy(css = "div.result")
	public WebElement reviewnotification; 


	public void addRate(String title, String textreview)
	{
		SetTextValue(reviewTitle, title);
		SetTextValue(reviewText, textreview);
		ClickBTNS(ratingOptions);
		ClickBTNS(submitReview);

	}

}
