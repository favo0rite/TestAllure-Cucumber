package appline.managers;


import appline.pages.BasePage;
import appline.pages.BasketPage;
import appline.pages.ResultsSearchPage;
import appline.pages.StartPage;

public class ManagerPages {
    private static ManagerPages managerPages;
    StartPage startPage;
    ResultsSearchPage resultsSearchPage;
    BasketPage basketPage;
    BasePage basePage;



    private ManagerPages() {

    }

    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public BasePage getBasePage() {
        if (basePage == null) {
            basePage = new BasePage();
        }
        return basePage;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public ResultsSearchPage getResultsSearchPage() {
        if (resultsSearchPage == null) {
            resultsSearchPage = new ResultsSearchPage();
        }
        return resultsSearchPage;
    }

    public BasketPage getBasketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }



}
