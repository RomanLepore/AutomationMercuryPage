package automatizacionMT;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegisterTest {
	
	private WebDriver driver;
	RegisterPage registerPage;
	
	@Before
	public void setUp() {
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.visit("https://demo.guru99.com/test/newtours/index.php");
	}
	@Test
	public void test() throws InterruptedException {
		registerPage.registerUser();
		assertEquals("Note: Your user name is useradmin.",registerPage.registerMessage());
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
