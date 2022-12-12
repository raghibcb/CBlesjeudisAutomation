package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import controllers.WebDriverFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;


public  class CommonUtils extends WebDriverFactory {
	
	static JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
	
	public static void verifyElementDisplayed(WebElement element) {
		try {
			Assert.assertTrue(element.isDisplayed());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Element not found: " + element);
		}
	}
	
	/**
	 * Verifies whether the element matching the provided locator is NOT displayed
	 * on page
	 *
	 * @param by
	 * @throws AssertionError the element matching the provided locator is displayed
	 */
	public static void verifyElementNotDisplayed(By by) {
		try {
			Assert.assertFalse(getWebDriver().findElement(by).isDisplayed(),
					"Element should not be visible: " + by);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/* To Drag and Drop from Source Locator to Destination Locator */
	public static void dragandDrop(WebElement Source, WebElement Destination) {

		ac = new Actions(getWebDriver());
	    ac.clickAndHold(Source).moveToElement(Destination).release(Source).perform();
	}

	/* To click a certain Web Element using DOM/ JavaScript Executor */
	public static void JSclick(WebElement element)
	{
		((JavascriptExecutor) getWebDriver()).executeScript("return arguments[0].click();", element);
	}

	/* Delete all file from directory */
	public static void cleanDirectory(String dirPath) throws IOException {
		File file = new File(System.getProperty("user.dir") + dirPath);
		if(file.exists()) {
			FileUtils.cleanDirectory(file);
		}
	}

	/* Verify file downloaded */
	public static void verifyFileDownloaded(String dirPath, String fileName) {
		System.out.println(dirPath+fileName);
		File file = new File(System.getProperty("user.dir") + dirPath +"\\"+ fileName);
		FluentWait wait = new FluentWait(getWebDriver()).withTimeout(60, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
		wait.until((webDriver) -> file.exists());
	}

	/************************************** Get File **********************************************************************/
	public static String getFileName(String dirPath)
	{
		File folder = new File(System.getProperty("user.dir")+dirPath);
		File[] listOfFiles = folder.listFiles();
		String fileName = null;

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				
				@SuppressWarnings("unused")
				String fileExtension = FilenameUtils.getExtension(listOfFiles[i].getName());
				fileName = listOfFiles[i].getName();
				}
		}
		System.out.println(fileName);
		return fileName;
	}

	/* Refresh Web Page */
	public static void refreshWebPage() {
		getWebDriver().navigate().refresh();
	}
	
	public static void saveFullPageScreenshot(String name) throws Exception {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(getWebDriver());
		ImageIO.write(screenshot.getImage(), "PNG", new File(name));
	}
}