package appline.pages;

import appline.managers.ManagerPages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appline.managers.DriverManager.getDriver;

public class BasePage {
    protected ManagerPages app = ManagerPages.getManagerPages();


    protected Actions action = new Actions(getDriver());


    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 2000);


    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    protected WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void fillInputField(WebElement field, String value) {
        elementToBeClickable(field);
        clickElementAction(field);
        field.sendKeys(value);
    }

    protected void keyEnter(WebElement element) {
        elementToBeClickable(element).sendKeys(Keys.ENTER);
    }

    protected void elementTextToBePresent(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
    }

    protected void clickElementJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    protected void moveToElement(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    protected void waitPresenceLocated(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitVisibilityElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitPresentFilter(String value) {
        waitPresenceLocated(By
                .xpath("//div[@data-widget='searchResultsSort']/div[not(@class)]//*[contains(text(), '" + value + "')]"));
    }

    public static ExpectedCondition<Boolean> attributeValueToBePresentInElement(final WebElement element,
                                                                                final String text) {

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return element.getAttribute("value").contains(text);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in element %s", text, element);
            }
        };
    }


    protected void clickElementAction(WebElement element) {
        action.click(element).build().perform();
    }


}
