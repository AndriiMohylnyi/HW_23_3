package practice.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.login.MyLoginPage;
import pages.main.MyMainPage;
import utils.FirstPropertiesReader;

public class MyLoginTestsPO extends BaseTestClass_Holder_New {

    String userName = FirstPropertiesReader.getInstance().getProperties("login.tests.username");
    String userPassword = FirstPropertiesReader.getInstance().getProperties("login.tests.password");

    @BeforeClass
    public void beforeClass() {
        goToPart("login");
    }

    @Test
    public void unsuccessfulLoginPasswordTest() {
        MyLoginPage myLoginPage = new MyLoginPage()
                .unsuccessfulLogin(userName, userPassword + "1");

        Assert.assertEquals(myLoginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }

    @Test
    public void unsuccessfulLoginUserNameTest() {
        MyLoginPage myLoginPage = new MyLoginPage()
                .unsuccessfulLogin(userName + "1", userPassword);

        Assert.assertEquals(myLoginPage.getErrorMessageText().trim(), "Your username is invalid!\n" + "×");
    }

    @Test
    public void successfulLoginTest() {
        MyMainPage myMainPage = new MyLoginPage()
                .login(userName, userPassword);

        Assert.assertEquals(myMainPage.getSuccessMessageText().trim(), "Welcome to the Secure Area. When you are done click logout below.");

    }
}
