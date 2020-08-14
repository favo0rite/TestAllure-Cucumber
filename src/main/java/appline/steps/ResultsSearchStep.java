package appline.steps;

import appline.managers.ManagerPages;
import io.cucumber.java.bg.И;
import io.cucumber.java.en.When;

import static appline.managers.ManagerPages.getManagerPages;

public class ResultsSearchStep {


    @И("^Добавляем в корзину (\\d*) четных товаров$")
    public void addToBasket(int count) {
        getManagerPages().getResultsSearchPage().addToBasket(count);
    }

    @И("^Нажимаем на чекбокс \"([^\"]*)\"$")
    public void selectCheckbox(String value) {
        getManagerPages().getResultsSearchPage().selectCheckBox(value);
    }

    @И("^Нажимаем на чекбокс \"[^\"]*\" в блоке беспроводных технологий$")
    public void selectCheckboxWirelessTechnology(String value) {
        getManagerPages().getResultsSearchPage().selectCheckboxWirelessTechnology(value);
    }

    @И("^Выбираем бренд \"[^\"]*\"$")
    public void selectCheckboxBrand(String nameBrand) {
        getManagerPages().getResultsSearchPage().selectCheckboxBrand(nameBrand);
    }

    @И("^Нажимаем на кнопку 'Развенуть' в блоке \"[^\"]*\"$")
    public void clickViewAllButton(String nameBlock) {
        getManagerPages().getResultsSearchPage().clickViewAllButton(nameBlock);
    }







}
