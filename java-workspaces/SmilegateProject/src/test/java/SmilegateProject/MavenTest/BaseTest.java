package SmilegateProject.MavenTest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	String driverPath = System.getProperty("user.dir") + "\\chromedriver-win64\\chromedriver.exe";
	String myWebSite = "https://store.onstove.com/en";
	WebDriver driver;
    
    @BeforeSuite
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", driverPath);
    	System.out.println("Create chrome driver");
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    
    @AfterSuite(alwaysRun = true)
	protected void closeBrowser() throws Exception
	{
    	driver.quit();
	}
}
