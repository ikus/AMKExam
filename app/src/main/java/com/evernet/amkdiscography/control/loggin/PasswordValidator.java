package com.evernet.amkdiscography.control.loggin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class PasswordValidator {
    public static String REGEX_PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

    public static synchronized PasswordValidator getInstance() {
        return new PasswordValidator();
    }

    private Pattern pattern;
    private Matcher matcher;


    public PasswordValidator() {
        pattern = Pattern.compile(REGEX_PASSWORD);
    }

    /**
     * Validate hex with regular expression
     *
     * @param mail mail for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String mail) {

        matcher = pattern.matcher(mail);
        return matcher.matches();

    }
}
