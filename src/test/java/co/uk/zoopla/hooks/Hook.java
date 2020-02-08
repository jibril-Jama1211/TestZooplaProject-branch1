package co.uk.zoopla.hooks;

import co.uk.zoopla.common.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Browsers {

    @Before
    public void setUp()
    {
        launchBrowser("ChromeHeadless");
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
