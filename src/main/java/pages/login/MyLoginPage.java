package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MyBasePage;
import pages.main.MyMainPage;

public class MyLoginPage extends MyBasePage {

    @FindBy(id = "username")
    private WebElement userInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement errorMessage;

    public MyLoginPage(){
        super();
    }

    private MyLoginPage setUserName(String userName) {
        return enterValueToWebElement(userInput, userName);
    }

    private MyLoginPage setUserPassword(String userPassword) {
        return enterValueToWebElement(passwordInput, userPassword);
    }

    private MyLoginPage enterValueToWebElement(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
        return this;
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public MyMainPage login(String userName, String userPassword) {
        setUserName(userName)
                .setUserPassword(userPassword)
                .clickLoginButton();
        return new MyMainPage();
    }

    public MyLoginPage unsuccessfulLogin(String userName, String userPassword) {
        setUserName(userName)
                .setUserPassword(userPassword)
                .clickLoginButton();
        return new MyLoginPage();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
