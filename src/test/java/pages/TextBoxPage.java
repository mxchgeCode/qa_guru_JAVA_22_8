package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressTextArea = $("#currentAddress"),
            permanentAddressTextArea = $("#permanentAddress"),
            submitButton = $("#submit"),
            mainHeaderText = $(".main-header");

    public TextBoxPage openPage(String pageAddress) {
        open(pageAddress);
        mainHeaderText.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public TextBoxPage setName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage submitButtonClick() {
        submitButton.click();
        return this;
    }
    public TextBoxPage containsRequiredCssValues(String element) {
        $(element)
                .shouldHave(cssValue("border", "1px solid rgb(255, 0, 0)"))
                .shouldHave(cssClass("field-error"));
        return this;
    }

    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

}
