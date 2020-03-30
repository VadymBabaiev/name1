package fragments.phoneBlock;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[contains(@class,'l-section__container c-header__container')]/div[@class='c-header__phone-block'] ")
public class PhoneBlock extends HtmlElement {

    @FindBy(className = "dropdown")
    @Name("Phones button")
    private Button phonesButton;

    public void clickOnPhonesButton() {
        phonesButton.click();
    }
}
