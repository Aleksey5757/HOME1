package UXCrowd.step;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AfterStep {
    @After
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();
    }

}
