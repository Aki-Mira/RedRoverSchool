import org.example.Calculator;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 3);
        Assert.assertEquals(result, 8);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 4);
        Assert.assertEquals(result, 6);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(7, 6);
        Assert.assertEquals(result, 42);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(12, 4);
        Assert.assertEquals(result, 3.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }
}
