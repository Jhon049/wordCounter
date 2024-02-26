package stepDefinitions;

import contextManager.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        wordCounterPage.validateThatISInWordCounterPage();
        wordCounterPage.putTextInBox();
    }
    @When("The User can check how many words and characters it contains")
    public void The_User_can_check_how_many_words_and_characters_it_contains(){
        wordCounterPage.countWordsFromBox();
    }
    @Then("The user compares the information and validates that the count is right")
    public void The_user_compares_the_information_and_validates_that_the_count_is_right(){
        wordCounterPage.validateCounter();
    }
}
