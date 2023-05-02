package magento.pages;

import magento.TestContext;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ItemInfoPage extends BasePage{
	
		@FindBy(css = "h1 span.base")
	    private WebElement lbProductName;
		
	    @FindBy(xpath = "//div[@class='product-info-price']//span[@class='price-wrapper ']/span[@class='price']")
	    private WebElement lbPrize;
	    
	    @FindBy(xpath = "//div[contains(text(),'M')]")
	    private WebElement btnSize;
	    
	    @FindBy(xpath = "//div[@attribute-code='color']/div/div")
	    private WebElement btnColor;
	    
	    @FindBy(id="product-addtocart-button")
	    private WebElement btnAddToCar;
	    
	    @FindBy(xpath="/div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	    private WebElement lbYouAddedElement;
	 

	    public ItemInfoPage(TestContext context) {
	        super(context.driver);
	    }

	    public String getItemName() {
	    	return lbProductName.getText();
	    }
	    public String getItemPrice() {
	    	return lbPrize.getText();
	    }
	    public String selectItemOptions(String size) {
	    	String info =getItemName();
	    	
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@option-label='" + size +"']"))).click();
	    	btnColor.click();
	    	btnAddToCar.click();
	        // presenceOfElementLocated condition
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".message-success.success.message")));
	        return info;
	    }
	    public String selectItemOptions() {
	    	String info =getItemName();
	    	wait.until(ExpectedConditions.elementToBeClickable(btnAddToCar)).click();
	        // presenceOfElementLocated condition
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".message-success.success.message")));
	        return info;
	    }
	    
}
