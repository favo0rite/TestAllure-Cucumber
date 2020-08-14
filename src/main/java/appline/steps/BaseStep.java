package appline.steps;

import io.cucumber.java.bg.И;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static appline.managers.ManagerPages.getManagerPages;
import static org.junit.Assert.fail;

public class BaseStep {
    @When("^Вводится значение \"([^\"]*)\" в поле \"([^\"]*)\" на странице \"([^\"]*)\"$")
    public void fillInput(String value, String nameField, String pageName) {
        switch (pageName) {
            case "Стартовая страница":
                getManagerPages().getStartPage().fillInput(nameField, value);
                break;
            case "Результирующая страница":
                getManagerPages().getResultsSearchPage().fillInput(nameField, Integer.parseInt(value));
                break;
        }

    }


}
