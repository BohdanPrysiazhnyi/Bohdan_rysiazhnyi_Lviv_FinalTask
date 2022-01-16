package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement emailOrUserNameTextField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='inline-notice__main']")
    private WebElement errorMessageOnLoginPageWhenLoginOrPasswordAreIncorrect;

    public String getErrorMessageWhenLoginOrPasswordAreIncorrect(){
        return errorMessageOnLoginPageWhenLoginOrPasswordAreIncorrect.getText();
    }

    public void enterPassword(final String password){
        passwordField.sendKeys(password);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public void fillOutEmailOrUserNameTextField(final String email){
        emailOrUserNameTextField.sendKeys(email);
    }

}
