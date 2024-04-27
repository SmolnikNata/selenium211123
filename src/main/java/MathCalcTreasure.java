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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathCalcTreasure {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/get_attribute.html"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }
    // вычисляем значение функций
    public double funcCalc(double x){
        return  log(abs(12*sin(x)));
    }

    @Test
    public void validAnswer() throws InterruptedException {
        WebElement imgTreasure = driver.findElement(By.id("treasure"));

        double result = funcCalc(Double.parseDouble(imgTreasure.getAttribute("valuex"))); //преобразуем из строки в дабле

        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result)); // из числа в строку
        // sleep(5000);

        //check checkbox
        WebElement checkbox=
                driver.findElement(By.id("robotCheckbox")); //ставим галочку в чек боксе
        checkbox.click();

        //choose Robots rule
        WebElement robotsRule=
                driver.findElement(By.id("robotsRule"));// ставим галочку в радиобаттон
        robotsRule.click();

        //Clicksubmit Button
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type=\"submit\"]")); // кликаем по submit
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        sleep(5000);
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }


}
