package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LogInPage extends BasePage {

    @FindBy(className = "loginUsername")
    @Name("Username field")
    private TextInput userNameField;

    @FindBy(className = "loginPassword")
    @Name("Password field")
    private TextInput passwordField;

    @FindBy(name = "Login")
    @Name("Submit button")
    private Button submitButton;

    @FindBy(xpath = "//p[@class='error']")
    @Name("Authorization error message")
    private HtmlElement errorMessage;

    LogInPage(WebDriver driver) {
        super(driver);
    }

    public UserProfilePage logIn(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfAllElements(userNameField, passwordField, submitButton));
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return new UserProfilePage(driver);
    }

    public HtmlElement getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage;
    }

}

