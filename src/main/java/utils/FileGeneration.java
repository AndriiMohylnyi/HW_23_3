package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MyBasePage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FileGeneration extends MyBasePage {
    @FindBy(id = "create")
    private WebElement buttonGenerateFile;

    @FindBy(id = "link-to-download")
    private WebElement buttonDownload;

    @FindBy(id = "texbox")
    private WebElement textBox;

    public FileGeneration pasteText() {
        File file = new File("files/OCoOcDwcXr.txt");
        List<String> strings;
        try{
            strings = FileUtils.readLines(file, Charset.defaultCharset());
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        String str1 = "";
        for (String string : strings) {
            str1 = str1 + string + "\n";
        }
        textBox.sendKeys(str1);
        return this;
    }
}
