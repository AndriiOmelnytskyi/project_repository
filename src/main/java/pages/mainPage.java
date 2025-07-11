package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage extends basePage {

    /** Приклад ініціалізації веб-сторінки */
    public mainPage() {
        wait(5);
    }
    public WebElement getMenuItems(String menuName){
        return driver.findElement(By.xpath("//ul[@id = 'main-menu'][contains(., '" + menuName + "')]"));
    }

    public WebElement getMenuItemById(String id){
        return driver.findElement(By.xpath("//ul[@id = 'main-menu']//li[@id = '" + id + "']"));
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

    public WebElement getEnButton(){
        return driver.findElement(By.xpath("//ul[@class = 'header-languages']//a[contains(., 'en')]"));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
