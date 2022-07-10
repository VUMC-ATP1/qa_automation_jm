package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findBackpackLink(){driver.findElement(By.linkText("Sauce Labs Backpack"));}
    private final By checkoutButton = By.id("checkout");
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
