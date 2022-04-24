package pageObj.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObj.Base;

public class SearchResPageObj extends Base {
    public SearchResPageObj(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = ".//a[contains(.,'Картинки')]")
    private WebElement imagesTab;

    /**
     * Проверяем, что кнопка картинки существует на странице
     * @return
     */

    public boolean isImagesTabButtonIsExist(){
        return waitVisibilityElement(imagesTab);
    }
}
