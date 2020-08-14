package appline.pages;

import appline.utilsdata.Basket;
import appline.utilsdata.Product;
import io.cucumber.java.mn.Харин;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static org.junit.Assert.fail;

public class ResultsSearchPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(), 'Цена')]/../div//input[@*='range-to']")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//div[@value]")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[contains(text(),'Беспроводные технологии')]")
    private WebElement blockWirelessTechnology;

    @FindBy(xpath = "//div[@gridtype='unused']/div/div[@style]")
    private List<WebElement> productList;


    @FindBy(xpath = "//div[@data-widget='searchResultsSort']")
    private WebElement filterBlock;

    @FindBy(xpath = "//div[contains(text(), '')]/..//span[contains(text(), 'Посмотреть все')]")
    private List<WebElement> viewAllButtons;

    @FindBy(xpath = "//div[contains(text(), 'Бренды')]/..//label")
    private List<WebElement> allBrands;


    public void addToAbstractBasket(WebElement element) {
        String name = element.findElement(By.xpath(".//a[text()]")).getText();
        int price = Integer.parseInt(element.findElement(By
                .xpath("./div/div/div/following-sibling::div/following-sibling::div/a//span")).getText().
                replaceAll(" ", "").replaceAll("₽", ""));

        Basket.addProductToBasket(new Product(name, price));
    }

    public ResultsSearchPage fillInput(String nameField, int maxPrice) {
        switch (nameField) {
            case "Максимальная цена":
                elementToBeClickable(maxPriceInput);
                maxPriceInput.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
                maxPriceInput.sendKeys(Integer.toString(maxPrice));
                maxPriceInput.sendKeys(Keys.ENTER);
                wait.until(attributeValueToBePresentInElement(maxPriceInput, Integer.toString(maxPrice)));
                //waitPresentFilter("Цена");
                return this;
//            default:
//                fail("Поля с названием " + nameField + " нет");
        }

        return this;
    }

    public ResultsSearchPage selectCheckBox(String nameCheckbox) {
        for (WebElement item : checkBoxes) {
            item = item.findElement(By.xpath("//div[@value='" + nameCheckbox + "']"));
            if (item.getAttribute("value").contains(nameCheckbox)) {
                elementToBeClickable(item).click();
                waitPresentFilter(nameCheckbox);
                return this;
            }

        }
        fail("Чекбокс с названием = " + nameCheckbox + "не найден");
        return this;
    }


    public ResultsSearchPage selectCheckboxWirelessTechnology(String nameCheckbox) {
        try {
            WebElement element = blockWirelessTechnology.findElement(By
                    .xpath("./..//*[contains(text(), '" + nameCheckbox + "')]/../..//*[@*='checkbox']/.."));
            elementToBeClickable(element).click();
            waitPresentFilter(nameCheckbox);
        } catch (NoSuchElementException e) {
            fail("Чекбокс с названием = " + nameCheckbox + "не найден");
        }

        return this;
    }

    public StartPage addToBasket(int count) {
        int i = (count % 2 == 0) ? 1 : 0;
        for (; i < count * 2; i += 2) {
            productList.get(i).findElement(By.xpath(".//div[text()='В корзину']/..")).click();
            addToAbstractBasket(productList.get(i));
        }

        return app.getStartPage();
    }

    public StartPage addToBasket(String value) {
        int i = 0;
        if (value.equals("четные")) i = 1;
        else if (value.equals("нечетные")) i = 0;
        else fail("Не правильное значение");

        for (; i < productList.size(); i += 2) {
            productList.get(i).findElement(By.xpath(".//div[text()='В корзину']/..")).click();
            addToAbstractBasket(productList.get(i));
        }

        return app.getStartPage();
    }

    public ResultsSearchPage clickViewAllButton(String blockName) {
        for (WebElement item : viewAllButtons) {
            item = item.findElement(By.xpath("//div[contains(text(), '" + blockName + "')]/..//span[contains(text(), 'Посмотреть все')]"));
            waitVisibilityElement(item);
            elementToBeClickable(item).click();
            return this;
        }
        fail("Чекбокс с названием = " + blockName + "не найден");
        return this;
    }

    public ResultsSearchPage selectCheckboxBrand(String brandName) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(), 'Бренды')]/..//label")));
        for (WebElement item : allBrands) {
            item = item.findElement(By.xpath("//span[text()='" + brandName + "']/../..//input/.."));
            scrollToElementJs(item);
            waitVisibilityElement(item);
            elementToBeClickable(item).click();
            waitPresentFilter(brandName);
            return this;
        }
        fail("Чекбокс с названием = " + brandName + "не найден");
        return this;

    }
}






