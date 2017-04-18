package phonenumberpage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ObjectBase;

/**
 * Created by srinivasa on 18/04/17.
 */
public class PhoneNumberPageRepo extends ObjectBase{
    public PhoneNumberPageRepo(AppiumDriver appiumDriver){ super(appiumDriver);}

    @FindBy(id ="edtTxtPhone")
    protected static WebElement phoneNumberTextfield;

    @FindBy(id ="btnSubmit")
    protected static WebElement submitButton;

}
