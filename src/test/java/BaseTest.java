import io.github.bonigarcia.wdm.WebDriverManager;
import io.testproject.sdk.drivers.web.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class BaseTest {
  protected static ChromeDriver driver;
  private static final String URL = "https://example.testproject.io/web/index.html";
  protected static LoginPage loginPage;

  @BeforeClass
  public static void setUp() throws Exception {
    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver(
            new ChromeOptions(),
            "My first Project");
    driver.manage().window().maximize();
    driver.get(URL);
    loginPage = new LoginPage(driver);
  }

  @AfterClass
  public static void tearDown() throws Exception {
    driver.quit();
  }
}