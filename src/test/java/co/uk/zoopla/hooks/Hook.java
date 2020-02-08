package co.uk.zoopla.hooks;

import co.uk.zoopla.common.Browsers;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Hook extends Browsers {

    public Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;

        launchBrowser("ChromeHeadless");
    }

    @After
    public void tearDown() {

        String dateNow = new SimpleDateFormat("ddMMyy").format(new GregorianCalendar().getTime());
        String timeNow = new SimpleDateFormat("HHmmss").format(new GregorianCalendar().getTime());

        String fileName = String.format("screenshot_%s.png", timeNow);


        if (scenario.isFailed()) {
            try {
                byte[] screeshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screeshot, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        closeBrowser();
    }
}