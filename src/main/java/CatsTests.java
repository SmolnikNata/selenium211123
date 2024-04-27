import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class CatsTests {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://suninjuly.github.io/cats.html"); //ссылка на страницу
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
//    @Test
//    public void photoIconIsDisplayed(){
//        WebElement photoIcon = driver.findElement(By.tagName("svg"));
//        assertTrue(photoIcon.isDisplayed());
//    }

    @Test
    public void headerTest() {

        WebElement header = driver.findElement(By.tagName("h1")); //WebElement-класс,есть в библиотеке
        // Selenium,в котором реализован метод getText()
        assertEquals("Cat memes", header.getText());//(собираемся увидеть,то,ч то там действительно содержиться)
    }


    @Test

    public void timeOfFirstCatCardTest() {

        WebElement timeFirstCat = driver.findElement(By.cssSelector(".col-sm-4:nth-child(1) small"));
        assertEquals("9 mins", timeFirstCat.getText());
    }

    @Test
    public void textIloveSoMath() {

        WebElement lastCardName = driver.findElement(By.cssSelector(".col-sm-4:nth-child(6) p"));
        assertEquals("I love you so much", lastCardName.getText());

    }

    @Test
    public void catsAlbumText() {

        WebElement catsAlbum = driver.findElement(By.tagName("strong"));
        assertEquals("Cats album", catsAlbum.getText());
    }

    @Test
    public void firstCat() {

        WebElement firstCatCard = driver.findElement(By.cssSelector(".col-sm-4:nth-child(1)"));
        assertTrue(firstCatCard.isDisplayed());
    }

    @Test
    public void checkPhoto() {

        WebElement photoCard = driver.findElement(By.tagName("svg"));
        assertTrue(photoCard.isDisplayed());
    }
    // работа с коллекциями

    @Test
    public void checkTmageOuantity() {

        List<WebElement> images = driver.findElements(By.tagName("img"));
        assertEquals(6, images.size());
    }

    // 6 карточек с котами, убеждаемся,что 6(размер)
    @Test
    public void checkCardQuantity() {

        List<WebElement> card = driver.findElements(By.cssSelector(".col-sm-4"));
        assertEquals(6, card.size());

    }

    // все тексты 9 мин
    @Test
    public void checkTextMin() {   //находим текстов 9 mins

        List<WebElement> text9min = driver.findElements(By.tagName("small")); // текст 9 мин
        assertEquals(6, text9min.size());
    }

    @Test
    public void checkAllCardsAreDisplayed() { //все 6 карточек отображаются

        List<WebElement> cards = driver.findElements(By.cssSelector(".col-sm-4"));
        assertEquals(6, cards.size());
//        for (int i = 0; i < cards.size(); i++) {
//            assertTrue(cards.get(i).isDisplayed());
//        for (WebElement card : cards) {
//            assertTrue(card.isDisplayed());
        cards.forEach(card -> assertTrue(card.isDisplayed()));
    }

    @Test
    public void checkTmageisDisplayed() {

        List<WebElement> images = driver.findElements(By.tagName("img"));
  //      for (int i = 0; i < images.size(); i++) {
//            assertTrue(images.get(i).isDisplayed());
            for (WebElement img : images) {
                assertTrue(img.isDisplayed());
                images.forEach(card -> assertTrue(card.isDisplayed()));
            }
        }
    }








