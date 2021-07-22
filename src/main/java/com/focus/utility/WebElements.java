package com.focus.utility;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.focus.base.BasePage;


public class WebElements extends BasePage{
	JavascriptExecutor js;
	WebElement element;
	
	public WebElements(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public void sendKey(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public Boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void scrollPageDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollPageUp() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
	public void scrollIntoView(By locator) {
		js = (JavascriptExecutor) driver;
		element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public WebElement visibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public List<WebElement> findElements(By locator){
		List<WebElement> element = driver.findElements(locator);
		return element;	
	}
	
	public Boolean waitForElementBoolean(By locator, String text, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.textToBe(locator, text));
	}
	
	public String waitForElementString(By locator, String text, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.textToBe(locator, text));
		return text;
	}
	
	public void waitForElementToBeClickable(By locator, String text, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
}