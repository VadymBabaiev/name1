package pages;

import fragments.buttonsBlock.ButtonsBlock;
import fragments.dishesBlock.DishesBlock;
import fragments.phoneBlock.PhoneBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class HomePage extends BasePage {

    ButtonsBlock buttonsBlock;
    PhoneBlock phoneBlock;
    DishesBlock dishesBlock;

    @FindBy(xpath = "//div[@class='dropdown open']")
    @Name("Phones")
    private HtmlElement phones;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AuthorizationChoicePage chooseAuthorization() {
        buttonsBlock.clickOnMyProfileButton();
        return new AuthorizationChoicePage(driver);
    }

    public CartPage goToCart() {
        buttonsBlock.clickOnCartButton();
        return new CartPage(driver);
    }

    public HtmlElement extractPhoneNumbers() {
        phoneBlock.clickOnPhonesButton();
        wait.until(ExpectedConditions.visibilityOf(phones));
        return phones;

    }

    public SearchPage chooseDessertsCategory() {
        dishesBlock.clickOnDessertsCategoryButton();
        return new SearchPage(driver);
    }

    public SearchPage choosePizzaCategory() {
        dishesBlock.clickOnPizzaCategoryButton();
        return new SearchPage(driver);
    }

}

