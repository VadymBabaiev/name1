package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//a[@href='istoriya-zakazov/']")
    @Name("Order history")
    private Link orderHistory;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public Link getOrderHistoryLink() {
        wait.until(ExpectedConditions.visibilityOf(orderHistory));
        return orderHistory;
    }

}
