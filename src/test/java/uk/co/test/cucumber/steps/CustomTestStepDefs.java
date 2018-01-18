package uk.co.test.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import uk.co.test.cucumber.components.*;
import uk.co.test.cucumber.globalTasks.GlobalMethods;

public class CustomTestStepDefs {

    @Steps
    public GlobalMethods globalmethods;

    @Steps
    public AboutYouSection aboutYouSection;

    @Steps
    public WhereYouLiveSection whereYouLiveSection;

    @Steps
    public WorkAndFinancesSection workAndFinancesSection;

    @Steps
    public SubmitSection submitSection;

    @Steps
    public EligibilityResults eligibilityResults;

    @Steps
    public ValidationErrors validationErrors;

    @Steps
    public PopUps popUps;


    @Given("^the customer navigates to the CapitalOne credit card eligibility check website$")
    public void theCustomerNavigatesToTheCapitalOneCreditCardEligibilityCheckWebsite() throws Throwable {
        globalmethods.navigateToHomepage();
    }

    @When("^he enters valid data for all the fields$")
    public void heEntersValidDataForAllTheFields() throws Throwable {
        aboutYouSection.selectTitle("Miss");
        aboutYouSection.enterFirstName("testFirstName");
        aboutYouSection.enterLastName("testLastName");
        aboutYouSection.enterEmailID("test123@gmail.com");
        aboutYouSection.selectDOB("11","Jan","1995");

        workAndFinancesSection.selectEmploymentStatus("Employed");
        workAndFinancesSection.enterOccupation("Test Engineer");
        workAndFinancesSection.enterYearlyIncome("45000");

        whereYouLiveSection.selectResedentialStatus("Homeowner");
        whereYouLiveSection.selectYearsAtCurrAddr("2");
        whereYouLiveSection.enterPostcode("S6 5BX");
        whereYouLiveSection.clickFindAddress();
        whereYouLiveSection.selectCurrentAddress(5);
    }

    @And("^he clicks CheckNow$")
    public void heClicksCheckNow() throws Throwable {
        submitSection.clickCheckNow();
    }

    @Then("^he will be redirected to the page with positive results on eligibilty check$")
    public void heWillBeRedirectedToThePageWithPositiveResultsOnEligibiltyCheck() throws Throwable {
        eligibilityResults.waitForEligibilityResults();
        globalmethods.checkPageTitle("Your Results - Capital One");
        eligibilityResults.validateEligibilityCheckContent("Apply and we'll say yes");
    }

    @When("^he enters valid data for only the mandatory fields$")
    public void heEntersValidDataForOnlyTheMandatoryFields() throws Throwable {
        aboutYouSection.selectTitle("Mr");
        aboutYouSection.enterFirstName("testFirstName");
        aboutYouSection.enterLastName("testLastName");
        aboutYouSection.enterEmailID("test123@yahoo.com");
        aboutYouSection.selectDOB("11","Nov","1985");

        workAndFinancesSection.selectEmploymentStatus("Retired");
        workAndFinancesSection.enterYearlyIncome("20000");

        whereYouLiveSection.selectResedentialStatus("Other");
        whereYouLiveSection.selectYearsAtCurrAddr("5");
        whereYouLiveSection.enterPostcode("S6 5LH");
        whereYouLiveSection.clickFindAddress();
        whereYouLiveSection.selectCurrentAddress(8);
    }

    @Then("^validation errors will be highlighted in red for all the mandatory fields$")
    public void validationErrorsWillBeHighlightedInRedForAllTheMandatoryFields() throws Throwable {
        validationErrors.checkValidationErrorsForMandatoryFields();
    }

    @When("^he enters first name \"([^\"]*)\" and emailID \"([^\"]*)\"$")
    public void heEntersFirstNameAndEmailID(String fName, String emailAddr) throws Throwable {
        aboutYouSection.enterFirstName(fName);
        aboutYouSection.enterEmailID(emailAddr);
        aboutYouSection.selectTitle("Miss");
    }

    @Then("^validation errors will be highlighted in red for the name and emaiID fields$")
    public void validationErrorsWillBeHighlightedInRedForTheNameAndEmaiIDFields() throws Throwable {
        validationErrors.checkValidationErrorsForFNameandEmailID();
    }

    @When("^he selects date of birth with date \"([^\"]*)\" month \"([^\"]*)\" and year \"([^\"]*)\"$")
    public void heSelectsDateOfBirthWithDateMonthAndYear(String date, String month, String year) throws Throwable {
        aboutYouSection.selectDOB(date,month,year);
    }

    @Then("^a pop-up is displayed checking if the customer is (\\d+) years or over$")
    public void aPopUpIsDisplayedCheckingIfTheCustomerIsYearsOrOver(int age) throws Throwable {
        popUps.ageWarningPopUpisDisplayed();
    }

    @When("^he fills in invalid postcode \"([^\"]*)\"$")
    public void heFillsInInvalidPostcode(String postCode) throws Throwable {
        whereYouLiveSection.enterPostcode(postCode);
    }

    @And("^he clicks FindAddress$")
    public void heClicksFindAddress() throws Throwable {
        whereYouLiveSection.clickFindAddress();
    }

    @Then("^a validation error will be highlighted in red for the postcode field$")
    public void aValidationErrorWillBeHighlightedInRedForThePostcodeField() throws Throwable {
        validationErrors.checkValidationErrorForPostcode();
    }

}
