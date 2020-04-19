import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOpenPage {
    protected static WebDriver driver;
    private String browser = System.getProperty("browser");
    private Logger logger = LogManager.getLogger(TestOpenPage.class);

    @Before
    public void setUp() {

        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Chrome is up and running ");
        } else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox is up and running");
        }
    }

    @Test
    public void openPage() {
        driver.get("https://otus.ru/");
        logger.info("Открыта страница OTUS.RU");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
