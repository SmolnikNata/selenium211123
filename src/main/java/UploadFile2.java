import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFile2 {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }
    @Test

    public void uploadFile() {
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        uploadFile.sendKeys("C:\\Users\\Natalia Smolnikova\\Desktop\\textfile.txt");//путь к файлу

        WebElement header = driver.findElement((By.id("uploadedFilePath")));
        assertTrue(header.getText().contains("textfile.txt"));

    }
}
