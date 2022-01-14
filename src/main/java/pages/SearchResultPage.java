package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    Actions action = new Actions(driver);

    @FindBy(xpath = "//div[@class='s-item__image-section']")
    private List<WebElement> searchResultItemsListWithIcons;

    @FindBy(xpath = "//li[@name='Network']//span[contains(text(),'Unlocked')]")
    private WebElement verizonNetworkCategoryCheckBox;

    @FindBy(xpath = "//div[@class='s-item__info clearfix']")
    private List<WebElement> searchResultsItemsListWithText;

    @FindBy(xpath = "//div[@class='x-refine__select__svg']//div//span[contains(text(),'iPhone 7 Plus')]")
    private WebElement iPhone7PlusCheckBox;

    public void clickOnIphone7PlusCheckBox(){
        iPhone7PlusCheckBox.click();
    }

    public WebElement getVerizonNetworkCategoryCheckBox() {
        return verizonNetworkCategoryCheckBox;
    }


    public void clickOnFirstSearchResultItem() {
        searchResultItemsListWithIcons.get(1).click();
    }

    public List<WebElement> getSearchResultsItemsListWithText() {
        return searchResultsItemsListWithText;
    }

    public void clickOnVerizonCheckBoxInNetworkCategory() {
        verizonNetworkCategoryCheckBox.click();
    }

    public boolean checkThatAllListElementsContainText(final String word) {
        boolean result = true;
        for (WebElement el : searchResultsItemsListWithText) {
            result = el.getText().toLowerCase().contains(word);
        }
        return result;

    }

    public void switchTabs() {
        String parentID = driver.getWindowHandle();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        if (parentID.equals(tabs2.get(0))) {
            driver.switchTo().window(tabs2.get(1));
        } else {
            driver.switchTo().window(tabs2.get(0));
        }
    }

}
