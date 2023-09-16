package UXCrowd.ui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class AccountPage extends AbstractPage {

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath ="//input[@id='login']")
    private WebElement loginInput;

    @FindBy(xpath ="//input[@name='password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@data-testid='Login button']")
    private WebElement loginBotton;

    @FindBy(css ="div[data-testid='Header profile settings'][class='sc-fzqOul kYKazV']" )
    private WebElement email;

    public String getEmail(){
        return email.getText();}


    public void Ticket(String loginInputValue, String loginPasswordValue){
        loginInput.sendKeys(loginInputValue);
        loginPassword.sendKeys(loginPasswordValue);
        loginBotton.click();
    }
    public void Assert(){
        System.out.println(getEmail());
        Assert.assertEquals(getEmail(),"client@mailto.plus");
    }



}
