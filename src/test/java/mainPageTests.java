import org.testng.Assert;
import org.testng.annotations.Test;

public class mainPageTests extends baseTest{

    /** Тест перевіряє видимість карток на головній сторінці сайту
     * Перевірка вмісту карток, їх даних та тексту */
    @Test
    public void t_01_CheckVisibilityOfIcons(){
        /* Перевірка видимості карток */
        Assert.assertTrue(mainPage.getCardByName("Hauptsitz").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Geschäftsführung").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Kundengruppen").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Mitarbeiter").isDisplayed());
        Assert.assertTrue(mainPage.getCardByName("Gründungsjahr").isDisplayed());

        /* Перевірка тексту карток */
        Assert.assertEquals(mainPage.getCardByName("Hauptsitz").getText(), "Hauptsitz\n" +
                "Leopoldstraße 244, 80807 München");
        Assert.assertEquals(mainPage.getCardByName("Geschäftsführung").getText(), "Geschäftsführung\n" +
                "Stefan Huber\n" +
                "Martin Werner");
        Assert.assertEquals(mainPage.getCardByName("Kundengruppen").getText(), "Kundengruppen\n" +
                "Banken, Versicherungsgesellschaften,\n" +
                "Öffentlich-Rechtliche Versorgungsträger,\n" +
                "Finanzdienstleister und Vertriebe");
        Assert.assertEquals(mainPage.getCardByName("Mitarbeiter").getText(), "Mitarbeiter\n" +
                "110");
        Assert.assertEquals(mainPage.getCardByName("Gründungsjahr").getText(), "Gründungsjahr\n" +
                "1996");
    }

    /** Тест перевіряє правильність текстів на головній сторінці додатку */
    @Test
    public void t_02_checkTexts(){
        Assert.assertTrue(mainPage.getTextOnPage("VData Software Entwicklung GmbH").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Das Softwarehaus rund um die Vorsorge").isDisplayed());
        Assert.assertTrue(mainPage.getTextOnPage("Die VData Software-Entwicklung GmbH und ihre Tochtergesellschaften sind auf die Entwicklung, Implementierung\n" +
                "\t\t\t\tund Vermarktung von komplexen Anwendungs- und Verwaltungssystemen mit dem Fokus gesetzliche und betriebliche\n" +
                "\t\t\t\tAltersversorgungssysteme für den deutschen und osteuropäischen Markt spezialisiert.").isDisplayed());
    }

    /** Тест перевіряє видимість і правильність посилань */
    @Test
    public void t_03_checkLinks(){
        /* Перевірка посилання Impressum */
        mainPage.getLinksInFooter("Impressum").click();
        mainPage.wait(5);
        Assert.assertEquals(mainPage.getCurrentUrl(), "http://www.vdata.de/home/impressum.jsp");

        /* Перевірка посилання Datenschutz */
        mainPage.getLinksInFooter("Datenschutz").click();
        mainPage.wait(5);
        Assert.assertEquals(mainPage.getCurrentUrl(), "http://www.vdata.de/home/datenschutz.jsp");
    }
}
