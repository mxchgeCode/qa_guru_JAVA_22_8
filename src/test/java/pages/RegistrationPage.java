package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            selectStateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            selectCityDropdown = $("#city"),
            submitButton = $("#submit"),
            userForm = $("#userForm");


    public RegistrationPage openPage(String pageAddress) {
        open(pageAddress);
        return this;
    }

    public RegistrationPage CheckLabel(){
        titleLabel.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadImage(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressTextArea.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        selectStateDropdown.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCityDropdown.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage userFormContainsValidatedClass(String className) {
        userForm.shouldHave(cssClass(className));
        return this;
    }

    public RegistrationPage containsRequiredCssValues(String element) {
        $(element)
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"))
                .shouldHave(attribute("required"));
        return this;
    }


}