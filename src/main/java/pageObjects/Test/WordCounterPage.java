package pageObjects.Test;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import managers.ReaderManager;
import org.openqa.selenium.*;
import comun.BaseClass;

public class WordCounterPage {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();
    String quote = faker.harryPotter().quote();
    String text = "";
    String obtainedText = "";
    int words, characters, count = 0;
    String[] obtainWords = new String[]{""};
    public WordCounterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='box']")
    private static WebElement textBox;
    @FindBy(xpath = "//*[@id='editor_container']/div[6]/div/div[1]/h4/span")
    private static WebElement editorContainer;

    public void goToURL(){
        driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void validateThatISInWordCounterPage(){
        //BaseClass.waitForVisibility(driver.findElement(By.xpath("//*[contains(text(),'WordCounter')]")), 10, driver);
        //softAssert.assertTrue(BaseClass.isAnElementPresentInTheDOM("//*[contains(text(),'WordCounter')]", driver));
    }
    public void putTextInBox() {
        BaseClass.waitForVisibility(textBox, 10, driver);
        textBox.sendKeys(quote);
    }
    public void countWordsFromBox(){
        BaseClass.implicitwait(driver, 2);
        BaseClass.waitForVisibility(editorContainer, 10, driver);
        text = textBox.getAttribute("value");
        obtainedText = editorContainer.getText();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(obtainedText);

        while (matcher.find() && count < 2) {
            if (count == 0) {
                words = Integer.parseInt(matcher.group());
            } else if (count == 1) {
                characters = Integer.parseInt(matcher.group());
            }
            count++;
        }
        obtainWords = text.split("\\s+");
    }
    public void validateCounter(){
        softAssert.assertEquals(words, obtainWords.length);
        softAssert.assertEquals(characters, text.length());
        softAssert.assertAll();
    }
}
