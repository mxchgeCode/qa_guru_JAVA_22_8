package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.VerifyTextResultComponent;

public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyTextResultComponent verifyTextResultComponent = new VerifyTextResultComponent();

    public static final String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public static final String USER_NAME = "TestUserName";
    public static final String USER_SURNAME = "TestLastName";
    public static final String USER_EMAIL = "Test@test.com";
    public static final String USER_GENDER = "Male";
    public static final String USER_NUMBER = "9123456789";
    public static final String YEAR_OF_BIRTH = "1990";
    public static final String MONTH_OF_BIRTH = "June";
    public static final String DAY_OF_BIRTH = "03";
    public static final String SUBJECT = "Physics";
    public static final String HOBBY = "Sports";
    public static final String FILE_NAME = "1.png";
    public static final String USER_STATE = "NCR";
    public static final String USER_CITY = "Delhi";
    public static final String ADDRESS = "TEST Address - 123";
    public static final String TEST_TEXT = "TEST_TEXT";
    public static final String TEXT_IN_RESULT_WINDOW = "Thanks for submitting the form";


    @Test
    void fillAllFormsAndVerifyResultTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .removeBanner()
                .CheckLabel()
                .setFirstName(USER_NAME)
                .setLastName(USER_SURNAME)
                .setEmail(USER_EMAIL)
                .setGender(USER_GENDER)
                .setUserNumber(USER_NUMBER)
                .setDateOfBirth(DAY_OF_BIRTH, MONTH_OF_BIRTH, YEAR_OF_BIRTH)
                .setSubject(SUBJECT)
                .selectHobby(HOBBY)
                .uploadImage(FILE_NAME)
                .setAddress(ADDRESS)
                .setState(USER_STATE)
                .setCity(USER_CITY)
                .clickSubmitButton();
        verifyTextResultComponent.checkResultWindowHaveText(TEXT_IN_RESULT_WINDOW)
                .verifyTableResult(USER_NAME + " " + USER_SURNAME)
                .verifyTableResult(USER_EMAIL)
                .verifyTableResult(USER_GENDER)
                .verifyTableResult(USER_NUMBER)
                .verifyTableResult(DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH)
                .verifyTableResult(SUBJECT)
                .verifyTableResult(HOBBY)
                .verifyTableResult(FILE_NAME)
                .verifyTableResult(ADDRESS)
                .verifyTableResult(USER_STATE + " " + USER_CITY);
    }

    @Test
    void checkRequiredFieldsViewTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .removeBanner()
                .CheckLabel()
                .clickSubmitButton()
                .userFormContainsValidatedClass("was-validated")
                .containsRequiredCssValues("#firstName")
                .containsRequiredCssValues("#lastName")
                .containsRequiredCssValues("#userNumber");

    }

    @Test
    void fillUserNumberByLettersTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .removeBanner()
                .CheckLabel()
                .setUserNumber(TEST_TEXT)
                .clickSubmitButton()
                .containsRequiredCssValues("#userNumber");
    }

}