package automatizacionMT;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignInTest {

	private WebDriver driver;
	SignInPage signInPage;
	
	@Before
	public void setUp() {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("https://demo.guru99.com/test/newtours/index.php");
	}
	@Test
	public void test() {
		signInPage.signInUser();
		assertEquals("Login Successfully",signInPage.signInMessage());
	}
	@After
	public void tearDown() {

		driver.quit();
	}
}
