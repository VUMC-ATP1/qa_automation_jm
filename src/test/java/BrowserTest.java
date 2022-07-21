import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Log4j
public class BrowserTest {
    ChromeDriver driver;

    private final String GOOGLE_URL = "https://www.google.lv/";
    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/index.html").getPath();
    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("orc.openqa.selenium").setLevel(Level.OFF);
    }
    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(GOOGLE_URL);
    }


    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);
    }

    @Test
    public void elementTest() {
        driver.get(LOCAL_FILE);
        driver.findElement(By.linkText("LinkedIn")).click();

    }
    @Test
    public void TestBrowserTab(){

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}

