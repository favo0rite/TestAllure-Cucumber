package appline.steps;

import appline.managers.ManagerPages;
import appline.pages.StartPage;
import gherkin.ast.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.bg.И;
import io.cucumber.java.en.When;

import static appline.managers.ManagerPages.getManagerPages;

public class StartStep {
    @И("^Нажимается кнопка Поиска$")
    public void clickButton() {
        getManagerPages().getStartPage().clickSearchButton();
    }

    @И("^Переходим в корзину$")
    public void goToBasket() {
        getManagerPages().getStartPage().clickBasketButton();
    }


}
