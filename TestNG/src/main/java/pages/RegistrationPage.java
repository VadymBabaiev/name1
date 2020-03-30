package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class RegistrationPage extends BasePage {


    @FindBy(name = "fullname")
    @Name("Full name field")
    TextInput fullNameField;

    @FindBy(name = "email")
    @Name("Email field")
    TextInput emailField;

    @FindBy(name = "username")
    @Name("User name field")
    TextInput userNameField;

    @FindBy(name = "password")
    @Name("Password field")
    TextInput passwordField;

    @FindBy(name = "registerbtn")
    @Name("Registration button")
    Button registrationButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public Button getRegistrationButton() {
        wait.until(ExpectedConditions.visibilityOf(registrationButton));
        return registrationButton;
    }

    public void confirmRegistration(String fullName, String email,
                                    String userName, String password) {
        fullNameField.sendKeys(fullName);
        emailField.sendKeys(email);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        registrationButton.click();
    }

}

