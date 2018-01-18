package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AboutYouSection extends PageObject{

    @FindBy(id = "capitalone:smart-search-app:personal:cc_title")
    private WebElement title;

    @FindBy(id = "capitalone:smart-search-app:personal:cc_fname")
    private WebElement firstName;

    @FindBy(id = "capitalone:smart-search-app:personal:cc_sname")
    private WebElement lastName;

    @FindBy(id ="capitalone:smart-search-app:personal:cc_email_address")
    private WebElement emailID;

    @FindBy(id ="capitalone:smart-search-app:personal:cc_dob_day")
    private WebElement dobDay;

    @FindBy(id ="capitalone:smart-search-app:personal:cc_dob_month")
    private WebElement dobMonth;

    @FindBy(id ="capitalone:smart-search-app:personal:cc_dob_year")
    private WebElement dobYear;


    public void selectTitle(String titleValue){
        Select iSelect = new Select(title);
        iSelect.selectByValue(titleValue);
    }

    public void enterFirstName(String name){
        firstName.clear();
        firstName.sendKeys(name);
    }

    public void enterLastName(String name){
        lastName.clear();
        lastName.sendKeys(name);
    }

    public void enterEmailID(String email){
        emailID.clear();
        emailID.sendKeys(email);
    }

    public void selectDOB(String date, String month, String year){
        Select iSelect = new Select(dobDay);
        iSelect.selectByValue(date);

        iSelect = new Select(dobMonth);
        iSelect.selectByVisibleText(month);

        iSelect = new Select(dobYear);
        iSelect.selectByValue(year);
    }

}