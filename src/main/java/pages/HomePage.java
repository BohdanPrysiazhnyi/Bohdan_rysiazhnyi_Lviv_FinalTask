package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private static final long DEFAULT_TIMEOUT = 60;

    Actions action = new Actions(driver);

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    private WebElement searchField;

    @FindBy(xpath = "//td[@class='gh-td gh-sch-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='gh-la']")
    private WebElement companyLogo;

    @FindBy(xpath = "//td[@class='gh-td']/div[@class='gh-hide-if-nocss']")
    private WebElement shopByCategoryDropDownList;

    @FindBy(xpath = "//div[@class='hl-color-block-banner__content']")
    private WebElement advertisementBanner;

    @FindBy(xpath = "//a[contains(text(),'Explore popular brands')]")
    private WebElement explorePopularBrandsButton;

    @FindBy(xpath = "//a[contains(text(),'Explore Popular Categories')]")
    private WebElement explorePopularCategoryButton;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(text(),'register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//li[@class='gh-t gh-divider-l']//a[contains(text(),'Help & Contact')]")
    private WebElement helpAndContactButton;

    @FindBy(xpath = "//div[@id='gh-top']")
    private WebElement topNavigationBar;

    @FindBy(xpath = "//div[@class='gh-minicart-header gh-minicart-header-empty']")
    private WebElement popupCartIsEmpty;

    @FindBy(xpath = "//*[@id=\"gh-minicart-hover\"]")
    private WebElement cartButton;

    public void openHomePage(String url){
        driver.get(url);
    }
    public void searchByKeyword(final String keyWord) {
        searchField.clear();
        searchField.sendKeys(keyWord);
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }
    public void clickOnCartButton(){
        cartButton.click();
    }


    public boolean isSearchButtonVisible(){return searchButton.isDisplayed();}
    public boolean isSearchFieldVisible(){ return searchField.isDisplayed();}
    public boolean isCompanyLogoVisible(){ return companyLogo.isDisplayed();}
    public boolean isShopByCategoryDropDownListVisible(){ return shopByCategoryDropDownList.isDisplayed();}
    public boolean isAdvertisementBannerVisible(){return  advertisementBanner.isDisplayed();}
    public boolean isExplorePopularBrandsButtonVisible(){return explorePopularBrandsButton.isDisplayed();}
    public boolean isExplorePopularCategoryButtonVisible(){return explorePopularCategoryButton.isDisplayed();}
    public boolean isSignInButtonVisible(){return signInButton.isDisplayed();}
    public boolean isRegisterButtonVisible(){return registerButton.isDisplayed();}
    public boolean isHelpAndContactButtonVisible(){return helpAndContactButton.isDisplayed();}
    public boolean isTopNavigationBarVisible(){return topNavigationBar.isDisplayed();}
    public boolean isCartButtonVisible(){return cartButton.isDisplayed();}
    public boolean isPopupCartIsEmptyVisible(){
        action.moveToElement(cartButton).build().perform();
        waitVisibilityOfElement(DEFAULT_TIMEOUT,popupCartIsEmpty);
        return popupCartIsEmpty.isDisplayed();
    }
    public void clickOnSignInButton(){
        signInButton.click();
    }










}