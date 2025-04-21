import org.testng.Assert;
import org.testng.annotations.Test;

public class aboutPageTests extends baseTest{

    @Test
    public void t_01_checkMainText(){
        /* Перехід до сторінки */
        mainPage.wait(10);
        mainPage.getDriver().get("https://ad.nure.ua/");
        mainPage.getMenuItemById("menu-item-52").click();
        mainPage.wait(10);
        Assert.assertEquals(aboutPage.getCurrentUrl(), "https://ad.nure.ua/pro-nas");

        /* Перевірка тексту основного блоку */
        Assert.assertEquals(aboutPage.getPageContent().getText(), "Усі пристрої сучасного комп’ютерного світу є програмно-апаратними системами, " +
                "де комп’ютерні програми і апаратура складають єдине ціле.\n" +
                "Саме розробкою та експлуатацією програмно-апаратних систем від комп’ютерних мереж великих корпорацій до інтелектуальних комп’ютерних іграшок " +
                "та інтерактивних мобільних за стосунків займаються випускники спеціальності 123_Компютерна інженерія.\n" +
                "Студенти нашої спеціальності вивчають сучасні мови програмування C, Python, Java для операційних систем Windows та Linux, програмування мобільних " +
                "пристроїв під операційними системами iOS та Android, розробляють сучасні системи мікроконтролерного управління інтегровані з Internet of Things, " +
                "а також вивчають сучасні системи автоматизованого проектування електронної апаратури на основі мов опису апаратури.\n" +
                "Наші студенти беруть участь у програмах міжнародного обміну з університетами Франції, Швеції, Італії, Німеччини, Польщі, доводять свою високу " +
                "кваліфікацію та захищають бакалаврські роботи за програмами цих університетів.\n" +
                "Випускники факультету обіймають провідні посади за фахом не тільки в Україні, але й у IT-компаніях світу –Aldec (Лас Вегас, США); Synopsis, Sling Media, " +
                "Gracenote (Сан-Франциско, Silicon Valley, Каліфорнія, США) та інші.\n" +
                "Випускник кафедри АПОТ з спеціалізованих комп’ютерних систем створює нові комп’ютерні та мобільні пристрої, інтегровані з інтернет додатками. Він " +
                "розробляє програмні продукти і проектує мікросистеми на кристалах. Він реалізує на хмарах віртуальні комп’ютери і сервіси.\n" +
                "Наукові напрямки кафедри:\n" +
                "технічна діагностика цифрових систем на кристалах, комп’ютерів та мереж;\n" +
                "проектування мозгоподібних та квантових комп’ютерів для кіберпростору;\n" +
                "інтелектуальні інформаційні технології діагностування комп’ютерних систем.\n" +
                "Пріоритети міжнародної діяльності – співпраця з європейськими та американськими університетами у межах міжнародних європейських програм. Результатом " +
                "такої роботи є Міжнародна конференція «Схід-Захід – Проектування й діагностика», у якій беруть участь провідні науковці з 40 країн світу. При ній " +
                "організовано школу-семінар молодих учених, для яких читають лекції фахівці, відомі у галузі проектування електронних систем.\n" +
                "   ЗАВІДУВАЧ КАФЕДРИ\n" +
                "Світлана Вікторівна Чумаченко\n" +
                "Завідувач кафедри автоматизації проектування обчислювальної техніки, член НМР, член НТР, відповідальний секретар видання “Радіоелектроніка та інформатика”, доктор технічних наук, професор\n" +
                "КОНТАКТИ\n" +
                "Головний корпус ХНУРЕ,\n" +
                "3 поверх,\n" +
                "кімн. 317-319\n" +
                "+38 (057) 702-13-26\n" +
                "d_ad@nure.ua\n" +
                "ad.nure.ua");
    }

    /** Тест перевіряє видимість посилання на онлайн-екскурсію ХНУРЕ та фото завідуючої кафедри */
    @Test
    public void t_02_checkVisibilityOfPhotoContent(){
        /* Перехід до сторінци */
        mainPage.getMenuItemById("menu-item-52").click();
        mainPage.wait(10);
        Assert.assertEquals(aboutPage.getCurrentUrl(), "https://ad.nure.ua/pro-nas");

        /* Перевірка видимості посилання на відео із онлайн-екскурсією */
        Assert.assertTrue(aboutPage.getUrlOfVideo().isEnabled());

        /* Перевірка видимості фото завідуючої кафедри */
        Assert.assertTrue(aboutPage.getPhotoOfHead().isDisplayed());
    }

    /** Тест перевіряє переклад сторінки "Про нас" на англійську */
    @Test
    public void t_03_checkTranslationToEnglish(){
        /* Перехід до сторінки */
        mainPage.getMenuItemById("menu-item-52").click();
        mainPage.wait(10);
        Assert.assertEquals(aboutPage.getCurrentUrl(), "https://ad.nure.ua/pro-nas");

        /* Перемикання на англійську */
        aboutPage.getEnButton().click();
        aboutPage.wait(10);
        Assert.assertEquals(aboutPage.getCurrentUrl(), "https://ad.nure.ua/en/about-us");

        /* Перевірка перекладу тексту основного блоку */
        Assert.assertEquals(aboutPage.getPageContent().getText(), "The Design Automation Department was founded in 1977 as the Department of Computer Science.\n" +
                "In 1993 it was renamed into the Department of Digital Design Automation. Full-time staff includes 19 people, including five Doctors and 10 Candidates of Sciences.\n" +
                "The Department trains students Bachelors majoring in 123 “Computer Engineering”, Ms in “Specialized Computer Systems”, “Embedded Microsystem Design” (EU TEMPUS Mast Mst).\n" +
                "Students study in detail subjects related not only to the operation of computers and networks, but also to designing high-speed reconfigurable computer systems.\n" +
                "Research areas of the Department:\n" +
                "technical diagnostics of digital systems on chips, computers and networks;\n" +
                "design of brain-like and quantum computers for cyberspace;\n" +
                "intelligent IT for computer systems diagnostics.\n" +
                "Priority for international activity is the cooperation with European and American universities within international and European programs. The result of this work is the International Conference “East-West – Design and Diagnostics”, which involves leading scientists from 40 countries.\n" +
                "It organized a Summer School for young scientists, where the experts known in the field of design of electronic systems give lectures.\n" +
                " ");

        /* Перевірка перекладу текстів в блоці "HEAD" */
        Assert.assertEquals(aboutPage.getHeadInfo().getText(), "HEAD\n" +
                "Svetlana Chumachenko\n" +
                "Head of Design Automation Department, Member of EMC, Member of STC, executive Secretary of “Radioelectronics & Informatics” Journal, Doctor of Technical Sciences, Professor");

        Assert.assertEquals(aboutPage.getContactInfo().getText(), "CONTACTS\n" +
                "The main building of KNURE,\n" +
                "3rd floor\n" +
                "rooms  317-319\n" +
                "+38 (057) 702-13-26\n" +
                "d_ad@nure.ua\n" +
                "ad.nure.ua");

        /* Перевірка видимості посилання на відео із онлайн-екскурсією в англійській версії */
        Assert.assertTrue(aboutPage.getUrlOfVideo().isEnabled());

        /* Перевірка видимості фото завідуючої кафедри в англійській версії */
        Assert.assertTrue(aboutPage.getPhotoOfHead().isDisplayed());

    }
}
