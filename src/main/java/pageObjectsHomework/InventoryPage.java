package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By addToCartBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    public void clickAddToCartBackpackButton(){driver.findElement(addToCartBackpackButton).click();}
    private final By shoppingCartLink = By.className("shopping_cart_link");
    public void clickShoppingCartLink(){driver.findElement(shoppingCartLink).click();}
}
