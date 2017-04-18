package phonenumberentry;

import base.TestBase;
import org.testng.annotations.Test;
import pages.Pages;

/**
 * Created by srinivasa on 18/04/17.
 */
public class PhoneNumberPageTest extends TestBase{
    @Test
    public void enterPhoneNumber() throws InterruptedException {
        String phoneNumber= registrationProperties.get("PHONENUMBER");
        org.testng.Assert.assertTrue(Pages.PhoneNumberPage().EnterPhoneNumber(phoneNumber),"User has successfully navigated to OTP Screen");
    }
}
