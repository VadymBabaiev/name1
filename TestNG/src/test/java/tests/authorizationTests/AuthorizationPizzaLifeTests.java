package tests.authorizationTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static constants.Constants.*;

public class AuthorizationPizzaLifeTests {

    WebDriver chromeDriver;
    HomePage homePage;
    AuthorizationChoicePage authorizationChoicePage;
    LogInPage authorizationPage;
    UserProfilePage userProfilePage;
    LogOutPage logOutPage;
    RegistrationPage registrationPage;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        homePage = new HomePage(chromeDriver);
        homePage.openPage();
        authorizationChoicePage = homePage.chooseAuthorization();
    }

    @Test
    public void logInWithValidCredentialsTest() {
        authorizationPage = authorizationChoicePage.clickOnLogInButton();
        userProfilePage = authorizationPage.logIn(VALID_USERNAME, VALID_PASSWORD);

        Assertions.assertThat(userProfilePage.getOrderHistoryLink().isDisplayed())
                .as("Order history isn't found")
                .isTrue();
    }

    @Test
    public void logInWithInvalidUsernameTest() {
        authorizationPage = authorizationChoicePage.clickOnLogInButton();
        authorizationPage.logIn(INVALID_USERNAME, VALID_PASSWORD);

        Assertions.assertThat(authorizationPage.getErrorMessage().isDisplayed())
                .isTrue();
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        authorizationPage = authorizationChoicePage.clickOnLogInButton();
        authorizationPage.logIn(VALID_USERNAME, INVALID_PASSWORD);

        Assertions.assertThat(authorizationPage.getErrorMessage().isDisplayed())
                .isTrue();
    }

    @Test
    public void logInWithInvalidCredentialsTest() {
        authorizationPage = authorizationChoicePage.clickOnLogInButton();
        authorizationPage.logIn(INVALID_USERNAME, INVALID_PASSWORD);

        Assertions.assertThat(authorizationPage.getErrorMessage().isDisplayed())
                .isTrue();
    }

    @Test
    public void logOutTest() {
        authorizationPage = authorizationChoicePage.clickOnLogInButton();
        userProfilePage = authorizationPage.logIn(VALID_USERNAME, VALID_PASSWORD);
        authorizationChoicePage = homePage.chooseAuthorization();
        logOutPage = authorizationChoicePage.clickOnLogOutButton();

        Assertions.assertThat(logOutPage.getLogOutMessage().isDisplayed())
                .as("Log out message isn't displayed")
                .isTrue();
    }

    @Test
    public void RegistrationButtonIsClickableTest() {
        registrationPage = authorizationChoicePage.clickOnRegistrationButton();

        Assertions.assertThat(registrationPage.getRegistrationButton().isEnabled())
                .as("Registration button is disabled")
                .isTrue();
    }

    @Test
    public void signUpWithoutFillingFullNameField() {
        registrationPage = authorizationChoicePage.clickOnRegistrationButton();
        registrationPage.confirmRegistration(EMPTY_STRING, EMAIL, USER_NAME, PASSWORD);

        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CONFIRM_REGISTRATION_PAGE_URL))
                .isFalse();
    }

    @Test
    public void signUpWithoutFillingEmailField() {
        registrationPage = authorizationChoicePage.clickOnRegistrationButton();
        registrationPage.confirmRegistration(FULL_NAME, EMPTY_STRING, USER_NAME, PASSWORD);

        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CONFIRM_REGISTRATION_PAGE_URL))
                .isFalse();
    }

    @Test
    public void signUpWithoutFillingUserNameField() {
        registrationPage = authorizationChoicePage.clickOnRegistrationButton();
        registrationPage.confirmRegistration(FULL_NAME, EMAIL, EMPTY_STRING, PASSWORD);

        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CONFIRM_REGISTRATION_PAGE_URL))
                .isFalse();
    }

    @Test
    public void signUpWithoutFillingPasswordField() {
        registrationPage = authorizationChoicePage.clickOnRegistrationButton();
        registrationPage.confirmRegistration(FULL_NAME, EMAIL, USER_NAME, EMPTY_STRING);

        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CONFIRM_REGISTRATION_PAGE_URL))
                .isFalse();
    }

    @Test
    public void signUpLeavingAllMandatoryFieldsEmpty() {
        registrationPage = authorizationChoicePage.clickOnRegistrationButton();
        registrationPage.confirmRegistration(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING);

        Assertions.assertThat(chromeDriver.getCurrentUrl().equals(CONFIRM_REGISTRATION_PAGE_URL))
                .isFalse();
    }

    @AfterMethod
    public void tearDown() {
        chromeDriver.quit();
    }
}
