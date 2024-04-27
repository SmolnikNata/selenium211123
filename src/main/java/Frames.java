import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Frames {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }
    @Test
    public void framesTest(){
        driver.switchTo().frame("frame1");
        WebElement headerOne = driver.findElement(By.id("sampleHeading"));
        //List<WebElement> headers = driver.findElements((By.id("sampleHeading")));
        //переключаемся между фрэймами html страницы
        assertEquals("This is a sample page",headerOne.getText());

        driver.switchTo().defaultContent();// вернемся на основную страницу с основным HTML_
        // тюк мы находимся внутри вложенного HTML

        driver.switchTo().frame("frame2");
        WebElement headerTwo = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page",headerTwo.getText());
    }
}
