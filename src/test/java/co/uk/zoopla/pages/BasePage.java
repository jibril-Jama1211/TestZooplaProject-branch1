package co.uk.zoopla.pages;

import co.uk.zoopla.common.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Driver
{
    public String BASE_URL = "https://www.zoopla.co.uk/";
    public Select select;

    public void launchUrl()
    {
        driver.navigate().to(BASE_URL);
    }

    public void selectByText(WebElement element, String text)
    {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value)
    {
        select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int index)
    {
        select = new Select(element);
        select.selectByIndex(index);
    }

}
