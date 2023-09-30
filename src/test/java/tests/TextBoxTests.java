package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.VerifyTextResultComponent;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    VerifyTextResultComponent verifyTextResultComponent = new VerifyTextResultComponent();
    public static final String TEXT_BOX_URL = "/text-box";
    public static final String USER_NAME = "TestUserName";
    public static final String USER_EMAIL = "Test@test.com";
    public static final String CURRENT_ADDRESS = "Current_test_address";
    public static final String PERMANENT_ADDRESS = "Permanent_test_address";
    public static final String SQL_TEST  = "DROP TABLE USERS";


    @Test
    void fillAllFormsTest() {
        textBoxPage.openPage(TEXT_BOX_URL)
                .removeBanner()
                .setName(USER_NAME)
                .setEmail(USER_EMAIL)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setPermanentAddress(PERMANENT_ADDRESS)
                .submitButtonClick();
        verifyTextResultComponent.verifyOutputName(USER_NAME)
                .verifyOutputEmail(USER_EMAIL)
                .verifyOutputCurrentAddress(CURRENT_ADDRESS)
                .verifyOutputPermanentAddress(PERMANENT_ADDRESS);
    }

    @Test
    void IsUserNameCorrect_InvalidUserName_ReturnsFalseTest() {
        textBoxPage.openPage(TEXT_BOX_URL)
                .removeBanner()
                .setName(USER_EMAIL)
                .submitButtonClick()
                .containsRequiredCssValues("#userName");
    }

    @Test
    void InsertSqlInjectionIntoUserNameField_Test() {
        textBoxPage.openPage(TEXT_BOX_URL)
                .removeBanner()
                .setName(SQL_TEST)
                .submitButtonClick();
        verifyTextResultComponent.verifyOutputName(SQL_TEST);
    }
}