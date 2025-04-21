import org.testng.annotations.BeforeClass;
import pages.mainPage;
import pages.aboutPage;

public class baseTest {
    public static mainPage mainPage;

    public static aboutPage aboutPage;

    @BeforeClass
    public static void setUp() {
        mainPage = new mainPage();
        aboutPage = new aboutPage();
    }
}
