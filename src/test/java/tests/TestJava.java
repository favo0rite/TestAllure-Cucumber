package tests;

import appline.managers.InitManager;
import appline.managers.ManagerPages;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestJava {
    protected ManagerPages app = ManagerPages.getManagerPages();

    @Before
    public void setUp() {

        InitManager.initFramework();
    }

    @Ignore
    @Test
    public void testIphone(){
        app.getStartPage()
                .searchInput("iphone")
                .clickSearchButton()
                .fillInput("Максимальная цена",100000)
                .selectCheckBox("Высокий рейтинг")
                .selectCheckboxWirelessTechnology("NFC")
                .addToBasket(8)
                .clickBasketButton()
                .assertProducts()
                .deleteAllProductsFromBasket()
                .assertThatBasketIsEmpty("Корзина пуста");
    }

    /*@Test
    public void testWirelessHeadphone() {
        app.getStartPage()
                .searchInput("беспроводные наушники")
                .clickSearchButton()
                .fillInput("Максимальная цена",10000)
                .selectCheckboxBrand("Бренды","Beats")
                .selectCheckboxBrand("Бренды","Xiaomi")
                .selectCheckboxBrand("Бренды","Samsung")
                .selectCheckBox("Высокий рейтинг")
                .addToBasket("четные")
                .clickBasketButton()
                .assertProducts()
                .deleteAllProductsFromBasket()
                .assertThatBasketIsEmpty("Корзина пуста");
    }*/


    @After
    public void tearDown() {
        InitManager.quitFramework();
    }
}
