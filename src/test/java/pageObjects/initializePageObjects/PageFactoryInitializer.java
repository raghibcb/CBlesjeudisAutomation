/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.TNHomePageObjects;
import pageObjects.pages.CBLoginPageObjects;
import pageObjects.pages.LJSignUpPageObjects;




public class PageFactoryInitializer extends BaseMethod {
    public TNHomePageObjects tnHomePage() {
        return PageFactory.initElements(getWebDriver(), TNHomePageObjects.class);
    }

    public CBLoginPageObjects cbLoginPage() {
        return PageFactory.initElements(getWebDriver(), CBLoginPageObjects.class);
    }
    
    public LJSignUpPageObjects ljSignUpPage() {
        return PageFactory.initElements(getWebDriver(), LJSignUpPageObjects.class);
    }
}