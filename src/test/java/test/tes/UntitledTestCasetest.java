package test.tes;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;

public class UntitledTestCasetest 
extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		  WebDriverManager.chromedriver().setup();
		  

		  ChromeOptions chromeOptions = new ChromeOptions();
	      chromeOptions.addArguments("--headless");

	       driver = new ChromeDriver(chromeOptions);
    baseUrl = "https://www.google.ie";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	  System.out.println("going to google");
	  driver.get("https://www.google.ie/?gws_rd=cr&dcr=0&ei=qlqIWpvGHIPQgAbTuLC4DQ");
	  System.out.println("clearing");
	    driver.findElement(By.id("lst-ib")).clear();
	    System.out.println("sending keys test");
	    driver.findElement(By.id("lst-ib")).sendKeys("test");
	    System.out.println("pressing enter");
	    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
