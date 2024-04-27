import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopRegistration {
    ChromeDriver driver;

    @BeforeEach      // coхраняем ссылку и драйвер,чтобы далее их не писать в каждом темте
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Natalia Smolnikova\\Desktop\\projects\\tel-ran\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register"); // ссылка на страницу
    }

    @AfterEach
    public void tearDown() {  // для закрытия страницы после прохождения теста автоматически
        driver.quit();
    }




        @Test

        public void successRegistrAllValidField () throws InterruptedException {
            Faker faker = new Faker();// генерируем с помощью библтотеки эмайл
            String randomEmail = faker.internet().emailAddress();
            // faker.name///

            //Input all data
            WebElement firstNameInputField = driver.findElement(By.id("FirstName"));
            firstNameInputField.sendKeys("John");

            WebElement lastNameInputFiled = driver.findElement(By.id("LastName"));
            lastNameInputFiled.sendKeys("Black");

            WebElement emailInputFiled = driver.findElement(By.id("Email"));
            emailInputFiled.sendKeys(randomEmail); //вернет сроку ,применяя метод для генерации эмэйла.
            //sleep(5000);
            WebElement passwordInputFiled = driver.findElement(By.id("Password"));
            passwordInputFiled.sendKeys("123asd!#");

            WebElement confirmPasswordInputFiled = driver.findElement(By.id("ConfirmPassword"));
            confirmPasswordInputFiled.sendKeys("123asd!#");

            WebElement registerButton = driver.findElement(By.id("register-button"));
            registerButton.click();

            //Text "Your registration completed" is displayed
            //sleep(5000);

            WebElement header = driver.findElement(By.cssSelector(".page-body .result"));
            assertTrue(header.getText().contains("Your registration completed"));

            WebElement continueButton = driver.findElement(By.cssSelector("[class=\"button-1 register-continue-button\"]"));
            assertTrue(continueButton.isDisplayed());
        }

        // сгенерировать эмайл

        protected String getSaltString () {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 10) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            return saltStr.toLowerCase() + "@gmail.com";
        }
        @Test  //  генерация email
        public void emailGenerateTest () {
            System.out.println(getSaltString());
        }

        @Test  // без имени: Firstname
    public void ivalidDataEmptyFirstName(){
            Faker faker = new Faker();// генерируем с помощью библтотеки эмайл
            String randomEmail = faker.internet().emailAddress();

            //check that "First name is required." error message text is displayed

            WebElement lastNameInputFiled = driver.findElement(By.id("LastName"));
            lastNameInputFiled.sendKeys("Black");

            WebElement emailInputFiled = driver.findElement(By.id("Email"));
            emailInputFiled.sendKeys(randomEmail); //вернет сроку ,применяя метод для генерации эмэйла.
            //sleep(5000);
            WebElement passwordInputFiled = driver.findElement(By.id("Password"));
            passwordInputFiled.sendKeys("123asd!#");

            WebElement confirmPasswordInputFiled = driver.findElement(By.id("ConfirmPassword"));
            confirmPasswordInputFiled.sendKeys("123asd!#");

            WebElement registerButton = driver.findElement(By.id("register-button"));
            registerButton.click();

            WebElement firstName = driver.findElement(By.cssSelector(".field-validation-error>span"));
            assertTrue(firstName.getText().contains("First name is required."));
        }
        @Test // ,без фамилии:Lastname //1. Specify all fields with valid data, Last name is empty, check the error message text
    public void ivalidDataEmptyLastName(){

            Faker faker = new Faker();// генерируем с помощью библтотеки эмайл
            String randomEmail = faker.internet().emailAddress();
            // faker.name///

            //Input all data
            WebElement firstNameInputField = driver.findElement(By.id("FirstName"));
            firstNameInputField.sendKeys("John");

            WebElement emailInputFiled = driver.findElement(By.id("Email"));
            emailInputFiled.sendKeys(randomEmail); //вернет сроку ,применяя метод для генерации эмэйла.
            //sleep(5000);
            WebElement passwordInputFiled = driver.findElement(By.id("Password"));
            passwordInputFiled.sendKeys("123asd!#");

            WebElement confirmPasswordInputFiled = driver.findElement(By.id("ConfirmPassword"));
            confirmPasswordInputFiled.sendKeys("123asd!#");

            WebElement registerButton = driver.findElement(By.id("register-button"));
            registerButton.click();

            WebElement lastName = driver.findElement(By.cssSelector(".field-validation-error>span"));
            assertTrue(lastName.getText().contains("Last name is required."));
        }
        @Test  // без email //2. Specify all fields with valid data,Email is empty, check the error message text
        public void ivalidDataEmptyEmaile(){
            Faker faker = new Faker();// генерируем с помощью библтотеки эмайл
            String randomEmail = faker.internet().emailAddress();
            // faker.name///

            //One email
            WebElement firstNameInputField = driver.findElement(By.id("FirstName"));
            firstNameInputField.sendKeys("John");

            WebElement lastNameInputFiled = driver.findElement(By.id("LastName"));
            lastNameInputFiled.sendKeys("Black");

            WebElement passwordInputFiled = driver.findElement(By.id("Password"));
            passwordInputFiled.sendKeys("123asd!#");

            WebElement confirmPasswordInputFiled = driver.findElement(By.id("ConfirmPassword"));
            confirmPasswordInputFiled.sendKeys("123asd!#");

            WebElement registerButton = driver.findElement(By.id("register-button"));
            registerButton.click();

            WebElement email = driver.findElement(By.cssSelector(".field-validation-error>span"));
            assertTrue(email.getText().contains("Email is required."));
        }
    //3 .Specify all fields with valid data, Email invalid format (without @), check the error message text
    @Test
    public void ivalidFormatEmail(){
        Faker faker = new Faker();// генерируем с помощью библтотеки эмайл
        String randomEmail = faker.internet().emailAddress();
        // faker.name///
        //Input all data c невалидным email
        WebElement firstNameInputField = driver.findElement(By.id("FirstName"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputFiled = driver.findElement(By.id("LastName"));
        lastNameInputFiled.sendKeys("Black");

        WebElement emailInputFiled = driver.findElement(By.id("Email"));
        emailInputFiled.sendKeys("jblackgmail.com");

        //sleep(5000);
        WebElement passwordInputFiled = driver.findElement(By.id("Password"));
        passwordInputFiled.sendKeys("123asd!#");

        WebElement confirmPasswordInputFiled = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInputFiled.sendKeys("123asd!#");

        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();



    }












//        WebElement header = driver.findElement(By.tagName("h1")); VonTagil19!
//        assertEquals("Congratulations! You have successfully registered!", header.getText());
//
//        assertTrue(header.getText().contains("You have successfully registered"));

        //Text "Your registration completed" is displayed

        //Button "Continue" is displayed
    }

