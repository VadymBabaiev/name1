package tests.cartTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

import static constants.Constants.*;

public class PizzaLifeCartTests {

    WebDriver chromeDriver;
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        homePage = new HomePage(chromeDriver);
        homePage.openPage();
    }

    @Test
    public void addToCartTest() {
        searchPage = homePage.chooseDessertsCategory();
        productPage = searchPage.chooseStrawberryIceCream();
        String productPrice = productPage.getProductPrice().getText();
        productPage.addToCart();
        cartPage = homePage.goToCart();
        String productPriceOnCartPage = cartPage.getProductPrice().getText();
        Assertions.assertThat(productPrice.equals(productPriceOnCartPage))
                .as("Prices on product page and on cart page are different")
                .isTrue();
    }

    @Test
    public void makeOrderWithoutFillingNameField() {
        searchPage = homePage.choosePizzaCategory();
        productPage = searchPage.chooseVegetarianPizza();
        productPage.addToCart();
        cartPage = homePage.goToCart();
        cartPage.makeOder(EMPTY_STRING, MOBILE_PHONE, ADDRESS);
        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CART_PAGE_URL))
                .isTrue();
    }

    @Test
    public void makeOrderWithoutFillingPhoneField() {
        searchPage = homePage.choosePizzaCategory();
        productPage = searchPage.chooseVegetarianPizza();
        productPage.addToCart();
        cartPage = homePage.goToCart();
        cartPage.makeOder(FULL_NAME, EMPTY_STRING, ADDRESS);
        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CART_PAGE_URL))
                .isTrue();
    }

    @Test
    public void makeOrderWithoutFillingAddressField() {
        searchPage = homePage.choosePizzaCategory();
        productPage = searchPage.chooseVegetarianPizza();
        productPage.addToCart();
        cartPage = homePage.goToCart();
        cartPage.makeOder(FULL_NAME, MOBILE_PHONE, EMPTY_STRING);
        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CART_PAGE_URL))
                .isTrue();
    }

    @Test
    public void makeOrderLeavingAllMandatoryFieldsEmpty() {
        searchPage = homePage.choosePizzaCategory();
        productPage = searchPage.chooseVegetarianPizza();
        productPage.addToCart();
        cartPage = homePage.goToCart();
        cartPage.makeOder(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING);
        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CART_PAGE_URL))
                .isTrue();
    }

    @AfterMethod
    public void tearDown() {
        chromeDriver.quit();
    }
}
