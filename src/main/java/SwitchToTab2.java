import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchToTab2 {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }
    @Test
    public void switchToTabTest(){
        //click on New Tab
        //switch to  new opened tab
        //check that text "This is a sample page" is displayed
        WebElement clickOnNewTab = driver.findElement(By.id("tabButton"));// новый эдемент по айди
        clickOnNewTab.click(); //кликаем

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());// перехдим на новую вкладку с индексом 1
        driver.switchTo().window(tabs.get(1));

        WebElement checkThatText = driver.findElement(By.tagName("h1"));//убеждаемся,что видим текст в хэдэре
        //assertTrue(checkThatText.getText().contains("This is a sample page")); // забираем текс и уюеждаемся,сто он есть
       assertEquals("This is a sample page",checkThatText.getText());

    }
}
