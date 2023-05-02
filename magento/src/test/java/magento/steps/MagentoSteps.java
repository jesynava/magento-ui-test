package magento.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import magento.pages.CheckOutPage;
import magento.pages.HomePage;
import magento.pages.ProductCatalogPage;
import magento.pages.ShoppingCarPage;
import magento.pages.MenuPage;
import magento.pages.ItemInfoPage;

import org.picocontainer.annotations.Inject;

public class MagentoSteps {
	@Inject
	HomePage homePage;
	@Inject
	ProductCatalogPage loginPage;
	@Inject
	MenuPage menuPage;
	@Inject
	ProductCatalogPage productCatalogPage;
	@Inject
	ShoppingCarPage shoppingCarPage;
	@Inject
	ItemInfoPage itemInfoPage;
	@Inject
	CheckOutPage checkOutPage;

	@Given("I am on the women menu")
	public void i_am_on_the_women_menu() {
		homePage.goToWoman();
	}

	@When("Selecting an item from tops menu")
	public void selecting_an_item_from_tops_menu() {
		menuPage.goJacketMenu();
	}

	@When("^Select a random item from cataloge size (.+)$")
	public void select_a_random_item_from_cataloge_size(String size) {
		productCatalogPage.selectAnIteamFromCatalog(productCatalogPage.getCatalogItems());
		String info =itemInfoPage.selectItemOptions(size);
		homePage.goToShopCar();
		Assertions.assertThat(shoppingCarPage.getAddedItemInfo()).contains(info);
	
	}
	@When("Select a random item from cataloge size ")
	public void select_a_random_item_from_cataloge_size_(){
		productCatalogPage.selectAnIteamFromCatalog(productCatalogPage.getCatalogItems());
		String info = itemInfoPage.selectItemOptions();
		homePage.goToShopCar();
		Assertions.assertThat(shoppingCarPage.getAddedItemInfo()).contains(info);
		
	}

	@And("^Fill checkout and fill form with email as (.+) name as (.+) lastname as (.+) street as (.+) city as (.+)$")
	public void fill_checkout_and_fill_form_with_email_as_name_as_lastname_as_street_as_city_as_code_as_number_as(
			String email, String name, String lastName, String street, String city) {
		shoppingCarPage.goToCheckOut();
		checkOutPage.fillShippingForm(email, name, lastName, street, city, "01789", "8998989889");
		checkOutPage.paymentMethod();

	}

	@Then("I should be on woman page")
	public void i_should_be_on_woman_page() {
		Assertions.assertThat(menuPage.getPageTitle()).isEqualTo("Women");
	}

	

	@Given("^I am on the department (.+)$")
	public void i_am_on_the_department_(String department) {
		homePage.selectDepartment(department);

	}

	@When("^Selecting an item from (.+) menu iteam (.+)$")
	public void selecting_an_item_from_menu_iteam_(String category, String iteam) {
		menuPage.selectCategory(category,iteam);
	}

	

}