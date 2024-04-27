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
import java.util.ArrayList;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchToTab {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/redirect_accept.html"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }
    public double funcCalc(double x){
        return  log(abs(12*sin(x)));
    }

    @Test
    public void switchToTabTest() throws InterruptedException {
        WebElement redirectButton = driver.findElement(By.tagName("button"));
        redirectButton.click();  //кликаем на эту кнопку
        //открывается вкладка для вычисления ч.л
        //sleep(5000);
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getWindowHandle());

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//
        driver.switchTo().window(tabs.get(1));
//        WebElement answerInputField = driver.findElement(By.id("answer"));
//        answerInputField.sendKeys("hlfghoih");
//        sleep(5000);

        WebElement x = driver.findElement(By.id("input_value"));
        double result = funcCalc(Double.parseDouble(x.getText())); //преобразуем из строки в дабле
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result)); // из числа в строку

        WebElement submitButton =
                driver.findElement(By.cssSelector("button")); // кликаем по submit
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //алерт,что появляется после нажатия submit
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
        sleep(2000);

    }

}

