package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    public WebElement getFirstNameField(){
        return driver.findElement(firstNameField);
    }

    public void setFirstNameField(String value) {
        getFirstNameField().sendKeys(value);
    }
    public WebElement getLastNameField(){
        return driver.findElement(lastNameField);
    }

    public void setLastNameField(String value) {
        getLastNameField().sendKeys(value);
    }
    public WebElement getPostalCodeField(){
        return driver.findElement(postalCodeField);
    }

    public void setPostalCodeField(String value) {
        getPostalCodeField().sendKeys(value);
    }
    public void clickContinueButton(){driver.findElement(continueButton).click();}
}
