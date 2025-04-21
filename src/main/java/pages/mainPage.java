package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class mainPage extends basePage {

    /** Приклад ініціалізації веб-сторінки */
    public mainPage() {
        wait(5);
    }
    public WebElement getMenuItems(String menuName){
        return driver.findElement(By.xpath("//ul[@id = 'main-menu'][contains(., '" + menuName + "')]"));
    }

    public WebElement getTextOnPage(String text){
        return driver.findElement(By.xpath("//div[@class = 'container'][contains(., '" + text + "')]"));
    }

    public WebElement getCardByName(String nameOfCard) {
        return driver.findElement(By.xpath("//div[@class = 'news-col'][contains(., '" + nameOfCard + "')]"));
    }

    public WebElement getLinkInPartnerBlock(String link){
        return driver.findElement(By.xpath("//div[@class = 'row']//a[@href = '" + link + "']"));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
