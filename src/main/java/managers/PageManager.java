package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.Test.WordCounterPage;

public class PageManager {
    private WebDriver driver;
    private WordCounterPage wordCounterPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public WordCounterPage getWordCounterPage(){
        return (wordCounterPage == null) ? wordCounterPage = new WordCounterPage(driver) : wordCounterPage;
    }
}
