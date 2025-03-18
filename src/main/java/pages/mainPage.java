package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage extends basePage {
    public mainPage() {
        driver.get("https://musical-douhua-c546d9.netlify.app");
    }

    public By nameOfYourWebElement = By.id("your id");

    public WebElement getYourWebElement() {
        return driver.findElement(nameOfYourWebElement);
    }

    public WebElement getWebElementWithXPath(String addedValue) {
        String xpath = String.format("//yourXpath and your "+ addedValue +"");
        return driver.findElement(By.xpath(xpath));
    }

}
