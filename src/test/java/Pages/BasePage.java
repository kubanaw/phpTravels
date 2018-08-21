package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class BasePage {

        protected final static Logger LOGGER = LogManager.getLogger(BasePage.class);

        //create random Strings, e-mails and numbers
        protected  String randomString = RandomStringUtils.randomAlphabetic(7, 10);
        protected  String randomEmail = randomString + "@nwytg.pl";
        private int numberOfDigits;

        protected String getRandomNumber (int numberOfDigits) {
                String randomNumber = RandomStringUtils.randomNumeric(numberOfDigits);
                return randomNumber;
        }




}
