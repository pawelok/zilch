package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AppiumHelper {
    private static final Logger LOG = LogManager.getLogger(AppiumHelper.class);

    public boolean isElementDisplayed(WebElement element) {
        int POOL_DELAY_MS = 100; // Delay between checks in milliseconds
        int MAX_ATTEMPTS = 10;  // Max number of attempts
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                if (element.isDisplayed()) {
                    LOG.info("Element is displayed after " + (i + 1) + " attempts");
                    return true;
                }
            } catch (Exception e) {
                LOG.error("Attempt " + (i + 1) + ": Error" + e.getMessage());
            }
            try {
                Thread.sleep(POOL_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.error("Attempt " + (i + 1) + ": Error" + e.getMessage());
                break;
            }
        }
        LOG.warn("Element was not displayed after " + MAX_ATTEMPTS + " attempts");
        return false;
    }
}
