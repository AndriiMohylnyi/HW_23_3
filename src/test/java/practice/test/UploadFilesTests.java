package practice.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MyFilesUtils;

import java.io.File;
import java.io.IOException;

public class UploadFilesTests extends BaseTestClass_Holder_New_Files {
    @Test
    public void uploadTest() throws IOException {
        File file = MyFilesUtils.generateLoremFile();
        goToPart("upload");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());

        goToPart("download");
        Assert.assertTrue(driver.findElement(By.linkText(file.getName())).isDisplayed());
    }

    @Test
    public void downloadTest() throws IOException, InterruptedException {
        File file = MyFilesUtils.generateLoremFile();
        goToPart("upload");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());

        goToPart("download");
        driver.findElement(By.linkText(file.getName())).click();

//        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("download_file", file.getName()));
        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("C:\\Users\\Joe\\Downloads", file.getName()));

        Assert.assertNotEquals(file.length(), file1.length());

        file1.deleteOnExit();

    }

}
