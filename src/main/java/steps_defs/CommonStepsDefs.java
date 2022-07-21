package steps_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectsHomework.*;
import page_object.AuthorizationPage;
import utils.WebDriverManager;

public class CommonStepsDefs {
    WebDriver driver = WebDriverManager.getInstance();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage =new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
    @Given("I have to navigate to login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("I login with {string} and {string}")
    public void autorize(String username, String password) {
        //System.out.println(username);
       // System.out.println(password);
        authorizationPage.authorization(username ,password);
    }
    @Then("I am successfully logged in")
    public void checkSuccessLogin() {
        Assertions.assertThat(driver.getCurrentUrl().compareToIgnoreCase("inventory.html"));
    }


    @Then("Then I see login error message 'Epic sadface: Username is required’")
    public void checkErrorMessage() {
        Assertions.assertThat(driver.getPageSource().contains("Epic sadface: Username is required"));

    }
    @When("I add one item to the cart")
    public void addBackpackToCart() {
        inventoryPage.clickAddToCartBackpackButton();
    }
    @Then("I see that item in the cart")
    public void itemIsInCart() {
        inventoryPage.clickShoppingCartLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        cartPage.findBackpackLink();
    }


    @When("I go to checkout")
    public void checkout() {
        cartPage.clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
    }

    @Then("I see {string} page")
    public void seePage(String url) {
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @When("I enter name {string}")
    public void enterName(String name) {
        checkoutPage.setFirstNameField(name);
    }

    @And("I enter surname {string}")
    public void enterSurname(String surname) {
        checkoutPage.setLastNameField(surname);
    }

    @And("I enter code {string}")
    public void enterCode(String code) {
        checkoutPage.setPostalCodeField(code);
    }
    @And("click Continue button")
    public void clickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @And("I see backpack in Checkout overview")
    public void findBackpackLink() {
        checkoutOverviewPage.findBackpackLink();
    }

    @Then("I click Finish button")
    public void clickFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }

    @When("I see {string} in page")
    public void seeInPage(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @And("I click Back Home button")
    public void clickBackHomeButton() {
        checkoutSuccessPage.clickBackHomeButton();
    }
}

