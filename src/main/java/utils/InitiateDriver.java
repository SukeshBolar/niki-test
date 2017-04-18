package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class InitiateDriver {
    private RemoteWebDriver driver;
    private AppiumDriver appiumDriver;
    private HashMap<String,String> getProperties;

    public InitiateDriver()
    {
        try
        {
            getProperties = PropertyReader.getPropValues("config.properties");
            String runOn = System.getProperty("runOn") == null ? getProperties.get("RUN_ON") : System.getProperty("runOn");
            String platform = System.getProperty("platform") == null ? getProperties.get("PLATFORM") : System.getProperty("platform");
            String url = System.getProperty("url") == null ? getProperties.get("SELENIUMSERVERURL") : System.getProperty("url");
            String mUrl =System.getProperty("mUrl") == null ? getProperties.get("mURL") : System.getProperty("mUrl");
            String browser = null;

            if(platform.equalsIgnoreCase("WINDOWS"))
            {
                if (runOn.equalsIgnoreCase("WEBSITE"))
                {
                    browser = System.getProperty("browser") == null ? getProperties.get("BROWSER") : System.getProperty("browser");
                    System.out.println(url);
                    driver = new RemoteWebDriver(new URL(url), getBrowserCapabilities(browser, runOn));
                    System.out.println("Driver is: "+driver);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }
            }
            else if(platform.equalsIgnoreCase("ANDROID"))
            {
                if (runOn.equalsIgnoreCase("ANDROID_SITE"))
                {
                    browser = System.getProperty("mBrowser") == null ? getProperties.get("MOBILE_BROSWER") : System.getProperty("mBrowser");
                    appiumDriver = new AndroidDriver(new URL(mUrl), getBrowserCapabilities(browser, runOn));
                    appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }
                else if (runOn.equalsIgnoreCase("ANDROID_APP")) {
                    appiumDriver = new AndroidDriver(new URL(mUrl), getBrowserCapabilities(browser, runOn));
                    appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public RemoteWebDriver getDriver()
    {
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated");

        return driver;
    }

    public AppiumDriver getAppiumDriver()
    {
        if(appiumDriver==null)
            throw new RuntimeException("Driver has not been instantiated");

        return appiumDriver;
    }

    private DesiredCapabilities getBrowserCapabilities(String browser, String runOn)
    {
        DesiredCapabilities capabilities = null;
        String appName = System.getProperty("appName") == null ? getProperties.get("AppName") : System.getProperty("appName");
        String appPath =System.getProperty("appPath") == null ? getProperties.get("AppPath") : System.getProperty("appPath");

        try
        {
            if (runOn.equalsIgnoreCase("WEBSITE") && browser.equalsIgnoreCase("Firefox"))
            {
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setPlatform(Platform.ANY);
            }



            else if (runOn.equalsIgnoreCase("ANDROID_APP"))
            {

                capabilities=new DesiredCapabilities();
                capabilities.setCapability("deviceName", "Mi Phone");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appPackage", "com.techbins.niki.beta");
                capabilities.setCapability("appActivity", "com.techbins.niki.SplashActivity");
                capabilities.setCapability("--no-reset",true);
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,180);
            }

            else
            {
                // default is firefox
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.ANY);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return capabilities;
    }
}
