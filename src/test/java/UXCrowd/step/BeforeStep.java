package UXCrowd.step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import page.AbstractPage;

public class BeforeStep extends AbstractPage {
    @Given("открываем сайт {string}")
    public void OpenWebSite(String url) {
        Selenide.open(url);

    }
}
