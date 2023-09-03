package practice.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTestSimple18_New extends BaseTestClass_Holder_New {
    @Test
    public void switchToFram() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "BOTTOM");

        driver.switchTo().defaultContent();

        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
    }

}
