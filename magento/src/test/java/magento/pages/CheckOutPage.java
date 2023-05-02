package magento.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import magento.TestContext;

public class CheckOutPage extends BasePage {

	@FindBy(xpath = "//div[normalize-space()='Shipping Address']")
	private WebElement lbShoppingAddress;
	@FindBy(id = "customer-email")
	private WebElement inputEmail;
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement inputFirstName;
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement inputLastName;
	@FindBy(xpath = "//input[@name='city']")
	private WebElement inputCity;
	@FindBy(xpath = "//div[@name='shippingAddress.street.0']/div/input")
	private WebElement inputStreet;
	@FindBy(xpath = "//input[@name='postcode']")
	private WebElement inputPostcode;
	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement inputTelephone;
	@FindBy(css = "#checkout-shipping-method-load > table > tbody > tr:nth-child(2) > td:nth-child(1) > input")
	private WebElement shippingMethod;
	@FindBy(css = "#shipping-method-buttons-container > div > button")
	private WebElement btnNext;
	@FindBy(xpath = "//div[class='payment-group']/div[class='step-title']")
	private WebElement lbPayment;
	@FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")
	private WebElement btnPlaceOrder;

	public CheckOutPage(TestContext context) {
		super(context.driver);
	}

	public void getDrpRegion() {
		Select drpRegion = new Select(driver.findElement(By.xpath("//select[@name='region_id']")));
		drpRegion.selectByVisibleText("Arizona");
	}

	public void getDrpCountry() {
		Select drpRCountry = new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
		drpRCountry.selectByVisibleText("United States");
	}

	public void sendEmail(String email) {
		wait.until(ExpectedConditions.invisibilityOf(inputEmail));
		inputEmail.sendKeys(email);
	}

	public void sendFirsName(String name) {
		inputFirstName.sendKeys(name);
	}

	public void sendLastName(String lastName){
		inputLastName.sendKeys(lastName);
	}

	public void sendStreet(String street) {
		inputStreet.sendKeys(street);
	}

	public void sendCity(String city) {
		inputCity.sendKeys(city);
	}

	public void sendPostcde(String code) {
		inputPostcode.sendKeys(code);
	}

	public void sendTelephone(String number) {
		inputTelephone.sendKeys(number);
	}

	public void selectShippingMethod() {
		shippingMethod.click();
	}

	public void fillShippingForm(String email, String name, String lastName, String street, String city, String code, String number) {

		// presenceOfElementLocated condition
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Shipping Address']")));
		sendEmail(email);
		sendFirsName(name);
		sendLastName(lastName);
		sendStreet(street);
		sendCity(city);
		getDrpRegion();
		sendPostcde(code);
		getDrpCountry();
		sendTelephone(number);
		selectShippingMethod();
		btnNext.click();
	}

	public void paymentMethod() {
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("div[class='payment-group'] div[class='step-title']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")));
		wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder)).click();
		wait.until(ExpectedConditions.textToBe((By.cssSelector(".base")), "Thank you for your purchase!"));
	}

}
