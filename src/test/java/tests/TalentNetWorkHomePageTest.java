package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TalentNetWorkHomePageTest extends PageFactoryInitializer {
	@Description("To verify Talent Network Home Page Title")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void cbTalentNetwokJobSearch(String testCaseID,String emailID,String password) throws Exception
	{
		 tnHomePage().verifyTalentNetWorkPageTitle();
		 //tnHomePage().verifyFooterBrokenLinks();
		 
				
	}
	
	@Description("Searching a Job with Title"+"Checking JRP Page"+"Checking JDP Page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void cbTalentNetwokJobSearchAndJrpPage(String testCaseID,String keyword,String location) throws Exception
	{
		 tnHomePage().verifyTalentNetWorkPageTitle();
		 tnHomePage().enterKeywordAndLocation(keyword,location);
		 tnHomePage().clickOnSearchButton();
		 tnHomePage().VerifyTnJrpPage();
		 tnHomePage().clickFirstJobAndVeriFyJdpPage();			
	}
	
	@Description("Searching a Job with Title"+"Checking JRP Page"+"Checking JDP Page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void tnVerifyFilterAndFooter(String testCaseID,String keyword,String location,String days,String jobLocation,String employeeType,String link,String link0,String link1,String link2,String link3,String link4,String link5) throws Exception
	{
		 tnHomePage().verifyTalentNetWorkPageTitle();
		 tnHomePage().enterKeywordAndLocation(keyword,location);
		 tnHomePage().clickOnSearchButton();
		 tnHomePage().selectPostedDate(days);
		 tnHomePage().selectLocation(jobLocation);
		 tnHomePage().SelectEmployeeType(employeeType);
		 tnHomePage().verifyJobDispalyAfterApplyAllFilter();
		 tnHomePage().verifyFooter(link,link0);
		 tnHomePage().verifyFooterLinks(link1,link2,link3,link4,link5);
		 tnHomePage().clickOnJobsLink(link1);
		 tnHomePage().VerifyTnJrpPage();
		 
		 		
	}
}
