package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class PopUps extends PageObject {

    @FindBy(id = "warning-age")
    private WebElement warningForAge;

    @FindBy(xpath = ".//*[@id='warning-age']/button")
    private WebElement popUpCloseButton;


    public void ageWarningPopUpisDisplayed(){
        assertThat(warningForAge.isDisplayed());
        popUpCloseButton.click();
    }

}
