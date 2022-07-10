package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

@Log4j
public class sauceDemoTests {

    ChromeDriver driver;
    private final String URL = "https://www.saucedemo.com/";
    @BeforeTest
    public void setProperties(){
        //System.setProperties(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }
    @BeforeMethod(alwaysRun = true)
    public void openBrowser()  {
        log.info("Initializing ChromeDriver");
        driver = new ChromeDriver();

    }
    @Test
    public void testScenario1(){
        //Navigēt uz saiti https://www.saucedemo.com/
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        //Ielogoties ar pareizu lietotāja vārdu/paroli
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        //Pārbaudīt, ka lietotājs ir ielogojies
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        //Ievietot Grozā 1 produktu
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartBackpackButton();
        //Doties uz grozu
        inventoryPage.clickShoppingCartLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        //Pārbaudīt, ka šī prece ir grozā
        CartPage cartPage =new CartPage(driver);
        cartPage.findBackpackLink();
        //Doties uz Checkout
        cartPage.clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        //Ievadīt vārdu/uzvārdu/pasta indeksu
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstNameField("Janis");
        checkoutPage.setLastNameField("Mutulis");
        checkoutPage.setPostalCodeField("LV-1234");
        //Doties uz Checkout overview lapu, pārbaudīt datus
        checkoutPage.clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.findBackpackLink();
        //Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
        checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertTrue(driver.getPageSource().contains("THANK YOU FOR YOUR ORDER"));
        //Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'
        checkoutSuccessPage.clickBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testScenario2() {
        //Navigēt uz saiti https://www.saucedemo.com/
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        //Ielogoties ar pareizu lietotāja vārdu/paroli
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        //Pārbaudīt, ka lietotājs ir ielogojies
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        //Ievietot Grozā 1 produktu
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartBackpackButton();
        //Doties uz grozu
        inventoryPage.clickShoppingCartLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        CartPage cartPage = new CartPage(driver);
        //Doties uz Checkout
        cartPage.clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        //Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
        //Pārbaudīt, ka forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(driver.getPageSource().contains("Error: First Name is required"));
        checkoutPage.setFirstNameField("Janis");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(driver.getPageSource().contains("Error: Last Name is required"));
        checkoutPage.setLastNameField("Mutulis");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(driver.getPageSource().contains("Error: Postal Code is required"));
        checkoutPage.setPostalCodeField("LV-1234");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        log.info("Closing ChromeDriver");
        driver.close();

    }
}
