package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class SearchPage extends BasePage {

    @FindBy(css = "div.c-product-grid__title a[href='desertyi/morozhennoe/morozhenoe-klubnichnoe/']")
    @Name("Strawberry ice-cream")
    private Link strawberryIceCreamLink;


    @FindBy(css = "div.c-product-grid__title a[href='pizza/ovoshhnyie/vegetarianskaya/']")
    @Name("Vegetarian pizza")
    private Link vegetarianPizzaLink;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage chooseStrawberryIceCream() {
        wait.until(ExpectedConditions.elementToBeClickable(strawberryIceCreamLink));
        strawberryIceCreamLink.click();
        return new ProductPage(driver);
    }

    public ProductPage chooseVegetarianPizza() {
        wait.until(ExpectedConditions.elementToBeClickable(vegetarianPizzaLink));
        vegetarianPizzaLink.click();
        return new ProductPage(driver);
    }

}

