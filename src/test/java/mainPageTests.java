import org.testng.Assert;
import org.testng.annotations.Test;

public class mainPageTests extends baseTest{

    /** Тест перевіряє видимість карток з зовнішніми посиланнями на головній сторінці сайту
     * Перевірка видимості пунктів меню */
    @Test
    public void t_01_CheckVisibilityOfIcons(){
        mainPage.wait(10);
        mainPage.getDriver().get("https://ad.nure.ua/");
        /* Перевірка видимості карток */
        Assert.assertTrue(mainPage.getCardByName("Мiнiстерство освiти i науки України").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Наукова бібліотека").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Розклад занять").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Дистанційна освіта").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Офіційний сайт ХНУРЕ").isDisplayed());

        /* Перевірка видимості іконок меню */
        Assert.assertTrue(mainPage.getMenuItems("Головна").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Про нас").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Співробітники").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Новини").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Партнери").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Випускники").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Медіа").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Вакансії").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Контакти").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Дипломування").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Абітурієнту").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Наука").isDisplayed());
        Assert.assertTrue(mainPage.getMenuItems("Студенту").isDisplayed());
    }

    /** Тест перевіряє правильність текстів на головній сторінці додатку */
    @Test
    public void t_02_checkTexts(){
        mainPage.wait(10);
        mainPage.getDriver().get("https://ad.nure.ua/");
        /* Перевірка основних текстів */
        Assert.assertTrue(mainPage.getTextOnPage("© Кафедра автоматизації проектування обчислювальної техніки, 2001 - 2025.").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Кафедра автоматизації проектування обчислювальної техніки").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Новини").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Партнери").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Розробка сайту — Rubika").isDisplayed());
    }

    /** Тест перевіряє видимість і правильність посилань */
    @Test
    public void t_03_checkLinks(){
        String originalWindow = mainPage.getDriver().getWindowHandle();

        /* Перевірка наявності посилань на сайти партнерів на головній сторінці додатку */
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://www.nixsolutions.com/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://www.globallogic.com/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://www.gameloft.com/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://www.infostroy.com/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://sigma.software/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("http://workat.dnt-lab.com/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://first.institute/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://cloudwharf.com/").isEnabled());
        Assert.assertTrue(mainPage.getLinkInPartnerBlock("https://www.aldec.com/en").isEnabled());

        /* Перевірка можливості переходу на сайт парнетра кліком на лого партнера */
        mainPage.getLinkInPartnerBlock("https://www.nixsolutions.com/").click();
        mainPage.wait(10);

        /* Перехід на нове вікно*/
        for (String windowHandle : mainPage.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                mainPage.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        /* Перевірка посилання*/
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://www.nixsolutions.com/");
    }

    @Test
    public void t_04_checkTranslationInMenus(){
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
    public void t_05_checkEnglishTexts(){
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
