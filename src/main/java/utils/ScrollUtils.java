package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import controllers.BaseMethod;

public class ScrollUtils extends BaseMethod  {


	//static JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
	
	/** To scroll till bottom */
	public static void scrollToBottom()	{
		((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	
	/** To scroll till Element */
	public static void scrollToElement(WebElement element) {
		((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

	/** To scroll to top */
    public static void scrollToTop(){
    	((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0,0);");
    }

    /** To scroll by pixel */
    public static void scrollByPixel(int pixel){
    	((JavascriptExecutor) getWebDriver()).executeScript("window.scrollBy(0,'"+pixel+"')");
    }

    /** To scroll horizontally till element */
    public static void scrollHorizontallyToElement(WebElement element){
    	((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

}
