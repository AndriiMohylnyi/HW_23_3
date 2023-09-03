package practice.test.lessons21;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.login.MyLoginPage;
import pages.main.MyMainPage;
import utils.FirstPropertiesReader;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class LoginTestsPOScreen extends BaseTestClass {
    String userName = FirstPropertiesReader.getInstance().getProperties("login.tests.username");
    String userPassword = FirstPropertiesReader.getInstance().getProperties("login.tests.password");

    @BeforeClass
    public void beforeClass() {
        goToPart("login");
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        goToPart("login");
//    }

//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult result) {
//        if(!result.isSuccess()) {
//            makeScreenshots(result.getName() + new Date().getTime());
//        }
//    }

//    public File makeScreenshots(String screenshotName) {
//        WebDriver driver = WebDriverHolder.getInstance().getDriver();
//
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        File file = new File("screenshots", screenshotName + ".png");
//        try {
//            FileUtils.copyFile(screenshot, file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return file;
//    }

    @Test
    public void unsuccessfulLoginTest() {
        MyLoginPage loginPage = new MyLoginPage()
                .unsuccessfulLogin(userName, userPassword + "1");

//        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
        Assert.assertNotEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }

    @Test
    public void successfulLoginTest() {
        MyMainPage mainPage = new MyLoginPage()
                .login(userName, userPassword);

        Assert.assertEquals(mainPage.getSuccessMessageText().trim(), "Welcome to the Secure Area. When you are done click logout below.");

    }

}
