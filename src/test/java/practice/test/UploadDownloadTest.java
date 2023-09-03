package practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.uploadDownload.UploadDownloadPage;
import utils.MyFilesUtils;

import java.io.File;
import java.io.IOException;

public class UploadDownloadTest extends BaseTestClass_Holder_New{
    @BeforeClass
    public void beforClass(){
        goToPart("upload");
    }

    @Test
    public void uploadTest() throws IOException{
        File file = MyFilesUtils.generateLoremFile();
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage()
                .findUpload(file);
        Assert.assertEquals(uploadDownloadPage.getNameFile(),file.getName());
        goToPart("download");
        Assert.assertTrue(driver.findElement(By.linkText(file.getName())).isDisplayed());

    }
}
