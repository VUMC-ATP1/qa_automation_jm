package mavenTestNGHomework;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Log4j
public class CalculatorTest {
    Calculator calculator = new Calculator();
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        log.info("Test started");
    }
    @Test
    public void testAddMethod() {
        Assert.assertEquals(calculator.add(10, 20), 30);
        log.info("Add method tested");
    }
    @Test
    public void testSubstractMethod() {
        Assert.assertEquals(calculator.substract(20, 10), 10);
        log.info("Substract method tested");
    }
    @Test
    public void testMultiplyMethod() {
        Assert.assertEquals(calculator.multiply(10, 20), 200);
        log.info("Multiply method tested");
    }
    @Test
    public void testDivideMethod() {
        Assert.assertEquals(calculator.divide(10, 2), 5);
        log.info("Divide method tested");
    }
}
