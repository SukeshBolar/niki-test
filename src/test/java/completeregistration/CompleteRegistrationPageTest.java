package completeregistration;

import base.TestBase;
import org.testng.annotations.Test;
import pages.Pages;

/**
 * Created by srinivasa on 18/04/17.
 */
public class CompleteRegistrationPageTest extends TestBase {
    @Test
    public void signUP() throws InterruptedException {
        String name= registrationProperties.get("NAME");
        org.testng.Assert.assertTrue(Pages.CompleteRegistrationPage().EnterRegistrationDetails(name),"User has successfully navigated to OTP Screen");
    }
}
