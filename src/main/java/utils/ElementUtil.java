package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class ElementUtil {

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return webElement;
	}

	public void clickElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void enterTextIntoTextBox(WebElement element, long durationInSeconds, String text) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.clear();
		webElement.sendKeys(text);

	}
	
	public void selectDropDownOptions(WebElement element,long durationInSeconds,String option) {
		WebElement webElement=waitForElement(element, durationInSeconds);
		Select select= new Select(webElement);
		select.selectByVisibleText(option);
	}
	
	public Alert verifyAlertPresent(long durationInSeconds) {
		WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(durationInSeconds));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	
	public void acceptAlert() {
		Alert alert=verifyAlertPresent(10);
		alert.accept();
	}
	
	public void dismissAlert() {
		Alert alert=verifyAlertPresent(10);
		alert.dismiss();
	}
	
	public void moveToElement(WebElement element,long durationInSeconds) {
		WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(durationInSeconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		Actions action= new Actions(DriverFactory.getDriver());
		action.moveToElement(webElement).build().perform();
	}
	
	public void javaScriptClick(WebElement element,long durationInseconds) {
		WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(durationInseconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor jse = ((JavascriptExecutor)DriverFactory.getDriver());
		jse.executeScript("arguements[0].click()", webElement);
	}
	
	public void javaScriptType(WebElement element,long durationInseconds,String text) {
		WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(durationInseconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor jse = ((JavascriptExecutor)DriverFactory.getDriver());
		jse.executeScript("arguements[0].value=text", webElement);
	}
}
