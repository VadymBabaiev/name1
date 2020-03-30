package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class LogOutPage extends BasePage {

    @FindBy(xpath = "//div[@class='alert alert-warning']")
    @Name("Log out message")
    private HtmlElement logOutMessage;

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public HtmlElement getLogOutMessage() {
        wait.until(ExpectedConditions.visibilityOf(logOutMessage));
        return logOutMessage;
    }
}

