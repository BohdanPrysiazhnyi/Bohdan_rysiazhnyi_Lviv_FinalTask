package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='image-display']")
    private List<WebElement> itemsPresentInShoppingCart;
    @FindBy(xpath = "//div[@class='item-variations']")
    private List< WebElement> namesOfProducts;
    @FindBy(xpath = "//h3[@class='item-title truncate-multiline lines-2 black-link']")
    private WebElement startShoppingButton;
    @FindBy(xpath = "//div[@class='cart-bucket-lineitem-foot']//button[@data-test-id='cart-remove-item']")
    private List<WebElement> removeButtonList;
    @FindBy(xpath = "//div[@class='page-alert page-alert--confirmation']")
    private WebElement removeProductNotification;

    public boolean shoppingCartIsNotEmpty(){
        return itemsPresentInShoppingCart.get(0).isDisplayed();
    }
    public boolean shoppingCartIsEmpty(){return itemsPresentInShoppingCart.isEmpty();}
    public String getNameOfProductInProductCart(){
        return  namesOfProducts.get(0).getText();
    }
    public void clickOnRemoveButton(){
        removeButtonList.get(0).click();
    }
    public WebElement removeNotification(){
        return removeProductNotification;
    }
    public boolean productIsRemovedFromCart(){
        return removeProductNotification.isDisplayed();
    }


    public void clickOnStartShoppingButton(){
        startShoppingButton.click();
    }





}