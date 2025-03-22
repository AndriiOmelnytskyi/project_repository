package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage extends basePage {

    /** Приклад ініціалізації веб-сторінки */
    public mainPage() {
        wait(5);
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
