package Testing;

import baseTests.BaseTests;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObj.Google.InitPageObj;
import pageObj.Google.SearchResPageObj;
import testData.WordsTestData;

import java.io.File;
import java.io.IOException;

public class SelParamTest extends BaseTests {
    @DataProvider(name = "setWords", parallel = false)
    public Object[][] getData () {
        Object[][] words = new Object[][]{
                {new WordsTestData("word").getWord1(), "word1"},
                {new WordsTestData("word").getWord1(), "word2"},
                {new WordsTestData("word").getWord1(), "word3"}

        };
        return words;
    }

    @Test(dataProvider = "setWords")
    public void startTest(String word, String testName){
        getDriver().get(stendUrl);
        getDriver().manage().window().maximize();

        InitPageObj in = new InitPageObj(getDriver());
        in.setSetSearchText(word);
        in.clickSubmitText();

        SearchResPageObj sr = new SearchResPageObj(getDriver());
        Assertion as = new Assertion();
        as.assertTrue(sr.isImagesTabButtonIsExist());

        File file = new File("./src/main/resources/" + testName +".jpg");
        try{
            FileUtils.writeByteArrayToFile(file, getScreenShot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
