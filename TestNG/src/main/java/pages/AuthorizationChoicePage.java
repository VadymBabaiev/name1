package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class AuthorizationChoicePage extends BasePage {

    @FindBy(xpath = "//a[@href='vxod/']")
    @Name("Log in button")
    private Button logInButton;

    @FindBy(xpath = "//a[@href='vxod/?service=logout']")
    @Name("Log out button")
    private Button logOutButton;

    @FindBy(xpath = "//a[@href='registracziya/']")
    @Name("Registration button")
    private Button registrationButton;

    public AuthorizationChoicePage(WebDriver driver) {
        super(driver);
    }

    public LogInPage clickOnLogInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return new LogInPage(driver);
    }

    public LogOutPage clickOnLogOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
        return new LogOutPage(driver);
    }

    public RegistrationPage clickOnRegistrationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButton.click();
        return new RegistrationPage(driver);
    }

}
