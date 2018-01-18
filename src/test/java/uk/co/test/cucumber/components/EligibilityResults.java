package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class EligibilityResults extends PageObject {

    @FindBy(id = "content")
    private WebElement eligibilityCheckContent;

    @FindBy(xpath = ".//*[@id='qs-CCS26']/div[1]/article/header/div")
    private WebElement eligibilityCheckResults;

    public void validateEligibilityCheckContent(String content){
        assertThat(eligibilityCheckContent.getText(),containsText(content));
    }

    public void waitForEligibilityResults(){
        element(eligibilityCheckResults).waitUntilPresent();
    }
}
