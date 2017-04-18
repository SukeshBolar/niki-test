package completeregistrationpage;

import utils.Base;

/**
 * Created by srinivasa on 18/04/17.
 */
public class CompleteRegistrationPage extends Base{
    private static CompleteRegistrationPageRepo crpr;
    public CompleteRegistrationPage() {
        crpr=new CompleteRegistrationPageRepo(appiumDriver);
    }

    public static boolean EnterRegistrationDetails(String name) throws InterruptedException {
        Thread.sleep(5000);
        //Enter name
        waitUntilElementIsVisible(crpr.nameTextField);
        enterTextInTextField(crpr.nameTextField,name);

        //Select already configured email id
        boolean emailconfigured = selectEmailID();
        if(emailconfigured==true){
            System.out.println("Application has selected one of the configured email id from the device.");
            Thread.sleep(2000);
            System.out.println("Sending application to background to fetch OTP");
        }
        return true;
    }

    public static boolean selectEmailID(){
        //selecting already configured email id. Note: Condition for adding an account isn't handled

        clickOnElement(crpr.emailIDTextField);
        //If there are multiple email id configured then application will take first email id, if there is only one email id configured then directly it takes configured email id.
        try{
            int emailIDConfigured = crpr.accountList.size();
            if(emailIDConfigured>1){
                //Clicking on first configured email id
                crpr.accountList.get(0).click();
                clickOnElement(crpr.dialogBoxOKButton);
            }

        }catch (Exception e){

        }
        appiumDriver.startActivity("com.android.mms","com.android.mms.ui.ConversationList");
        sleep(10000);
        //Read OTP
        String otp = ReadOTP();
        appiumDriver.navigate().back();
        clickOnElement(crpr.otpButton);
        enterTextInTextField(crpr.otpButton,otp);
        SignUP();

        return true;


    }

    public static String ReadOTP(){
        String otp=null;
        waitUntilElementIsVisible(crpr.messengerText);
        String bodyText = crpr.messageText.getText();

        if(bodyText.matches("Notifications")){
            String bodyMessage=crpr.bodyMessage.getText();
            otp=bodyMessage.substring(14,18).toString();
        }
        return otp;
    }

    public static void SignUP(){
        //Close the keyboard
        appiumDriver.navigate().back();
        clickOnElement(crpr.signUpButton);

    }

}
