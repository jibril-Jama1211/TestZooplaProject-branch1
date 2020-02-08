package co.uk.zoopla.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-input-location")
    private WebElement locationField;
    @FindBy(id = "forsale_price_min")
    private WebElement minPrice;
    @FindBy(css = ".button.button--primary")
    private WebElement searchButton;
    @FindBy(className = "ui-menu-item")
    private List<WebElement> autoComplte;
    @FindBy (id = "search-tabs-house-prices" )
    private WebElement housePrices;
    @FindBy (id = "search-tabs-for-sale")
    private WebElement forSaleTab;

    private void clickOnHousePricesTab ()
    {

        housePrices.click();
    }

    private void clickOnForSaleTab ()
    {

        forSaleTab.click();
    }
    private void  clickOnAutoCompleteOption()
    {

        javaScriptClick(autoComplte.get(0));
        //autoComplte.get(0).click();
    }
    public void enterLocation(String location)
    {
        locationField.clear();
        locationField.sendKeys(location);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        clickOnAutoCompleteOption();

        clickOnHousePricesTab();
        clickOnForSaleTab();
    }

    public void selectMinimumPrice(String miniPrice)
    {
        selectByText(minPrice, miniPrice);
    }

    public SearchResultPage clickOnSearchButton()
    {
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
