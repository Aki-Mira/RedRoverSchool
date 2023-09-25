import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AbbreviateTest {

    @Test
    public void testAbbreviateTo10Characters() {
        String input = "Привет всем кто живет на луне!";
        String expected = "Привет ...";

        String result = StringUtils.abbreviate(input, 10);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void testAbbreviateTo20Characters() {
        String input = "Привет всем кто живет на луне!";
        String expected = "Привет всем кто ж...";

        String result = StringUtils.abbreviate(input, 20);

        Assert.assertEquals(result, expected);
    }
}
