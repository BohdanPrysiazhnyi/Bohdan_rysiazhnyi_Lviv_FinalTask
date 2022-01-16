package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionsSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;
    SignInPage signInPage;
    AdvancedSearchPage advancedSearchPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User opens {string} page")
    public void openHomePage(final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);

    }


    @Then("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        Assert.assertTrue(homePage.isSearchFieldVisible());
    }

    @And("User checks search button visibility")
    public void userChecksSearchButtonVisibility() {
        Assert.assertTrue(homePage.isSearchButtonVisible());
    }

    @And("User checks company logo visibility")
    public void userChecksCompanyLogoVisibility() {
        Assert.assertTrue(homePage.isCompanyLogoVisible());
    }

    @And("User checks shop by category dropDown list visibility")
    public void userChecksShopByCategoryDropDownListVisibility() {
        Assert.assertTrue(homePage.isShopByCategoryDropDownListVisible());
    }

    @And("User checks advertisement banner visibility")
    public void userChecksAdvertisementBannerVisibility() {
        Assert.assertTrue(homePage.isAdvertisementBannerVisible());
    }

    @And("User checks explore popular brands button visibility")
    public void userChecksExplorePopularBrandsButtonVisibility() {
        Assert.assertTrue(homePage.isExplorePopularBrandsButtonVisible());
    }

    @And("User checks explore popular category button visibility")
    public void userChecksExplorePopularCategoryButtonVisibility() {
        Assert.assertTrue(homePage.isExplorePopularBrandsButtonVisible());
    }

    @And("User checks sign in button visibility")
    public void userChecksSignInButtonVisibility() {
        Assert.assertTrue(homePage.isSignInButtonVisible());
    }

    @And("User checks register button visibility")
    public void userChecksRegisterButtonVisibility() {
        Assert.assertTrue(homePage.isRegisterButtonVisible());
    }

    @And("User checks help and contact button visibility")
    public void userChecksHelpAndContactButtonVisibility() {
        Assert.assertTrue(homePage.isHelpAndContactButtonVisible());
    }

    @And("User checks top navigation bar visibility")
    public void userChecksTopNavigationBarVisibility() {
        Assert.assertTrue(homePage.isTopNavigationBarVisible());
    }


    @And("User checks cart button visibility")
    public void userChecksCartButtonVisibility() {
        Assert.assertTrue(homePage.isCartButtonVisible());
    }


    @And("User checks popup cart is empty visibility")
    public void userChecksPopupCartIsEmptyVisibility() {
        Assert.assertTrue(homePage.isPopupCartIsEmptyVisible());
    }


    @When("User fill out search field with {string}")
    public void userFillOutSearchFieldWithKeyWord(final String keyWord) {
        homePage.searchByKeyword(keyWord);
        homePage.clickOnSearchButton();
    }


    @Then("User checks that search result list contains {string} of items")
    public void userChecksThatSearchResultListContainsQuantityOfItems(final String quantity) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        Assert.assertEquals(Integer.toString(searchResultPage.getSearchResultsItemsListWithText().size()),quantity);
    }


    @And("User chooses network category on search results page")
    public void userChoosesNetworkCategoryOnSearchResultsPage() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickOnVerizonCheckBoxInNetworkCategory();
    }

    @When("User chooses first product from list on search result page")
    public void userChoosesFirstProductFromListOnSearchResultPage() throws InterruptedException {

        searchResultPage.waitUntilElementToBeClickable(DEFAULT_TIMEOUT, searchResultPage.getSearchResultsItemsListWithText().get(1));
        Thread.sleep(100);
        searchResultPage.clickOnFirstSearchResultItem();
        searchResultPage.switchTabs();

    }




    @When("User chooses network category")
    public void userChoosesNetworkCategory() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickOnVerizonCheckBoxInNetworkCategory();
    }

    @Then("User check that all products in search list contains products with {string} from chosen category")
    public void userCheckThatAllProductsInSearchListContainsProductsWithWordFromChosenCategory(final String word) {

        Assert.assertTrue(searchResultPage.checkThatAllListElementsContainText(word));
    }

    @And("User chooses iPhone model")
    public void userChoosesIPhoneModel() {
        searchResultPage.clickOnIphone7PlusCheckBox();
    }

    @And("User clicks add to cart button")
    public void userClicksAddToCartButton() {
        productPage=pageFactoryManager.getProductPage();
        productPage.clickOnAddToCartButton();
    }

    @Then("User checks that product is added to cart")
    public void userChecksThatProductIsAddedToCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.shoppingCartIsNotEmpty());
    }

    @And("User clicks remove button")
    public void userClicksRemoveButton() throws InterruptedException {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.clickOnRemoveButton();
        Thread.sleep(300);
    }

    @Then("User checks that product cart is empty")
    public void userChecksThatProductCartIsEmpty() {
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.removeNotification());
        Assert.assertTrue(shoppingCartPage.productIsRemovedFromCart());
    }

    @And("User chooses network checkBox category on search results page")
    public void userChoosesNetworkCheckBoxCategoryOnSearchResultsPage() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickOnVerizonCheckBoxInNetworkCategory();
    }

    @When("User chooses product from list on search result page")
    public void userChoosesProductFromListOnSearchResultPage() {
        searchResultPage.clickOnFirstSearchResultItem();
        searchResultPage.switchTabs();
    }

    @And("User clicks add to cart button on product page")
    public void userClicksAddToCartButtonOnProductPage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnAddToCartButton();
    }

    @And("User clicks on sign in button")
    public void userClicksOnSignInButton() {
        homePage.clickOnSignInButton();
    }

    @When("User fill out username field with {string} username")
    public void userFillOutUsernameFieldWithEmailUsername(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.fillOutEmailOrUserNameTextField(email);
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() {
        signInPage.clickOnContinueButton();
    }

    @And("User fill out password field with {string}")
    public void userFillOutPasswordFieldWithPassword(final String password) {
        signInPage.enterPassword(password);
    }

    @And("User clicks on sign in button on sign in page")
    public void userClicksOnSignInButtonOnSignInPage() {
        signInPage.clickSignInButton();
    }

    @Then("User verify that sign in button contains {string} on home page")
    public void userVerifyThatSignInButtonContainsLoginNameOnHomePage(final String loginName) {
        Assert.assertTrue(homePage.getSignInNameOnHomePage().contains(loginName));
    }

    @When("User fill out username field with incorrect {string} username")
    public void userFillOutUsernameFieldWithIncorrectEmailUsername(final String email) {
        signInPage  = pageFactoryManager.getSignInPage();
        signInPage.fillOutEmailOrUserNameTextField(email);
    }


    @Then("User verify that {string} appeared on login page")
    public void userVerifyErrorMessageAppearedOnLoginPage(final String errorMessage) {
        Assert.assertTrue(signInPage.getErrorMessageWhenLoginOrPasswordAreIncorrect().contains(errorMessage));
    }

    @And("User clicks add to watchList button on product page")
    public void userClicksAddToWatchListButtonOnProductPage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnAddToWatchlistButton();
    }

    @When("User clicks on advanced search button")
    public void userClicksOnAdvancedSearchButton() {
        homePage.clickOnAdvancedSearchButton();
    }

    @Then("User checks first search  button visibility")
    public void userChecksFirstSearchButtonVisibility() {
        advancedSearchPage = pageFactoryManager.getAdvancedSearchPage();
        Assert.assertTrue(advancedSearchPage.isFirstSearchButtonPresent());
    }
}
