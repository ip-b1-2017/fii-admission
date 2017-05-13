package com.ip_b1.fii.admission.Verify;

import java.util.regex.Pattern;

public class VerifyUsername {

    private static final String USERNAME_REGEX = "[A-z]([A-z]|[0-9]|_|-){4,50}";
    static private Pattern validUsernamePattern = Pattern.compile(USERNAME_REGEX);

    public static boolean verify(String toVerify){
        return validUsernamePattern.matcher(toVerify).find();
    }
}
