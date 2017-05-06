package com.ip_b1.fii.admission.Controllers.Verify;

import java.util.regex.Pattern;

public class VerifyCNP {

    private static final String CNP_REGEX = "[1|2|3|4|5|6|9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
    private static final Pattern validCNPPattern = Pattern.compile(CNP_REGEX);

    public static boolean verify(String toVerify) {
        return validCNPPattern.matcher(toVerify).matches();
    }
}
