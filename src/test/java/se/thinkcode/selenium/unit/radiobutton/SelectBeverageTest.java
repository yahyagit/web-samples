package se.thinkcode.selenium.unit.radiobutton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.IndexPage;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectBeverageTest {
    private WebDriver browser;
    private SelectBeveragePage selectBeveragePage;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
        IndexPage indexPage = new IndexPage(browser);
        selectBeveragePage = indexPage.selectBeverage();
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.close();
    }

    @Test
    public void find_beverages_to_choose_from() {
        List<String> expected = new LinkedList<>();
        expected.add("coffee");
        expected.add("tea");

        List<String> actual = selectBeveragePage.getAvailableBeverages();

        assertThat(actual, is(expected));
    }

    @Test
    public void select_coffee() {
        String initialSelection = selectBeveragePage.getSelectedBeverage();
        assertThat(initialSelection, is(""));

        selectBeveragePage.selectCoffee();

        String selectedBeverage = selectBeveragePage.getSelectedBeverage();
        assertThat(selectedBeverage, is("coffee"));
    }

    @Test
    public void select_tea() {
        String initialSelection = selectBeveragePage.getSelectedBeverage();
        assertThat(initialSelection, is(""));

        selectBeveragePage.selectTea();

        String selectedBeverage = selectBeveragePage.getSelectedBeverage();
        assertThat(selectedBeverage, is("tea"));
    }
}
