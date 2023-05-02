package magento.pages;

import magento.TestContext;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {

    
    @FindBy(xpath = "//strong[@class='title']//span[contains(text(),'Tops')]")
    private WebElement lbTopsMenu;
    @FindBy(xpath = "//a[contains(text(),'Jackets')]")
    private WebElement btnJacketMenu;
    

    public MenuPage(TestContext context) {
        super(context.driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getTopsMenuText() {
        return lbTopsMenu.getText();
    }
    public void goJacketMenu() {
    	btnJacketMenu.click();
    }
    
    public void selectCategory(String category,  String iteam) {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + category +"')]"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Category']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ol/li/a[contains(text(),'" + iteam +"')]"))).click();
    }
}
