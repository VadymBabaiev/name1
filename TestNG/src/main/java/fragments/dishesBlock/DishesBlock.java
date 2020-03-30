package fragments.dishesBlock;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@class='l-section__container c-header__container  c-header__container--center']")
public class DishesBlock extends HtmlElement {

    @FindBy(css = ".js-header-row [href='desertyi/']")
    @Name("Desserts category button")
    private Button dessertsCategoryButton;

    @FindBy(css = ".js-header-row [href='pizza/']")
    @Name("Pizza category button")
    private Button pizzaCategoryButton;

    public void clickOnDessertsCategoryButton() {
        dessertsCategoryButton.click();
    }

    public void clickOnPizzaCategoryButton() {
        pizzaCategoryButton.click();
    }
}
