package stepDefinitions;

import commons.AbstractPage;
import commons.AbstractTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
//import cucumberOptions.Hooks;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.HomePO;
import pageObjects.LoginPO;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


@RunWith(Cucumber.class)
public class RegisterAndLoginSteps {
    AndroidDriver driver;
    AbstractPage abstractPage;
    LoginPO loginPage;
    HomePO homePage;
    String appTest;

    String packageApp, passCode, defaultCode;

    public RegisterAndLoginSteps(AndroidDriver driver) {
        this.driver = driver;
        passCode = "7620";
        defaultCode = "2304";
        abstractPage = new AbstractPage(driver);
        loginPage = new LoginPO(driver);
        homePage = new HomePO(driver);

        abstractPage.sendAppPackage();
    }

    @Given("^I open the \"([^\"]*)\" Pax app for the first time$")
    public void iOpenThePaxAppForTheFirstTime(String appName) {
        if(appName.equalsIgnoreCase("mycar")){
            packageApp = "com.mycar.passenger";
        }else if(appName.equalsIgnoreCase("pegasus")){
            packageApp = "com.qupworld.pegasuspax";
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "HT69H0201382");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", packageApp);
        cap.setCapability("appActivity", "com.qup.pegasus.ui.launch.LauncherActivity");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("skipDeviceInitialization", "false");
        cap.setCapability("skipServerInstallation", "false");
        cap.setCapability("noReset", "false");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @When("^I select the phone code by \"([^\"]*)\" country if different$")
    public void iSelectThePhoneCodeByCountryIfDifferent(String countryName) {
        loginPage.selectPhoneCode(countryName);
    }

    @Then("^I verify the passenger register successfully$")
    public void iVerifyThePassengerRegisterSuccessfully() {
        loginPage.clickToSkipButton();
        loginPage.clickToYesNoButton("Yes");
        assertTrue(loginPage.isThereHomeButtonPresent());
    }

    @And("^I select \"([^\"]*)\" server and input \"([^\"]*)\" fleet code$")
    public void iSelectServerAndInputFleetCode(String server, String fleetCode) {
        loginPage.clickToPhoneNumberTextbox();
        loginPage.longPressToDebugArea();
        loginPage.inputToPassCodeTextbox(passCode);
        loginPage.clickToYesNoButton("YES");
        loginPage.selectServer(server, fleetCode);
        assertTrue(loginPage.isLoginPagePresent());
    }

    @Given("^I click to phone number text box$")
    public void iClickToPhoneNumberTextBox() {
        loginPage.clickToPhoneNumberTextbox();
    }

    @And("^I input phone number \"([^\"]*)\"$")
    public void iInputPhoneNumber(String phoneNumber) {
        loginPage.inputToPhoneNumberTextbox(phoneNumber);
    }


    @And("^I agree with Term of use and Privacy policy$")
    public void iAgreeWithTermOfUseAndPrivacyPolicy() {
        loginPage.clickToAgreeToUAndPolicy();
    }

    @And("^I click to continue button$")
    public void iClickToContinueButton() {
        loginPage.clickToLoginButton();
        loginPage.clickToYesNoButton("Yes");
    }

    @And("^I input sms verify code if have$")
    public void iInputSmsVerifyCodeIfHave(){
        loginPage.inputSMSDefaultCode(defaultCode);
    }

    @And("^I verify register message contains \"([^\"]*)\"$")
    public void iVerifyRegisterMessageContains(String textContains) {
        assertTrue(loginPage.isWelcomeMsgContains(textContains));
        loginPage.clickToYesNoButton("OK");
    }

    @And("^I input user information to register$")
    public void iInputUserInformationToRegister(DataTable customerTable) {
        List<Map<String, String>> customer = customerTable.asMaps(String.class, String.class);
        loginPage.inputToRegisterTextboxes("First name", customer.get(0).get("firstName"));
        loginPage.inputToRegisterTextboxes("Last name", customer.get(0).get("lastName"));
        loginPage.selectGender(customer.get(0).get("gender"));
    }

    @And("^I click to save button$")
    public void iClickToSaveButton() {
        loginPage.clickToSaveButton();
    }

    @Then("^I verify the passenger login successfully$")
    public void iVerifyThePassengerLoginSuccessfully() {
        assertTrue(loginPage.isThereHomeButtonPresent());
    }

    @And("^I logout of the account$")
    public void iLogoutOfTheAccount() {
        homePage.logout();
    }
}