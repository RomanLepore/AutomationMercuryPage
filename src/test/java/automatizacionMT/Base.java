package automatizacionMT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	// THIS METHOD SET CHROME DRIVER CONNECTION
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	public void windowMaximize() {
		 driver.manage().window().maximize();
	}
	// THIS METHOD SEARCH THE ELEMENT BY LOCATOR
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public void click(WebElement element) {
		element.click();
	}
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	public void visit(String url) {
		driver.get(url);
	}
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	public String getText(By locator){
		return driver.findElement(locator).getText();
	}
	
	
	public String getText(WebElement element) {
		return element.getText();
	}
}
