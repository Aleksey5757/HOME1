package UXCrowd.step;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class MainStep {
    private final SelenideElement login = $x("//a[@id='header-lk-button']");
    private final SelenideElement loginInput =$x("//input[@id='login']");
    private final SelenideElement loginPassword =$x("//input[@name='password']");
    private final SelenideElement loginBotton = $x("//button[@data-testid='Login button']");
    private final SelenideElement email = $x("//div[@data-testid='Header profile settings' and text()='client@mailto.plus']");


    @When("Нажать на кнопку Войти")
    public void login() {
        login.click();
    }

    @And("Водим валидные данные в поле почта {string}")
    public void LoginInput(String arg0) {
        loginInput.sendKeys(arg0);
    }

    @And("Водим валидные данные в поле пароль {string}")
    public void LoginPassword(String arg0) {
        loginPassword.sendKeys(arg0);
    }

    @And("После ввода нажать на кнопку Войти")
    public void LoginBotton() {
        loginBotton.click();
    }

    @Then("Проверить валидность ЛК клиента по email {string}")
    public void Assert(String arg0) {
        String acText = email.getText();
        Assert.assertEquals(acText,arg0);

    }
}
