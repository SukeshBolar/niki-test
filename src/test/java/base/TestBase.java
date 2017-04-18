package base;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeSuite;

import utils.Base;
import utils.InitiateDriver;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by srinivasa on 18/04/17.
 */
public class TestBase {

    protected AndroidDriver appiumDriver;
    public static HashMap<String,String> configProperties;
    public static HashMap<String,String> registrationProperties;


    public TestBase(){
        configProperties = PropertyReader.getPropValues("config.properties");
        registrationProperties= PropertyReader.getPropValues("registration.properties");

    }

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        String url = configProperties.get("mURL");
        InitiateDriver initiateDriver = new InitiateDriver();
        appiumDriver= (AndroidDriver) initiateDriver.getAppiumDriver();
        appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Base.appiumDriver=appiumDriver;
        appiumDriver.get(url);

    }
}
