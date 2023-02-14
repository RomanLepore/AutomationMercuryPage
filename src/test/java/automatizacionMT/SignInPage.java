package automatizacionMT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends Base{

	By userNameLocator = By.name("userName");
	By passwordLocator = By.name("password");
	By submitBtnLocator = By.name("submit");
	
	By signInMessage = By.cssSelector("h3");
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void signInUser() {
		if(isDisplayed(userNameLocator)) {
			type("useradmin",userNameLocator);
			type("pass1",passwordLocator);
			click(submitBtnLocator);
		}else {
			System.out.println("Sign In page was not found ");
		}
	}
	public String signInMessage() {
		List<WebElement> h3  =  findElements(signInMessage);
		return getText(h3.get(0));
	}
}
