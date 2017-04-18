package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by srinivasa on 18/04/17.
 */
public class Base {

    public static long wait=90;
    public static AndroidDriver appiumDriver;

    public static boolean isElementVisible(WebElement element)
    {
        try{
            if(element.isDisplayed())
                return true;
            return false;
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }

    }

    public static void waitForElementToBeInvisible(WebElement element)
    {
        WebDriverWait wwait = new WebDriverWait(appiumDriver,wait);
        wwait.until(invisibilityOfWebElementLocated(element));
    }

    public static void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wwait = new WebDriverWait(appiumDriver, wait);
        wwait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitUntilElementHasText(WebElement element, String text)
    {
        WebDriverWait wwait = new WebDriverWait(appiumDriver, wait);
        wwait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public static void clickOnElement(WebElement element){
        waitUntilElementIsVisible(element);
        element.click();
    }

    public static void enterTextInTextField(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    private static ExpectedCondition<Boolean> invisibilityOfWebElementLocated(final WebElement element)
    {
        return new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver driver) {
                try
                {
                    if (element.isDisplayed())
                        return false;
                    return true;
                }
                catch (Exception e)
                {
                    return true;
                }
            }
        };
    }

    public static boolean waitForPageToLoad(final String pageURL) {
        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, 45);
            return wait.until(new ExpectedCondition<Boolean>() {
                                  public Boolean apply(WebDriver d) {
                                      return (appiumDriver.getCurrentUrl().toLowerCase().contains(pageURL.toLowerCase())) && appiumDriver.executeScript("return document.readyState;").equals("complete");
                                  }
                              }
            );
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElement(WebElement element){

        JavascriptExecutor jse = (JavascriptExecutor) appiumDriver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
