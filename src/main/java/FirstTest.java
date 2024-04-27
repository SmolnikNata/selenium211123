import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {   //открывает страницу в браузере
@Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}