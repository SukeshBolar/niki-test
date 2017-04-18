package phonenumberpage;

import utils.Base;

/**
 * Created by srinivasa on 18/04/17.
 */
public class PhoneNumberPage extends Base {
    private static PhoneNumberPageRepo pnpr;
    public PhoneNumberPage() {
        pnpr=new PhoneNumberPageRepo(appiumDriver);
    }

    public static boolean EnterPhoneNumber(String phoneNumber) throws InterruptedException {
        //Enter phonenumber
        waitUntilElementIsVisible(pnpr.phoneNumberTextfield);
        enterTextInTextField(pnpr.phoneNumberTextfield,phoneNumber);
        Thread.sleep(2000);
        //Click on submit button
        clickOnElement(pnpr.submitButton);
        return true;

    }
}
