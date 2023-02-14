package automatizacionMT;

import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{
	
	By registerBtnLocator = By.linkText("REGISTER");
	
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.name("confirmPassword");
	
	By submitBtnLocator = By.name("submit");
	
	By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
	
	By registerMessage = By.cssSelector("font");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
		click(registerBtnLocator);
		Thread.sleep(2000);
		if(findElement(userNameLocator).isDisplayed()) {
			type("useradmin",userNameLocator);
			type("pass1",passwordLocator);
			type("pass1",confirmPasswordLocator);
			click(submitBtnLocator);
		}else {
			System.out.println("Register page was not found");
		}
	}
	public String registerMessage() {
		List<WebElement> fonts =  findElements(registerMessage);
		return getText(fonts.get(5));
	}
	
}
