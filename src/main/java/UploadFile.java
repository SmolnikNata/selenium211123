import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFile {

    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/file_input.html"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }
    @Test
    public void uploadFieleTest() throws InterruptedException {
        WebElement firstInputField = driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
        firstInputField.sendKeys("John");

        WebElement lastInputField = driver.findElement(By.xpath("//input[@placeholder='Enter last name']"));
        lastInputField.sendKeys("white");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
        emailInputField.sendKeys("wer@gmail.com");
        //sleep(5000);
        // загрузить файл проверяем

        WebElement uploadFileInput = driver.findElement(By.id("file"));
        uploadFileInput.sendKeys("C:\\Users\\Natalia Smolnikova\\Desktop\\textfile.txt");

        WebElement submitButtom = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        submitButtom.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


    }
}
