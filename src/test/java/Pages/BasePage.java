package Pages;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.logging.Logger;

public abstract class BasePage {
        //TODO all pages inherit from basepage

        protected final static Logger LOGGER = Logger.getLogger(BasePage.class.getName());
        protected  String randomString = RandomStringUtils.randomAlphabetic(7, 10);
        protected  String randomEmail = randomString + "@nwytg.pl";


}
