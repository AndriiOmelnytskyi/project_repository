package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage extends basePage {

    /** Приклад ініціалізації веб-сторінки */
    public mainPage() {
        wait(5);
    }

    public WebElement getTextOnPage(String text){
        return driver.findElement(By.xpath("//div[@class = 'container'][contains(., '" + text + "')]"));
    }

    public WebElement getCardByName(String nameOfCard) {
        return driver.findElement(By.xpath("//div[@class = 'facts-item'][contains(.,'" + nameOfCard + "')]"));
    }

    public WebElement getLinksInFooter(String nameOfTitle){
        return driver.findElement(By.xpath("//div[@class = 'col-sm-5 col-lg-4']//a[contains(., '" + nameOfTitle + "')]"));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
