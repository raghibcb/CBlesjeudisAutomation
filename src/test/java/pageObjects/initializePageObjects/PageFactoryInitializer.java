/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.CBLoginPageObjects;
import pageObjects.pages.LJMyProfilePageObject;
import pageObjects.pages.LJSignUpPageObjects;
import pageObjects.pages.TNHomePageObjects;




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
    
    public LJMyProfilePageObject ljMyProfilePage() {
        return PageFactory.initElements(getWebDriver(), LJMyProfilePageObject.class);
    }
}