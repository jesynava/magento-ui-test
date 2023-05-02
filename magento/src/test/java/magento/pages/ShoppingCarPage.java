package magento.pages;

import magento.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCarPage extends BasePage {

    @FindBy(css = "#mini-cart  li  div  div")
    private WebElement lbAddedItemInfo;
    @FindBy(id = "top-cart-btn-checkout")
    private WebElement btnCheckOut;
    @FindBy(css = "a[id='ui-id-6'] span:nth-child(2)")
    private WebElement btnGearMenu;
    @FindBy(xpath = "//div[@class='product-item-details']/strong/a")
    private WebElement lbNameItemsInCar;
    @FindBy(xpath = "//div[@class='product-item-pricing']//span[@class='price']")
    private WebElement lbPriceItemsInCar;
    @FindBy(xpath = "//a[@class='action showcart']")
    
    private WebElement btnShopCar;
    
 

    public ShoppingCarPage(TestContext context) {
        super(context.driver);
    }

    public String getAddedItemInfo() {
    	
    	return lbAddedItemInfo.getText() + lbPriceItemsInCar.getText();
    }
    public void goToCheckOut() {
    	btnCheckOut.click();
    }
    public void goToGear() {
    	btnGearMenu.click();
    }
   
}
