package appline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.fail;

public class StartPage extends BasePage {
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='ui-k8 ui-l5 ui-m8 ui-n3']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-widget='cart']")
    private WebElement basketButton;


    public StartPage searchInput(String value) {
        fillInputField(searchInput, value);
        return this;
    }

    public StartPage fillInput(String nameInput, String value) {
        switch (nameInput) {
            case "Поиск":
                fillInputField(searchInput, value);

        }
        return this;
    }


    public ResultsSearchPage clickSearchButton() {
        elementToBeClickable(searchButton).click();
        return app.getResultsSearchPage();
    }

    public BasketPage clickBasketButton() {
        scrollToElementJs(basketButton);
        elementToBeClickable(basketButton).click();
        return app.getBasketPage();
    }

}
