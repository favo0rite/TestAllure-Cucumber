package appline.steps;

import io.cucumber.java.bg.И;

import static appline.managers.ManagerPages.getManagerPages;

public class BasketStep {
    @И("^Проверяем добавленные товары в корзине$")
    public void assertProducts() {
        getManagerPages().getBasketPage().assertProducts();
    }

    @И("^Удаляем все товары из корзины$")
    public void deleteAllProductsFromBasket() {
        getManagerPages().getBasketPage().deleteAllProductsFromBasket();
    }

    @И("^Проверям, есть ли заголовок \"([^\"]*)\"$")
    public void assertThatBasketIsEmpty(String value) {
        getManagerPages().getBasketPage().assertThatBasketIsEmpty(value);
    }
}