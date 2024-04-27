import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Registration {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/registration1.html"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }

    @Test
    public void successRegistrationWithRequiredFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("Black");

        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputFiled.sendKeys("jblack@gmail.com");
        //sleep(5000);

        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", header.getText());

        assertTrue(header.getText().contains("You have successfully registered"));
    }

    //Check all input fields
    @Test
    public void successRegistartionWithAllFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputField.sendKeys("Black");

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputField.sendKeys("jblack@gmail.com");

        WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your phone:\"]"));
        phoneInputField.sendKeys("123456789");

        WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your address:\"]"));
        addressInputField.sendKeys("13256 VA Williamsburger str 10");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
    }

    @Test
    public void withoutFirstName() {
        WebElement lastNameInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("Black");

        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputFiled.sendKeys("jblack@gmail.com");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();

        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        assertEquals("Заполните это поле.", firstNameInputField.getAttribute("validationMessage"));
    }

    //1. without Last name
    @Test
    public void withoutLastName() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        firstNameInputField.sendKeys("John");
        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputFiled.sendKeys("jblack@gmail.com");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        assertEquals("Заполните это поле.", lastNameInputField.getAttribute("validationMessage"));

    }
//2. without email

    @Test
    public void withoutEmail() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("Black");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        assertEquals("Заполните это поле.", emailInputField.getAttribute("validationMessage"));

    }

    //3. without all requirment fields
    @Test
    public void withoutAllRequirementFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        assertEquals("Заполните это поле.", firstNameInputField.getAttribute("validationMessage"));

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        assertEquals("Заполните это поле.", lastNameInputField.getAttribute("validationMessage"));

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        assertEquals("Заполните это поле.", emailInputField.getAttribute("validationMessage"));

    }
}




