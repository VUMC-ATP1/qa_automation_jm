package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    public WebElement getUsernameField(){
        return driver.findElement(usernameField);
    }

    public void setUsernameField(String value) {
        getUsernameField().sendKeys(value);
    }
    public WebElement getPasswordField(){
        return driver.findElement(passwordField);
    }

    public void setPasswordField(String value) {
        getPasswordField().sendKeys(value);
    }
    public void clickLoginButton(){driver.findElement(loginButton).click();}

}
