package mavenTestNGHomework;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Log4j
public class WebpageTest {
    ChromeDriver driver;

    private final String XPATH_URL = "https://devhints.io/xpath";
    private final String WEBDRIVER_URL = "https://www.selenium.dev/documentation/webdriver/";
    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("orc.openqa.selenium").setLevel(Level.OFF);
    }
    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        log.info("Started ChromeDriver");
    }


    @Test
    public void webpageTitleTest1() {
        driver.get(XPATH_URL);
        Assert.assertEquals(driver.getTitle(), "Xpath cheatsheet");
        Assert.assertEquals(driver.getCurrentUrl(), XPATH_URL);
    }
    @Test
    public void webpageTitleTest2() {
        driver.get(WEBDRIVER_URL);
        Assert.assertEquals(driver.getTitle(), "WebDriver | Selenium");
        Assert.assertEquals(driver.getCurrentUrl(), WEBDRIVER_URL);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}

