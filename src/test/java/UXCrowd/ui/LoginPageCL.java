package UXCrowd.ui;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageCL {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement loginInputCL;

    private WebElement passwordInputCL;
    private WebElement submitLogin;
    private WebElement submitLoginLogin;


    public LoginPageCL(WebDriver driver, WebDriverWait wait) {
        super();
        this.driver = driver;
        this.wait = wait;
        loginInputCL = driver.findElement(By.xpath("//input[@id='login']"));
        passwordInputCL = driver.findElement(By.xpath("//input[@name='password']"));
        submitLogin = driver.findElement(By.xpath("//a[text()='Войти']"));
       // WebElement textEmail = driver.findElement(By.xpath("//a[text()='Войти']"));
        submitLoginLogin = driver.findElement(By.xpath("//button[@data-testid='Login button']"));
    }

    private Alert findAlert() {
        return wait.until(drv -> drv.switchTo().alert());
    }
    public void fillLoginInput(String text) {
        loginInputCL.clear();
        loginInputCL.sendKeys(text);
    }


      public void fillPasswordInput(String text) {
        passwordInputCL.clear();
        passwordInputCL.sendKeys(text);
    }
    public void submit() {
        submitLogin.click();
    }

    public void submitForm() {
        submitLogin.click();
    }
    public String getAlertText() {
        return findAlert().getText();
    }

    public void dismissAlert() {
        findAlert().dismiss();
    }

}

