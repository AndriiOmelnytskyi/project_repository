package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage extends basePage {

    /** Приклад ініціалізації драйверу та веб-сторінки */
    public mainPage() {
        driver.get("http://www.vdata.de/home/index.jsp");
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
