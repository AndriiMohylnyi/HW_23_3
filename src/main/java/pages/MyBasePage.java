package pages;

import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyBasePage {

    public MyBasePage(){
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }
}
