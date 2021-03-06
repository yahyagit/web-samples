package se.thinkcode.selenium.unit.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfirmPasswordSentPage {
    private WebDriver browser;
    private String confirmationMessage;

    public ConfirmPasswordSentPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Confirm new password request";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));

        parseResult();
    }

    private void parseResult() {
        WebElement resultElement = browser.findElement(By.id("confirmation"));
        confirmationMessage = resultElement.getText();
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}
