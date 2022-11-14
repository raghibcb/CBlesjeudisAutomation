/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.TNHomePageObjects;
import pageObjects.pages.CBLoginPageObjects;




public class PageFactoryInitializer extends BaseMethod {
    public TNHomePageObjects tnHomePage() {
        return PageFactory.initElements(getWebDriver(), TNHomePageObjects.class);
    }

    public CBLoginPageObjects cbLoginPage() {
        return PageFactory.initElements(getWebDriver(), CBLoginPageObjects.class);
    }
}