import org.testng.annotations.BeforeClass;
import pages.mainPage;

public class baseTest {
    public static mainPage mainPage;

    @BeforeClass
    public static void setUp() {
        mainPage = new mainPage();
    }
}
