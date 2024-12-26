package seleniumCore;

import fileReaders.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;


public class CoreTest {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"browser"})
    public void beforeMethod(@Optional("optional") String browser) {
        System.out.println("Calling inside Core Test Test ");
        PropertyReader.setProperty(CoreConstants.pathToPropertyFile);
        CoreVariables.setBrowser(browser);
        boolean hasQuit = false;
        if (getDriver() != null) {
            hasQuit = getDriver().toString().contains("(null)");
            if (hasQuit)
                DriverFactory.setDrivers(CoreVariables.getBrowser());
        } else
            DriverFactory.setDrivers(CoreVariables.getBrowser());
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        try {
            String quitAfterEachTest = System.getProperty(CoreProperties.quitAfterEachTest);
            if (quitAfterEachTest.contains("true"))
                DriverFactory.closeBrowser();
            if (quitAfterEachTest.isEmpty())
                DriverFactory.closeBrowser();
        } catch (NullPointerException e) {
            logger.info("quitAfterEachTest is not mentioned, Need to quit the browser in after method");
            DriverFactory.closeBrowser();
        }
    }


    public void afterSuite() {
        if (getDriver() != null)
            DriverFactory.closeBrowser();
    }

}
