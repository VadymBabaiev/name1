package fragments.buttonsBlock;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@class='c-header__buttons-block']")
public class ButtonsBlock extends HtmlElement {

    @FindBy(css = "div.c-header__buttons-block a.c-header__button-link--account")
    @Name("My profile button")
    private Button myProfileButton;

    @FindBy(xpath = "//div[@class='c-header__buttons-block']/div/div/a[@href='korzina/']")
    @Name("Cart button")
    private Button cartButton;


    public void clickOnMyProfileButton() {
        myProfileButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }
}