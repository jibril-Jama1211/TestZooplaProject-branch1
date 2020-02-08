package co.uk.zoopla.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(id = "search-submit")
    private WebElement searchButton;

    public void enterLocation(String location)
    {
        locationField.clear();
        locationField.sendKeys(location);
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
