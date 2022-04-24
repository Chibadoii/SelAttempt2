package pageObj.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObj.Base;

public class InitPageObj extends Base {
    public InitPageObj(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = ".//form//input[@title=\"Поиск\" and @aria-label]")
    private WebElement searchText;

    @FindBy(xpath = "(.//input[@value = \"Поиск в Google\"])[1]")
    private WebElement submitSearch;



    public void setSetSearchText(String text){
        setText(searchText, text);
    }

    public void clickSubmitText(){
        click(submitSearch);
    }
}

