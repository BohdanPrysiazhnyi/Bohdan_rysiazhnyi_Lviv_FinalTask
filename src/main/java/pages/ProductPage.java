package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    Actions action = new Actions(driver);
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='binBtn_btn']")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//div[@class='u-cb  ']//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='vi-atl-lnk-99']//span[@class='vi-atw-txt']")
    private WebElement addToWatchlistButton;

    @FindBy(xpath = "//select[@id='msku-sel-1']")
    private WebElement colourDropDownList;

    @FindBy(xpath = "//option[contains(text(),'Gold')]")
    private WebElement goldColourInDropDownList;

    @FindBy(xpath = "//select[@id='msku-sel-2']")
    private WebElement modelDropDownList;

    @FindBy(xpath = "//div[@class='vi-swc-lsp']")
    private WebElement productOnProductPage;

    public boolean productIsPresentOnProductPage(){
      return   productOnProductPage.isDisplayed();
    }

    public void clickOnAddToWatchlistButton(){
        addToWatchlistButton.click();
    }
    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }
    public void clickOnBuyItNowButton(){
        buyItNowButton.click();
    }
    public void clickOnColourDropDownList(){
        action.moveToElement(colourDropDownList).click().perform();
    }
    public void clickOnGoldColourInDropDownList(){
        goldColourInDropDownList.click();
    }
    public void clickOnModelDropDownList(){
        modelDropDownList.click();
    }

}