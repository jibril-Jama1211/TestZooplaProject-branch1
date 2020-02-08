package co.uk.zoopla.hooks;

import co.uk.zoopla.common.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Browsers {

    @Before
    public void setUp()
    {
        launchBrowser("Chrome");
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
