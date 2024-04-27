import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Alerts {
    ChromeDriver driver;


    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }

    @Test
    public void firstAlert() {
        WebElement firstButton = driver.findElement((By.id("alertButton")));
        firstButton.click();
        // Check that alert has text "You clicked a button"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// убедиться, сто открывается алерт
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //sleep(5000);
        assertEquals("You clicked a button", alert.getText());// ожидаем увидеть текст,что в алерт get.Text()
    }

        //Check that alert has text «This alert appeared after 5 seconds»
        @Test
     public void twoAlertText(){
        WebElement twoButton = driver.findElement((By.id("timerAlertButton")));
        twoButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// убедиться, сто открывается алерт
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This alert appeared after 5 seconds",alert.getText());
    }

    @Test
    public void youSelectedOk(){
        WebElement textYouSelect = driver.findElement((By.id("confirmButton")));
        textYouSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// убедиться, сто открывается алерт
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept(); // кликаем на кнопку ок
        WebElement text = driver.findElement(By.id("confirmResult"));
        System.out.println(text.getText());
        assertEquals("You selected Ok",text.getText());

    }

}
