import org.testng.annotations.Test;
import seleniumCore.CoreTest;

public class SampleTest extends CoreTest {

    @Test
    public void testGoogleSearch() {
        getDriver().get("https://www.google.com");
        System.out.println("Title: " + getDriver().getTitle());
    }


}
