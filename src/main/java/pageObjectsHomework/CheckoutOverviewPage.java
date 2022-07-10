package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public void findBackpackLink(){driver.findElement(By.linkText("Sauce Labs Backpack"));}
    private final By finishButton = By.id("finish");
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

}
