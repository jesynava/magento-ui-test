package magento.pages;

import magento.TestContext;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[normalize-space()='Women']")
    private WebElement btnWomenMenu;
    @FindBy(xpath = "//span[normalize-space()='Men']")
    private WebElement btnManMenu;
    @FindBy(xpath = "//span[normalize-space()='Gear']")
    private WebElement btnGearMenu;
    @FindBy(xpath = "//span[normalize-space()='Sale']")
    private WebElement btnSale;
    @FindBy(xpath = "//span[normalize-space()='Training']")
    private WebElement btnTraining;
    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement btnShopCar;
    
 

    public HomePage(TestContext context) {
        super(context.driver);
    }

    public void goToWoman() {
    	btnWomenMenu.click();
    }
    public void goToMan() {
    	btnManMenu.click();
    }
    public void goToGear() {
    	btnGearMenu.click();
    }
    public void goToSale() {
    	btnSale.click();
    }
    public void goToTraining() {
    	btnSale.click();
    }
    public void goToShopCar() {
    	btnShopCar.click();
    }
    public void selectDepartment(String department) {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='" + department +"']"))).click();
    	Assertions.assertThat(driver.getTitle()).isEqualTo(department);
    	
    }
}
