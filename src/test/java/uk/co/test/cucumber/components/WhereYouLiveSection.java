package uk.co.test.cucumber.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WhereYouLiveSection extends PageObject{

    @FindBy(id = "capitalone:smart-search-app:residential02:cc_residential_status")
    private WebElement residentialStatus;

    @FindBy(id = "capitalone:smart-search-app:AddressSearch:as_postcode")
    private WebElement postcode;

    @FindBy(id = "capitalone:smart-search-app:residential02:cc_curr_addr_years")
    private WebElement yearsOfResidence;

    @FindBy(id = "capitalone:smart-search-app:AddressSearch:asBeansearch")
    public WebElement findAddressBtn;

    @FindBy(id = "capitalone:smart-search-app:addressPick:as_pick")
    private WebElement addressLookUpList;

    @FindBy(id = "capitalone:smart-search-app:addressPick:asBeanselect")
    private WebElement confirmAddress;

    public void selectResedentialStatus(String resdStatusValue){
        Select iSelect = new Select(residentialStatus);
        iSelect.selectByVisibleText(resdStatusValue);
    }

    public void selectYearsAtCurrAddr(String yearsOfResd){
        Select iSelect = new Select(yearsOfResidence);
        iSelect.selectByValue(yearsOfResd);
    }

    public void enterPostcode(String postCodevalue){
        postcode.clear();
        postcode.sendKeys(postCodevalue);
    }

    public void clickFindAddress(){

        findAddressBtn.click();
    }

    public void selectCurrentAddress(int addrValue){
        Select iSelect = new Select(addressLookUpList);
        iSelect.selectByIndex(addrValue);

        element(confirmAddress).waitUntilClickable().click();
    }

}

