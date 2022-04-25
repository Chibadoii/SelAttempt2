package baseTests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObj.Common;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    WebDriver driver;

    protected Common c = new Common();

    public String setStendKey = System.setProperty("StendKey","stend1");//При мавене комментируем или при выборе определенного параметра
    public String stendKey = System.getProperty("StendKey");
    public String stendUrl = PropertyLoader.loadProperty(stendKey);

    @BeforeTest
    public void beforeTest() {
        //System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");//для локалки
        //ChromeOptions op = new ChromeOptions();
        FirefoxOptions fo = new FirefoxOptions();

//        DesiredCapabilities dc = DesiredCapabilities.chrome(); //для локалки
//        dc.setCapability(ChromeOptions.CAPABILITY, op);
//        driver = new ChromeDriver();

            fo.setCapability("version", "98.0");//Версия браузера для Firefox
            //op.setCapability("version","100.0");//версия браузера Google для докера
        URL hub = null;
        try{
            hub = new URL("http://localhost:4444/wd/hub");//45 селеноид, 44 Докер
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //driver = new RemoteWebDriver(hub,op);//Google
        driver = new RemoteWebDriver(hub,fo);//Firefox
    }
    @AfterTest
    public void afterTest(){
        getScreenShot();
        driver.quit();
        if(driver !=null){
            driver.quit();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[]getScreenShot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
