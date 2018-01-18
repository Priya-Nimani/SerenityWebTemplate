package uk.co.test.cucumber.globalTasks;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalMethods {

    public HomePage homePage;

    public void navigateToHomepage(){

        homePage.open();
        checkPageTitle("Which credit card is right for you? - Capital One");
    }

    public void checkPageTitle(String expectedPageTitle){

        waitForPageToLoad();

        String actualPageTitle = homePage.getTitle();
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }

    public void waitForPageToLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(homePage.getDriver(), 120);
        wait.until(pageLoadCondition);
    }

}
