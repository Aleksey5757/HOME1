package UXCrowd.ui;

import config.ApplicationConfig;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.UserPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class main {
    private RemoteWebDriver driver;
    private ApplicationConfig config;

    private WebDriverWait wait;



    @BeforeAll
    public void configInit() {
        config = new ApplicationConfig();
    }

    @BeforeEach
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(200));
    }

   // @AfterEach
 //public void tearDown() throws InterruptedException {
   // Thread.sleep(5000);
    //   driver.quit();}



    @Test

    public void loginTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(config.baseUrl);
        WebElement submitBtn = driver.findElement(By.id("header-lk-button"));
        submitBtn.click();
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='login']"));
        loginInput.sendKeys(config.usernameCL);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(config.userPasswordCL);
        WebElement submitBtnIn = driver.findElement(By.xpath("//button[@data-testid='Login button']"));
        submitBtnIn.click();
        Thread.sleep(4000);
       // WebElement submitemail = driver.findElement(By.xpath("//div[@data-testid='Profile client menu button']"));
       // submitemail.click();
        WebElement textEmail = driver.findElement(By.cssSelector("div[data-testid='Header profile settings'][class='sc-fzqOul kYKazV']"));
        String actualText = textEmail.getText();
        String expectedText = "client@mailto.plus";
        System.out.println(actualText);
        Assert.assertEquals(actualText, expectedText);
    }


    @Test

    public void loginTestPO() throws InterruptedException {
        String loginInputValue = "testValue";
        String loginPasswordValue = "testValue";
        driver.manage().window().maximize();
        driver.get(config.baseUrlUXCr);
        var mainPage = new MainPage(driver,wait);
        mainPage.PageBottonLogin();
        Thread.sleep(4000);
        var accountPage = new AccountPage(driver,wait);
        accountPage.Ticket(loginInputValue,loginPasswordValue);
        Thread.sleep(4000);
        accountPage.Assert();
    }
}
