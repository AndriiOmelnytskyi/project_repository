import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mainPage;

public class baseTest {
    public static mainPage mainPage;

    @BeforeClass
    public static void setUp() {
        mainPage = new mainPage();
    }
}
