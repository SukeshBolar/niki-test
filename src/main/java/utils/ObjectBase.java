package utils;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by srinivasa on 18/04/17.
 */
public class ObjectBase {
    public ObjectBase(RemoteWebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
