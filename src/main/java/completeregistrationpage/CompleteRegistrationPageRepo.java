package completeregistrationpage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ObjectBase;

import java.util.List;

/**
 * Created by srinivasa on 18/04/17.
 */
public class CompleteRegistrationPageRepo extends ObjectBase{
    public CompleteRegistrationPageRepo(AppiumDriver appiumDriver){ super(appiumDriver);}

    @FindBy(id ="editTxtName")
    protected static WebElement nameTextField;

    @FindBy(id ="editTxtEmail")
    protected static WebElement emailIDTextField;

    @FindBy(id ="editTxtOtp")
    protected static WebElement otpButton;

    @FindBy(id ="button1")
    protected static WebElement dialogBoxOKButton;

    @FindBy(id ="btnSubmit")
    protected static WebElement signUpButton;

    @FindBy(id ="text1")
    protected static List<WebElement> accountList;  //editTxtOtp

    @FindBy(xpath ="//android.widget.TextView[@index='0']")
    protected static WebElement messengerText;


    @FindBy(xpath ="//android.widget.TextView[@index='2']")
    protected static WebElement bodyMessage;

    @FindBy(xpath ="//android.widget.TextView[@index='1']")
    protected static WebElement messageText;



}
