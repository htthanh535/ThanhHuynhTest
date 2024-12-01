package SmilegateProject.MavenTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class HomePage extends BasePage {
	
	public static final String URL_LOGIN_PAGE = "https://phptravels.org/index.php?rp=/login";
	Wait<WebDriver> wait;
	
    @FindBy(id="common-popup-checkbox-skip-0")
    private WebElement commonPopupCheckbox;
    
    @FindBy(id="commpon-popup-front-body")
    private WebElement commonPopup;
    
    @FindBy(css="input[placeholder='Search Games']")
    private WebElement searchGameInput;
    
    private List<WebElement> searchDropdownItems;
    
    @FindBy(xpath="//div[contains(@class,'inds-gnb-component')]//a[contains(.,'Log In')]")
    private WebElement loginLink;
    
    @FindBy(className="stds-search-field-search-button")
    private WebElement searchButton;
    
    @FindBy(css="div:has(> input#types-filter-0-0)")
    private WebElement originalGamesItem;
    
    @FindBy(css="div:has(> input#ratings-filter-3-3)")
    private WebElement gameRating19PlusItem;
    
    @FindBy(xpath="//div[@id='64dc8c25e5b6807b2d04a37b']//span[contains(text(),'Search Result')]/following-sibling::em")
    private WebElement numberOfSearchResults;
    
    @FindBy(xpath="//div[@id='64dc8c25e5b6807b2d04a37b']//button[.//i[contains(@class,'community-view-card')]]")
    private WebElement gridViewButton;
    
    public HomePage(WebDriver driver){
    	super(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    public void navigateTo(String url){
    	System.out.println("Navigate To: " + url);
    	driver.navigate().to(url);
    	waitUntilElementIsVisible(loginLink);
    }
    
    public void clickOnCommonPopupCheckbox(){
    	System.out.println("Click On Common Popup Checkbox");
    	waitUntilElementIsVisible(commonPopup);
    	commonPopupCheckbox.click();
    }
    
    public void verifyCommonPopupDoesNotAppear(){
    	try {
    	System.out.println("Verify Common Popup Does Not Appear");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	Assert.assertTrue(driver.findElements(By.id("commpon-popup-front-body")).size() < 1);
    	} finally {
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	}
    }
    
    public void inputSearchGame(String text){
    	System.out.println("Input Search Game: " + text);
    	searchGameInput.sendKeys(text);
    }
    
    public void verifySearchDropdownListHasGame(String text){
    	System.out.println("Verify Search Dropdown List Has Game: " + text);
    	searchDropdownItems = driver.findElements(By.cssSelector(".inds-autocomplete-list a:has(img)"));
    	boolean found = false;
    	for(WebElement ele : searchDropdownItems) {
    		System.out.println("Item game: " + ele.getText().trim());
    		if(ele.getText().trim().contains(text)) {
    			found = true;
    			break;
    		}
    	}
    	Assert.assertTrue(found);
    }
    
    public void clickOnSearchButton(){
    	System.out.println("Click On Search Button");
    	searchButton.click();
    	// wait the search result item shows
    	Assert.assertTrue(driver.findElements(By.className("inds-category-a-type-item")).size() >= 0);
    }
    
    public void clickOnOriginalGamesItem(){
    	System.out.println("Click Original Games Item");
    	originalGamesItem.click();
    	waitForTheNumberOfSearchResultUpdated();
    }
    
    public void clickOnGameRating19PlusItem() {
    	System.out.println("Click On Game Rating 19 Plus Item");
    	gameRating19PlusItem.click();
    	waitForTheNumberOfSearchResultUpdated();
    }
    
    public String getNumberOfSearchResults() {
    	System.out.println("Number Of Search Results: " + numberOfSearchResults.getText());
    	return numberOfSearchResults.getText().trim();
    }
    
    public String countNumberOfSearchResultItems() {
    	int totalNumberResultItem = driver.findElements(By.className("inds-category-a-type-item")).size();
    	List<WebElement> pagingButtons = driver.findElements(By.cssSelector("span.inline-block button"));
    	for(int i=1; i<pagingButtons.size(); i++) {
    		if(pagingButtons.get(i).getText().trim().equals(i+1+"")) {
    			pagingButtons.get(i).click();
    			// wait the search result item shows
    			waitForTheNumberOfSearchResultUpdated();
    	    	int countOnNextPage = driver.findElements(By.className("inds-category-a-type-item")).size();
    	    	totalNumberResultItem = totalNumberResultItem + countOnNextPage;
    		}
    	}
    	System.out.println("Number Of Search Result Items: " + totalNumberResultItem);
    	return totalNumberResultItem + "";
    }
    
    public void verifyNumberOfSearchResultItems() {
    	System.out.println("Verify Number Of Search Result Items");
    	String numberOfSearchResultItems = countNumberOfSearchResultItems();
    	String numberOfSearchResults = getNumberOfSearchResults();
    	Assert.assertEquals(numberOfSearchResults, numberOfSearchResultItems);
    }
    
    private void waitForTheNumberOfSearchResultUpdated() {
    	int loopNumber = 5; // Time out is 10 second
    	String firstTimeGetNumber = getNumberOfSearchResults();
    	for (int i=0; i<loopNumber; i++) {
    		System.out.println("Wait 1 second");
    		sleepInSecond(1);
    		String secondTimeGetNumber = getNumberOfSearchResults();
    		if (!firstTimeGetNumber.equals(secondTimeGetNumber)) {
    			break;
    		}
    	}
    }
    
    public void clickOnGridViewButton() {
    	System.out.println("Click On Grid View Button");
    	gridViewButton.click();
    }
    
    public void hoverOnGame(String gameName) {
    	System.out.println("Hover On Game: " + gameName);
    	String itemXpath = "//div[contains(@class,'inds-product-relate-games-card-box') and .//p[contains(text(), '" + gameName + "')]]";
    	WebElement gameItem = driver.findElement(By.xpath(itemXpath));
    	waitUntilElementIsVisible(gameItem);
    	Actions action = new Actions(driver);
    	action.moveToElement(gameItem).perform();
    }
    
    public void verifyCartIconIsDisplayed(String gameName) {
    	System.out.println("Verify Cart Icon Is Displayed for: " + gameName);
    	String itemXpath = "//div[contains(@class,'inds-product-relate-games-card-box') and .//p[contains(text(), '" + gameName + "')]]";
    	WebElement gameItem = driver.findElement(By.xpath(itemXpath));
    	WebElement cartIcon = gameItem.findElement(By.xpath(".//i[contains(@class,'navigation-cart-fill')]"));
    	Assert.assertTrue(cartIcon.isDisplayed());
    }
    
    public void verifyHeartIconIsDisplayed(String gameName) {
    	System.out.println("Verify Heart Icon Is Displayed for: " + gameName);
    	String itemXpath = "//div[contains(@class,'inds-product-relate-games-card-box') and .//p[contains(text(), '" + gameName + "')]]";
    	WebElement gameItem = driver.findElement(By.xpath(itemXpath));
    	WebElement heartIcon = gameItem.findElement(By.xpath(".//i[contains(@class,'navigation-cart-fill')]"));
    	Assert.assertTrue(heartIcon.isDisplayed());
    }
    
    public void verifyGameTitle(String gameName) {
    	System.out.println("Verify Game Title Is Displayed: " + gameName);
    	String itemXpath = "//div[contains(@class,'inds-product-relate-games-card-box') and .//p[contains(text(), '" + gameName + "')]]";
    	WebElement gameItem = driver.findElement(By.xpath(itemXpath));
    	WebElement gameTitle = gameItem.findElement(By.xpath(".//p[contains(@class,'inds-product-card-hover-title')]"));
    	Assert.assertEquals(gameName, gameTitle.getText().trim());
    }
}
