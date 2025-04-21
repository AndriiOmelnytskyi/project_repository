package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class basePage {

    protected static WebDriver driver;

    /** Ініціалізація Chrome Web driver */
    public basePage() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://ad.nure.ua");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    /** Метод для задавання пауз та очікувань в проекті */
    public void wait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
