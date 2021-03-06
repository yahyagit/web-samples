package se.thinkcode.selenium.bdd.steps.buy.currency;

import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.actions.buy.currency.Action;
import se.thinkcode.selenium.unit.IndexPage;

import java.util.Currency;

public class BuyCurrencyHelper {
    private final Action action;
    private final int amount;
    private final Currency to;
    private final Currency from;

    private WebDriver browser;
    private ResultPage resultPage;

    public BuyCurrencyHelper(Action action, int amount, Currency to, Currency from) {
        this.action = action;
        this.amount = amount;
        this.to = to;
        this.from = from;

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    public void convert() {
        IndexPage indexPage = new IndexPage(browser);
        BuyCurrencyPage conversionPage = indexPage.buyCurrency();

        conversionPage.selectAction(action);
        conversionPage.selectWantedCurrency(to);
        conversionPage.setWantedAmount(amount);
        conversionPage.selectCurrencyToPayWith(from);
        resultPage = conversionPage.submitForm();
    }

    public int getCost() {
        return resultPage.getCost();
    }

    public Currency getFromCurrency() {
        return resultPage.getFromCurrency();
    }
}