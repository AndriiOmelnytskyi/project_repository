import org.testng.Assert;
import org.testng.annotations.Test;

public class mainPageEnglishTests extends baseTest {

    /** Тест перевіряє переклад сайту кафедри на англійську */
    @Test
    public void t_01_checkTranslationInMenus(){
        /* Переклад сторінки на англійську */
        mainPage.getDriver().get("https://ad.nure.ua/");
        mainPage.wait(10);
        mainPage.getEnButton().click();
        mainPage.wait(10);
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://ad.nure.ua/en/");

        /* Перевірка перекладу карток із посиланнями на зовнішні ресурси */
        Assert.assertTrue(mainPage.getCardByName("Ministry of Education and Science of Ukraine").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("The official website of NURE").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Scientific Library").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Lessons schedule").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Distance education").isDisplayed());

        /* Перевірка перекладу іконок меню */
        Assert.assertTrue(mainPage.getMenuItems("Homepage").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("About us").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Staff").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("News").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Partners").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Graduates").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Media").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Vacancy").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Contacts").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Certification").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("For applicant").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Science").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("For student").isDisplayed());
    }

    @Test
    public void t_02_checkEnglishTexts(){
        /* Переклад сторінки на англійську */
        mainPage.wait(10);
        mainPage.getDriver().get("https://ad.nure.ua/");
        mainPage.getEnButton().click();
        mainPage.wait(10);
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://ad.nure.ua/en/");

        /* Перевірка основних текстів */
        Assert.assertTrue(mainPage.getTextOnPage("Design Automation Department").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("News").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Partners").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("© Design Automation Department, 2001 - 2025.").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Website development — Rubika").isDisplayed());
    }
}
