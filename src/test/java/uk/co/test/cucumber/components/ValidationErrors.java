package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationErrors extends PageObject {

    @FindBy(id = "error_title")
    private WebElement errorTitle;

    @FindBy(id = "error_fname")
    private WebElement errorFName;

    @FindBy(id = "error_sname")
    private WebElement errorSName;

    @FindBy(id = "error_email_address")
    private WebElement errorEmailID;

    @FindBy(id = "error_dob")
    private WebElement errorDOB;

    @FindBy(id = "error_empstatus")
    private WebElement errorEmpStatus;

    @FindBy(id = "error_grossincome")
    private WebElement errorIncome;

    @FindBy(id = "error_residential_status")
    private WebElement errorResStatus;

    @FindBy(id = "error_curr_addr_years")
    private WebElement errorCurrAddrYears;

    @FindBy(id = "error-message-postcode")
    private WebElement errorPostCode;


    public void checkValidationErrorsForMandatoryFields(){
        assertThat(errorTitle.isDisplayed());
        assertThat(errorFName.isDisplayed());
        assertThat(errorSName.isDisplayed());
        assertThat(errorEmailID.isDisplayed());
        assertThat(errorDOB.isDisplayed());
        assertThat(errorEmpStatus.isDisplayed());
        assertThat(errorIncome.isDisplayed());
        assertThat(errorResStatus.isDisplayed());
        assertThat(errorCurrAddrYears.isDisplayed());
    }

    public void checkValidationErrorsForFNameandEmailID(){
        assertThat(errorFName.isDisplayed());
        assertThat(errorEmailID.isDisplayed());
    }

    public void checkValidationErrorForPostcode(){
        assertThat(errorPostCode.isDisplayed());
    }

}
