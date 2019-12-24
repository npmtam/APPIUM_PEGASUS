package pageObjects;

import commons.AbstractPage;
import io.appium.java_client.android.AndroidDriver;
import interfaces.LoginPageUI;

public class LoginPO extends AbstractPage {
    private AbstractPage abstractPage;
    private LoginPageUI loginPageUI;

    public LoginPO(AndroidDriver driver) {
        super(driver);
    }

    public void inputToFleetCodeDefault(String fleetCode) {
        sendKeyToElementById(loginPageUI.FLEET_CODE_TEXTBOX_DEFAULT, fleetCode);
    }

    public void clickToPhoneNumberTextbox() {
        sleepInSecond(1);
        clickToElementById(loginPageUI.PHONE_NUMBER_TEXTBOX_1ST_SCREEN);
    }

    public void longPressToDebugArea() {
        longPressToElementByXpath(loginPageUI.DEBUG_AREA);
    }

    public void inputToPassCodeTextbox(String passCode) {
        sendKeyToElementById(loginPageUI.PASS_CODE_TEXTBOX, passCode);
    }

    public void clickToYesNoButton(String yesNoValue) {
        clickToElementByXpath(loginPageUI.YES_NO_BUTTON, yesNoValue);
    }

    public void selectServer(String server, String fleetCode) {
        if (server.equalsIgnoreCase("local")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "Local");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else if (server.equalsIgnoreCase("lab")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "Lab");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else if (server.equalsIgnoreCase("beta")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "Beta");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else if (server.equalsIgnoreCase("us")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "QUp");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else if (server.equalsIgnoreCase("asap")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "ASAP");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else if (server.equalsIgnoreCase("avis")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "Avis");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else if (server.equalsIgnoreCase("sea")) {
            clickToElementByXpath(loginPageUI.DYNAMIC_SERVERS_TAB, "Sea");
            sendKeyToElementById(loginPageUI.FLEET_ID_TEXTBOX, fleetCode);
            clickToElementById(loginPageUI.APPLY_BUTTON);
        } else {
            System.out.println("Please enter the server that you want to test");
        }
    }

    public void inputToPhoneNumberTextbox(String phoneNumber) {
        sendKeyToElementById(loginPageUI.PHONE_NUMBER_TEXTBOX_LOGIN, phoneNumber);
    }

    public void clickToAgreeToUAndPolicy() {
        clickToElementById(loginPageUI.TERM_OF_USE_PRIVACY_POLICY_CHECKBOX);
    }

    public void clickToLoginButton() {
        clickToElementById(loginPageUI.LOGIN_BUTTON);
    }

    public void inputSMSDefaultCode(String smsCode) {
        if (checkElementPresentById(loginPageUI.SMS_DEFAULT_TEXBOX) == true) {
            sendKeyToElementById(loginPageUI.SMS_DEFAULT_TEXBOX, smsCode);
        }
    }

    public boolean isThereHomeButtonPresent() {
        return checkElementPresentById(loginPageUI.HOME_BUTTON);
    }

    public boolean isLoginPagePresent(){
        return checkElementPresentById(loginPageUI.TERM_OF_USE_PRIVACY_POLICY_CHECKBOX);
    }

    public boolean isWelcomeMsgContains(String expectedText){
        return isMessageContainsById(loginPageUI.WELCOME_MESSAGE, expectedText);
    }

    public void selectPhoneCode(String countryName){
        clickToElementById(loginPageUI.SELECT_PHONE_CODE_BUTTON);
        sendKeyToElementById(loginPageUI.SEARCH_COUNTRY_PHONE_TEXTBOX, countryName);
        clickToElementByXpath(loginPageUI.COUNTRY_PHONE_CODE, countryName);
    }

    public void inputToRegisterTextboxes(String nameField, String textValue){
        checkElementPresentByXpath(loginPageUI.REGISTER_TEXTBOXES, nameField);
        sendKeyToElementByXpath(loginPageUI.REGISTER_TEXTBOXES, textValue, nameField);
    }

    public void selectGender(String genderValue){
        checkElementPresentByXpath(loginPageUI.REGISTER_TEXTBOXES, "Gender");
        clickToElementByXpath(loginPageUI.REGISTER_TEXTBOXES, "Gender");
        clickToElementByXpath(loginPageUI.GENDER_BUTTONS, genderValue);
    }

    public void clickToSaveButton(){
        clickToElementById(loginPageUI.SAVE_BUTTON);
    }

    public void clickToSkipButton(){
        clickToElementById(loginPageUI.SKIP_BUTTON);
    }

}
