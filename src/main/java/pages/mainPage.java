package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage extends basePage {
    public mainPage() {
        driver.get("https://musical-douhua-c546d9.netlify.app");
    }

    /** Приклад ініціалізації веб-елементу */
    public WebElement getYourWebElement() {
        return driver.findElement(By.id("your id"));
    }

    /** Приклад ініціалізації веб-елементу, використовуючи змінну в xpath */
    public WebElement getWebElementWithXPath(String addedValue) {
        String xpath = String.format("//yourXpath and your "+ addedValue +"");
        return driver.findElement(By.xpath(xpath));
    }

}
