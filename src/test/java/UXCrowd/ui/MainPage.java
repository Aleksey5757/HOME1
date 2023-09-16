package UXCrowd.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

@FindBy(id = "header-lk-button")
    private WebElement bottonLogin;

    public void PageBottonLogin(){
        bottonLogin.click();

    }


}
