package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CartPage extends BasePage {

    @FindBy(css = "td.product-price.hidden-xs")
    @Name("Product price")
    private HtmlElement productPrice;

    @FindBy(name = "fullname")
    @Name("Full name field")
    private TextInput fullNameField;

    @FindBy(name = "phone")
    @Name("Phone field")
    private TextInput phoneField;

    @FindBy(name = "address")
    @Name("Address field")
    private TextInput addressField;

    @FindBy(xpath = "//button[@type='submit']")
    @Name("Make an order button")
    private Button makeOrderButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public HtmlElement getProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice;
    }

    public void makeOder(String fullName, String phone, String address) {
        fullNameField.sendKeys(fullName);
        phoneField.sendKeys(phone);
        addressField.sendKeys(address);
        makeOrderButton.click();
    }

}

