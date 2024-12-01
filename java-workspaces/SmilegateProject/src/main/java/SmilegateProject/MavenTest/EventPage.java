package SmilegateProject.MavenTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EventPage extends BasePage {

    // Declare WebElement

    public EventPage(WebDriver driver){
    	super(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    // Create methods for Event page
}
