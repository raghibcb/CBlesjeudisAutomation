package controllers;

import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * @Author Gladson Antony
 * @Date 30-DEC-2018
 */

public class WebDriverFactory extends BrowserFactory
{
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	public static String browser;
	public static String url;

	@BeforeTest(alwaysRun=true)
	public void suiteSetup() throws Exception
	{	
		cleanDirectory();
		switch(Browser.toLowerCase())
		{
		case "chrome":
		case "chrome_headless":
			WebDriverManager.chromedriver().setup();

		case "opera":
			WebDriverManager.operadriver().setup();
			break;

		case  "firefox":
		case "firefox_headless":
			WebDriverManager.firefoxdriver().arch64().setup();
			break;

		case  "ie":
		case "internet explorer":
			WebDriverManager.iedriver().setup();
			break;	

		case  "edge":
			WebDriverManager.edgedriver().setup();
			break;

		case "ghost":
		case "phantom":
			WebDriverManager.phantomjs().setup();
			break;

		default:
			throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
		}
	}

	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		System.out.println("Browser: "+Browser);
		System.out.println("WebsiteURL: "+WebsiteURL);
		new WebDriverFactory();
		WebDriver driver = WebDriverFactory.createDriver();
		setWebDriver(driver);
		driver.get(WebsiteURL);
		//Before driver.get(WebsiteURL);
		if(VideoFeature.toLowerCase().contains("enabledfailed"))
		{
			setupVideoRecordingFailedOnly();
		}
		else if(VideoFeature.toLowerCase().contains("enabledall"))
		{
			setupVideoRecordingAll();
		}
	}
	
	public void setupVideoRecordingFailedOnly() throws Exception
	{
		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Videos")     					// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.FAILED_ONLY)     		// Save videos ONLY FAILED tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;								// Record video only for tests with @Video
	}
	
	public void setupVideoRecordingAll() throws Exception
	{
		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Videos")     					// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.ALL)     						// Save videos All tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;								// Record video only for tests with @Video
	}
	
	public void cleanDirectory() throws Exception{
		File directory = new File("./src/test/resources/Reports/Images/");
		File[] files = directory.listFiles();
		
		for (File file : files){
			System.out.println(file.getName());
			if(!file.getName().endsWith(".txt")) {
				if(file.isDirectory()) {
					FileUtils.deleteDirectory(file);
				}
				file.delete();				
			}
		} 
	}
	
	public void setWebDriver(WebDriver driver) 
	{
		wd.set(driver);
	}

	public static WebDriver getWebDriver() 
	{
		return wd.get();
	}
	
	public static void saveFullPageScreenshot(String name) throws Exception {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(getWebDriver());
		ImageIO.write(screenshot.getImage(), "PNG", new File(name));
	}
	
	public static void saveFullPageMultiPleScreenshot(String name) throws Exception {
		 File screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File(name));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}

	@AfterMethod(alwaysRun=true,enabled=true)
	public void afterMethod(ITestResult result) throws Exception
	{
		Thread.sleep(2000);
		if (result.getStatus() == ITestResult.FAILURE) {
			saveFullPageScreenshot("./src/test/resources/Reports/Images/" + result.getTestClass().getName() + "."
					+ result.getMethod().getMethodName() + ".png");
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			saveFullPageScreenshot("./src/test/resources/Reports/Images/" + result.getTestClass().getName() + "."
					+ result.getMethod().getMethodName() + ".png");
		}
		if (result.getStatus() == ITestResult.SKIP) {
			saveFullPageScreenshot("./src/test/resources/Reports/Images/" + result.getTestClass().getName() + "."
					+ result.getMethod().getMethodName() + ".png");
		}
		getWebDriver().quit();
	}
}
