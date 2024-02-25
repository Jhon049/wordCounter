package pageObjects.Test;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import managers.ReaderManager;
import org.openqa.selenium.*;

public class WordCounterPage {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public WordCounterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='box']")
    private static WebElement textBox;

    public void goToURL(){
        driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

}
