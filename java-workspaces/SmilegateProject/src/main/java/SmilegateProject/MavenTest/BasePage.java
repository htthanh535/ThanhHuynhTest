package SmilegateProject.MavenTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected Wait<WebDriver> wait;;
	public static final int TIMEOUT_IN_SECOND = 30;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SECOND));
	}
	
	public void waitUntilElementIsVisible(WebElement elementToWait) {
		wait.until(d -> elementToWait.isDisplayed());
	}
	
	public void sleepInSecond(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
