package pages;

import completeregistrationpage.CompleteRegistrationPage;
import phonenumberpage.PhoneNumberPage;
import utils.Base;

/**
 * Created by srinivasa on 18/04/17.
 */
public class Pages {
    private static <T extends Base> T getPage(Class<T> pageType)  {
        T page;
        try {
            page = pageType.newInstance();
        } catch (InstantiationException e) { //make sure you use JDK 1.7
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return page;
    }

    public static PhoneNumberPage PhoneNumberPage(){return getPage(PhoneNumberPage.class);}
    public static CompleteRegistrationPage CompleteRegistrationPage(){return getPage(CompleteRegistrationPage.class);}

}
