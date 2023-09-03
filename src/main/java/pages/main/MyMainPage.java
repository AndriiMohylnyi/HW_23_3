package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MyBasePage;

public class MyMainPage extends MyBasePage {

    @FindBy(xpath = "//*[@id='content']/div/h4")
    private WebElement successfulMessage;

    public MyMainPage() {
        super();
    }

    public String getSuccessMessageText() {
        return successfulMessage.getText();
    }
}
