package tests.contactsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class PizzaLifeContactsTest {

    WebDriver chromeDriver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        homePage = new HomePage(chromeDriver);
        homePage.openPage();
    }


    @Test
    public void checkFunctionalityOfPhonesDropdownButton() {

        Assertions.assertThat(homePage.extractPhoneNumbers().isDisplayed())
                .isTrue();
    }


    @AfterMethod
    public void tearDown() {
        chromeDriver.quit();
    }

}
