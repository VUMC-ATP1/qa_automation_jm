package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSuccessPage {
    private WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By backHomeButton = By.id("back-to-products");
    public void clickBackHomeButton(){driver.findElement(backHomeButton).click();}
}
