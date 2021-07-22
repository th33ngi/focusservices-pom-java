package com.focus.page;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.focus.base.BasePage;
import com.focus.utility.WebElements;

public class FocusPage extends BasePage {
	WebElements webElement;
	List<WebElement> elements;
	
	public FocusPage (WebDriver driver) {
		super(driver);
		webElement = new WebElements(driver);
	}
	
	//Page locator
	By spanButton = By.xpath("//span[contains(text(),'Now Hiring!')]");
	By footerSpan = By.xpath("//span[contains(text(),'© Copyright 2019 - Focus Services ')]");
	By spanLink = By.linkText("Locations");
	By h1Span = By.xpath("//h1[contains(text(),'CONTACT CENTERS AROUND THE GLOBE')]");
	By aTagName = By.tagName("a");
	By spanNorthAmerica = By.xpath("//a//span[contains(text(),'North America')]");
	By spanCentralAmerica = By.xpath("//a//span[contains(text(),'Central America')]");
	By spanSalvadorNica = By.xpath("//h2[contains(text(),'El Salvador & Nicaragua')]");
	By spanAsia = By.xpath("//a//span[contains(text(),'Asia')]");
	By h3bSpan = By.xpath("//h3/b[contains(text(),'Bacolod City, Philippines')]");
	
	public String getFocusPageTitle() {
		return webElement.getPageTitle();
	}
	
	public Boolean scrollDownFocusPage() {
		webElement.scrollPageDown();
		return webElement.isDisplayed(footerSpan);
	}
	
	public Boolean isNowHiringButton() {
		return webElement.isDisplayed(spanButton);
	}
	
	public Boolean getLocationTab() {
		webElement.scrollPageUp();
		webElement.click(spanLink);
		return webElement.isDisplayed(h1Span);
	}
	
	public String getNorthAmericaUrl() {
		webElement.click(spanNorthAmerica);
		return webElement.getCurrentUrl();
	}
	
	public String getCentralAmericaPage() {
		webElement.click(spanCentralAmerica);
		return webElement.getCurrentUrl();
	}
	
	public Boolean isElSalvadorNicaraguaTitle(){
		return webElement.isDisplayed(spanSalvadorNica);
	}
	
	public String getAsiaPage() {
		webElement.click(spanAsia);
		return webElement.getCurrentUrl();
	}
	
	public Boolean isBacolodCityPhilippinesBlock(){
		return webElement.isDisplayed(h3bSpan);
	}
}
