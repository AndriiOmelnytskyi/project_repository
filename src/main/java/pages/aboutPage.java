package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class aboutPage extends basePage{

    /** Приклад ініціалізації веб-сторінки */
    public aboutPage() {
        wait(5);
    }

    public WebElement getPageContent(){
        return driver.findElement(By.xpath("//div[@class = 'page-content']"));
    }

    public WebElement getUrlOfVideo(){
        return driver.findElement(By.xpath("//a[@href='https://drive.google.com/file/d/1VVXP33bdqjoXMAi04kA9Llqy83S6s4f5/view']"));
    }

    public WebElement getPhotoOfHead(){
        return driver.findElement(By.xpath("//div[@class = 'cathedra bg-white']//img[@src = 'https://nure.ua/wp-content/uploads/Employees_photo/chumachenko-s.v..jpg']"));
    }

    public WebElement getEnButton(){
        return driver.findElement(By.xpath("//ul[@class = 'header-languages']//a[contains(., 'en')]"));
    }

    public WebElement getHeadInfo(){
        return driver.findElement(By.xpath("//div[@class = 'short-info col-md-6 col-sm-5 col-xs-12']"));
    }

    public WebElement getContactInfo(){
        return driver.findElement(By.xpath("//div[@class = 'contacts col-md-3 col-sm-4 col-xs-12']"));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
