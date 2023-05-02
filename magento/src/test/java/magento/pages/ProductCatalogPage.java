package magento.pages;

import magento.TestContext;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCatalogPage extends BasePage {
	Random rand = new Random();

	@FindBy(xpath = "//main[@id='maincontent']//ol[@class='products list items product-items']")
	private WebElement teams;
	
	private List<WebElement> catalogItems;

	public ProductCatalogPage(TestContext context) {
		super(context.driver);
	}

	

	public List<WebElement> getCatalogItems() {
		catalogItems = driver
				.findElements(By.xpath("//main[@id='maincontent']//ol[@class='products list items product-items']/li"));
		return catalogItems;
	}

	public String selectAnIteamFromCatalog(List<WebElement> catalogItems) {

		WebElement selectedItem = catalogItems.get(3);
		String info = selectedItem.getText();
		selectedItem.click();
		return info;
	}

}
