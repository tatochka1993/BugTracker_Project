package org.tatsiana.webapp.util;

public final class UserUtil {

    private UserUtil() { }

    public static boolean validateUserCredentials(String login, String password, String confirmPassword) {
        String loginTrim = login.trim();
        String passTrim = password.trim();
        String confirmTrim = confirmPassword.trim();

        return !(loginTrim.isEmpty() || passTrim.isEmpty() || confirmTrim.trim().isEmpty()
                || !passTrim.equals(confirmTrim));
    }

}
