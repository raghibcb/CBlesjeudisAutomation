
package pageObjects.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import controllers.BaseMethod;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TNHomePageObjects extends PageFactoryInitializer {
	
	BaseMethod base=new BaseMethod();

	@FindBy(xpath = "//app-root/div/app-homepage/cbd-searchbar/div/button")
	private WebElement SearchBarButton;

	@FindBy(xpath = "//span[contains(text(),'Search')]")
	private WebElement tnSearchButton;

	@FindBy(xpath = "//input[@name=\"keywords\"]")
	private WebElement keywordsField;

	@FindBy(xpath = "//span[contains(text(),'Search')]")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@name=\"location\"]")
	private WebElement locationField;

	@FindBy(xpath = "//*[@id=\"jobs-filters-content\"]//button[contains(text(),'Employee Type')]")
	private WebElement employeeTypeText;

	@FindBy(xpath = "//*[@id=\"jobs-filters-content\"]//button[contains(text(),'Date Posted')]")
	private WebElement datePosted;

	@FindBy(xpath = "//*[@id=\"jobs-filters-content\"]//button[contains(text(),'Distance')]")
	private WebElement distance;

	@FindBy(xpath = "//*[@id=\"jobs-filters-content\"]//button[contains(text(),'Location')]")
	private WebElement location;

	@FindBy(xpath = "//*[@id=\"jdp-data\"]//*[contains(text(),'Job Details')]")
	private WebElement jobDetailsTab;

	@FindBy(xpath = "//h3[contains(text(),'Recommended Skills')]")
	private WebElement recommendedSkills;

	@FindBy(id = "jobs_collection")
	private WebElement OuterCardFirstJob;
	
	@FindBy(xpath="//*[@class=\"data-results-content block job-listing-item\"]")
	private List<WebElement>OuterFeedscards;

	@FindBy(xpath = "//*[contains(@class,'data-results-content-parent relative active')]")
	private WebElement firstOuterCard;
	
	@FindBy(xpath = "//button[contains(text(),'Job Type')]")
	private WebElement jobType;

	@FindBy(xpath = "//button[contains(text(),'Full Time')]")
	private WebElement fullTimeType;

	@FindBy(xpath = "//button[@aria-label='Date posted filter']")
	private WebElement daysType;

	@FindBy(xpath = "//button[@aria-label='Employee Type Filter']")
	private WebElement EmployeeTypeFilter;

	@FindBy(xpath = "//button[@aria-label='Location filter']")
	private WebElement locationFilter;
	
	@FindBy(xpath="//*[contains(text(),'Job Type')]")
	private WebElement jobTypeText;
	
	@FindBy(xpath="//*[contains(text(),'Experience')]")
	private WebElement expirenceText;
	
	@FindBy(xpath = "//div[contains(@id,'job-count')]")
	private WebElement job_Count;
	
	@FindBy(xpath="//a[contains(text(),'Join Talent Network')]")
	private WebElement joinTNLink;
	
	@FindBy(xpath="//input[@id='location_free_text_custom_questions_JQFT25X29QYRQCH3707Q']")
	private WebElement cityStateField;
	
	@FindBy(xpath="//div[@class=\"footer-bloc\"]")
	private WebElement footerBlock;

	public WebElement SelectEmployeeType(String employeeType) throws InterruptedException {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(EmployeeTypeFilter, 60);
		base.mousehover(EmployeeTypeFilter);
		WebElement element = getWebDriver().findElement(By.xpath("//div//label[contains(text(),'" + employeeType + "')]"));
		element.click();
		Thread.sleep(20000);
		return element;
	}

	public WebElement selectLocation(String location) throws InterruptedException {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(locationFilter, 60);
		base.mousehover(locationFilter);
		WebElement element = getWebDriver().findElement(By.xpath("//div//label[contains(text(),'" + location + "')]"));
		element.click();
		Thread.sleep(20000);
		return element;
	}
	
	public WebElement selectPostedDate(String days) throws InterruptedException {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(daysType, 60);
		base.mousehover(daysType);
		WebElement element = getWebDriver().findElement(By.xpath("//div//label[contains(text(),'" + days + "')]"));
		element.click();
		Thread.sleep(20000);
		// days_3.click();
		return element;
	}

	public TNHomePageObjects verifyJobDispalyAfterApplyAllFilter() {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(job_Count, 60);
		job_Count.isDisplayed();
		return this;
	}

	public TNHomePageObjects clickFirstJobAndVeriFyJdpPage() throws Exception {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(OuterCardFirstJob, 90);
		Thread.sleep(10000);
		String selectOuterFeeedOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		OuterFeedscards.get(0).sendKeys(selectOuterFeeedOpeninNewTab);
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<String>(getWebDriver().getWindowHandles());
		getWebDriver().switchTo().window(tabs.get(1));
		String currentUrl = getWebDriver().getCurrentUrl();
		System.out.println(currentUrl);
		return this;
	}

	public TNHomePageObjects VerifyTnJrpPage() throws Exception {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(OuterCardFirstJob, 90);
		Thread.sleep(10000);
		employeeTypeText.isDisplayed();
		datePosted.isDisplayed();
		distance.isDisplayed();
		location.isDisplayed();
		jobDetailsTab.isDisplayed();
		utils.ScrollUtils.scrollToElement(recommendedSkills);
		jobTypeText.isDisplayed();
		expirenceText.isDisplayed();

		return this;
	}

	public TNHomePageObjects enterKeywordAndLocation(String keyword, String location) throws Exception {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(keywordsField, 90);
		keywordsField.sendKeys(keyword);
		locationField.sendKeys(location);
		return this;
	}

	public TNHomePageObjects clickOnSearchButton() throws Exception {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(searchButton, 90);
		searchButton.click();
		return this;
	}

	public TNHomePageObjects verifyTalentNetWorkPageTitle() throws Exception {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(tnSearchButton, 10);
		Assert.assertEquals(getWebDriver().getTitle(), "Find a Job | QA TNV3 Full (Do not Modify)");
		return this;
	}

	public TNHomePageObjects verifyPageTitle() throws Exception {
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(SearchBarButton, 10);
		Assert.assertEquals(getWebDriver().getTitle(), "Homepage");
		return this;
	}
	
	public TNHomePageObjects scrollToRecommededSkills() throws Exception

	{

		utils.ScrollUtils.scrollToElement(recommendedSkills);
		recommendedSkills.isDisplayed();

		return this;
	}
	
	public TNHomePageObjects verifyFooter(String link1,String link2)
	{   utils.ScrollUtils.scrollToBottom();
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-bloc\"]//span[contains(text(),'"+link1+"')]")).isDisplayed();
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-bloc\"]//span[contains(text(),'"+link2+"')]")).isDisplayed();
		return this;
	}
	
	public TNHomePageObjects verifyFooterLinks(String link1,String link2,String link3,String link4,String link5)
	{  
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-collapse\"]//a[contains(text(),'"+link1+"')]")).isDisplayed();
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-collapse\"]//a[contains(text(),'"+link2+"')]")).isDisplayed();
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-collapse\"]//a[contains(text(),'"+link3+"')]")).isDisplayed();
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-collapse\"]//a[contains(text(),'"+link4+"')]")).isDisplayed();
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-collapse\"]//a[contains(text(),'"+link5+"')]")).isDisplayed();
		return this;
	}
	
	public TNHomePageObjects clickOnJobsLink(String link1)
	{  
		getWebDriver().findElement(By.xpath("//div[@class=\"footer-collapse\"]//a[contains(text(),'"+link1+"')]")).click();
 
		return this;
	}
	
	public TNHomePageObjects verifyFooterBrokenLinks() throws InterruptedException
	{   int allFooterLinksno=footerBlock.findElements(By.tagName("a")).size();
		 
		  List<WebElement> footlinks = footerBlock.findElements(By.tagName("a"));
		  for(WebElement ele:footlinks)
		  {
			  System.out.println(ele.getText());
		  }
		 // int i = footer.findElements(By.tagName("a")).size(); //Get number of links
		  int i=footerBlock.findElements(By.tagName("a")).size();//Get number of links

		  for(int j =i-1;j>=0;j--){    //create loop based upon number of links to traverse all links
			  //footerBlock= getWebDriver().findElement(By.xpath("//div[@class=\"footer-bloc\"]"));   // We are re-creating "footer" webelement as DOM changes after navigate.back()
			  System.out.println(footerBlock.findElements(By.tagName("a")).get(j).getText());
			  footerBlock.findElements(By.tagName("a")).get(j).click();
		      Thread.sleep(8000);
		   System.out.println(getWebDriver().getTitle());
		      if(getWebDriver().getTitle().contains("404")) {
		       System.out.println("404 Found");
		      }
		      try {
		      getWebDriver().navigate().back();
		      }
		      catch(Exception e)
		      {
		    	  getWebDriver().navigate().forward();;  
		      }
		      utils.ScrollUtils.scrollToBottom();
		   Thread.sleep(8000);
		  }
		return this;
	}
	

}
