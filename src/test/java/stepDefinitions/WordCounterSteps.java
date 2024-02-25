package stepDefinitions;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.Test.WordCounterPage;

public class WordCounterSteps {
    TestContext testContext;
    WordCounterPage wordCounterPage;

    public WordCounterSteps(TestContext testContext){
        this.testContext = testContext;
        wordCounterPage = testContext.getPageManager().getWordCounterPage();
    }

    public WordCounterSteps(){
        this.testContext = new TestContext();
        this.wordCounterPage = testContext.getPageManager().getWordCounterPage();
    }

    @Given("An User puts a new random text in the box")
    public void an_user_puts_a_new_random_text_in_the_box() throws InterruptedException {
        if (wordCounterPage == null){
            this.wordCounterPage = testContext.getPageManager().getWordCounterPage();
        }
        wordCounterPage.goToURL();
        wait(5000);
    }
}
