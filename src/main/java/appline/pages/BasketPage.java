package appline.pages;

import appline.utilsdata.Basket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static appline.utilsdata.Basket.getProductList;
import static appline.utilsdata.Basket.getProductToBasket;
import static org.junit.Assert.assertEquals;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[@data-widget='split']/div/following-sibling::div/following-sibling::div")
    private List<WebElement> productList = new ArrayList<>();

    @FindBy(xpath = "//div[@data-widget='split']/div//span[text() and @style]")
    private List<WebElement> productName = new ArrayList<>();

    @FindBy(xpath = "//div[@delete_button_name]//span")
    private WebElement deleteAllProductsButton;

    @FindBy(xpath = "//div[@class='modal-container']//div[text()='Удалить']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@data-widget='emptyCart']/h1")
    private WebElement emptyBasketHeader;

    public BasketPage assertProducts() {

        for(int i = 0, b = productList.size()-1; i < productList.size(); b--, i++) {
            assertEquals("Имя продукта не совпало", getProductToBasket(b).getName(),
                    productName.get(i).getText());
        }
        return this;
    }

    public BasketPage assertThatBasketIsEmpty(String value) {
        waitVisibilityElement(emptyBasketHeader);
        assertEquals("Надпись не совпадает", value.replaceAll(" ", ""), emptyBasketHeader.getText()
                .replaceAll(" ", ""));
        return this;

    }

    public BasketPage deleteAllProductsFromBasket() {
        elementToBeClickable(deleteAllProductsButton).click();
        waitVisibilityElement(deleteButton);
        elementToBeClickable(deleteButton).click();
        return this;
    }

    public void printProductsDescription() {
        for(int i = 0; i<getProductList().size(); i++){
            System.out.println("Имя продукта = " + getProductToBasket(i).getName());
            System.out.println("Цена продукта = " + getProductToBasket(i).getPrice());
        }
    }



}
