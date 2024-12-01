package SmilegateProject.MavenTest;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class OnstoveTest extends BaseTest {
    @Test(priority=0, groups= {"test2"})
    public void test2ClosePopup() {
    	// Step 1
    	driver.navigate().to(myWebSite);
    	// Step 2
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnCommonPopupCheckbox();
    	homePage.verifyCommonPopupDoesNotAppear();
    	// Step 3
    	System.out.println("Refresh Page");
    	driver.navigate().refresh();
    	homePage.verifyCommonPopupDoesNotAppear();
    	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
    
	@Test(priority=1, groups= {"test3"})
	public void test3ValidateAnItemInDropdownList() {
		// Step 1
	  	HomePage homePage = new HomePage(driver);
	  	homePage.navigateTo(myWebSite);
	  	// Step 2
	  	homePage.inputSearchGame("lord");
	  	homePage.verifySearchDropdownListHasGame("Lord Nine");
	  	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
	
	@Test(priority=2)
	public void test4ValidateTheTotalItemsInSearchResult() {
		// Step 1
	  	HomePage homePage = new HomePage(driver);
	  	homePage.navigateTo(myWebSite);
	  	// Step 2
	  	homePage.inputSearchGame("action");
	  	// Step 3
	  	homePage.clickOnSearchButton();
	  	// Step 4
	  	homePage.clickOnOriginalGamesItem();
	  	// Step 5
	  	homePage.clickOnGameRating19PlusItem();
	  	homePage.verifyNumberOfSearchResultItems();
	  	
	  	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
	
	@Test(priority=3)
	public void test5ValidateHoverFeature() {
		// Step 1
	  	HomePage homePage = new HomePage(driver);
	  	homePage.navigateTo(myWebSite);
	  	// Step 2
	  	homePage.inputSearchGame("Love of");
	  	homePage.clickOnSearchButton();
	  	// Step 3
	  	homePage.clickOnGridViewButton();
	  	// Step 4
	  	String gamePulseOfLove = "Pulse of Love";
	  	homePage.hoverOnGame(gamePulseOfLove);
	  	// Step 5
	  	homePage.verifyCartIconIsDisplayed(gamePulseOfLove);
	  	homePage.verifyHeartIconIsDisplayed(gamePulseOfLove);
	  	homePage.verifyGameTitle(gamePulseOfLove);
	  	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
}
