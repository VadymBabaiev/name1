package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[@type='submit']")
    @Name("Add to cart")
    private Button addToCartButton;

    @FindBy(id = "product-price")
    @Name("Product price")
    HtmlElement productPrice;

    @FindBy(className = "h-cb c-product__quantity-value qty")
    @Name("Product amount field")
    TextInput productAmountField;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public HtmlElement getProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice;
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

}
