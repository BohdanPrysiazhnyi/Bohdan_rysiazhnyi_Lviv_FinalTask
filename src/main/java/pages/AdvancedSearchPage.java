package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchPage extends BasePage{
    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='adv-s mb space-top']//button")
    private WebElement firstSearchButton;

    public void clickOnFirstSearchButton(){
        firstSearchButton.click();
    }
    public boolean isFirstSearchButtonPresent(){return firstSearchButton.isDisplayed();}

}
