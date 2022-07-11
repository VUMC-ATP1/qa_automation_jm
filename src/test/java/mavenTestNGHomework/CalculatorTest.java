package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        
    }
    @Test
    public void testAddMethod() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10, 20), 30);
    }
    @Test
    public void testSubstractMethod() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(20, 10), 10);
    }
    @Test
    public void testMultiplyMethod() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(10, 20), 200);
    }
    @Test
    public void testDivideMethod() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(10, 2), 5);
    }
}
