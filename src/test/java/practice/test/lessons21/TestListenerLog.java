package practice.test.lessons21;

import driver.WebDriverHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class TestListenerLog implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " STARTED");
//        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getName() + " PASSED");
//        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getName() + " FAILED");
        makeScreenshots(result.getName() + new Date().getTime());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    public static File makeScreenshots(String screenshotName) {
        WebDriver driver = WebDriverHolder.getInstance().getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file = new File("screenshots", screenshotName + ".png");
        try {
            FileUtils.copyFile(screenshot, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

}
