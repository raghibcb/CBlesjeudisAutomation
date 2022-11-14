package tests;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Features;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;


public class Test1 extends PageFactoryInitializer
{
	@Description("To verify the Home Page Title")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void testCBLogin(String testCaseID,String emailID,String password) throws Exception
	{
		cbLoginPage().enterEmailID(emailID,password);
		cbLoginPage().switchWindow();
		cbLoginPage().outlookmailsend();
		
		
	tnHomePage().verifyPageTitle();
				
	}
}
