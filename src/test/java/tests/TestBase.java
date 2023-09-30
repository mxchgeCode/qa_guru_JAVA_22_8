package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxPage;
import pages.components.VerifyTextResultComponent;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    VerifyTextResultComponent verifyTextResultComponent = new VerifyTextResultComponent();
    TextBoxPage textBoxPage = new TextBoxPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

}