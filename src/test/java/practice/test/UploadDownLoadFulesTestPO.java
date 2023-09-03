package practice.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.uploadDownload.DownloadPage;
import pages.uploadDownload.UploadDownloadPage;
import utils.MyFilesUtils;

import java.io.File;
import java.io.IOException;

public class UploadDownLoadFulesTestPO extends BaseTestClass_Holder_New {
    @BeforeClass
    public void beforeClass() {
        goToPart("upload");
    }

    @Test
    public void downloadTest() throws IOException, InterruptedException {
        File file = MyFilesUtils.generateLoremFile();
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage()
                .findUpload(file);
        Assert.assertEquals(uploadDownloadPage.getNameFile(), file.getName());
        goToPart("download");
        DownloadPage DownLoadPage = new DownloadPage()
                .findFile(file);
        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("C:\\Users\\Joe\\Downloads", file.getName()));

        Assert.assertEquals(file.length(),file1.length());
        file1.delete();

    }
}
