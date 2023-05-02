package magento.utils;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;
import magento.pages.CheckOutPage;
import magento.pages.HomePage;
import magento.pages.MenuPage;
import magento.pages.ProductCatalogPage;
import magento.pages.ItemInfoPage;
import magento.pages.ShoppingCarPage;

public class PicoDependencyInjector implements ObjectFactory {

    private PicoFactory delegate = new PicoFactory();

    public PicoDependencyInjector() {
        addClass(HomePage.class);
        addClass(ProductCatalogPage.class);
        addClass(MenuPage.class);
        addClass(ItemInfoPage.class);
        addClass(ShoppingCarPage.class);
        addClass(CheckOutPage.class);
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}