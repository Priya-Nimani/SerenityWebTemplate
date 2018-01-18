package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WorkAndFinancesSection extends PageObject{

    @FindBy(id = "capitalone:smart-search-app:employment-info:cc_empstatus")
    private WebElement empStatus;

    @FindBy(id = "capitalone:smart-search-app:employment-info:cc_occupation")
    private WebElement occupation;

    @FindBy(id = "capitalone:smart-search-app:employment-info:cc_grossincome")
    private WebElement grossincome;

    @FindBy(id = "capitalone:smart-search-app:employment-info:cc_cash_advance:0")
    private WebElement cashAdvanceYes;

    @FindBy(id = "capitalone:smart-search-app:employment-info:cc_cash_advance:1")
    private WebElement cashAdvanceNo;

    public void selectEmploymentStatus(String empStatusValue){
        Select iSelect = new Select(empStatus);
        iSelect.selectByVisibleText(empStatusValue);
    }

    public void enterOccupation(String occupationValue){
        occupation.clear();
        occupation.sendKeys(occupationValue);
    }

    public void enterYearlyIncome(String yearlyIncome){
        grossincome.clear();
        grossincome.sendKeys(yearlyIncome);
    }
}
