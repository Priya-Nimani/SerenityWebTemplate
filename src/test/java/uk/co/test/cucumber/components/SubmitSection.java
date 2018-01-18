package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class SubmitSection extends PageObject{

    @FindBy(xpath = ".//*[@id='form-footer']/div[2]")
    private WebElement checkNowBtn;


    public void clickCheckNow(){
        element(checkNowBtn).waitUntilPresent().click();
    }
}
