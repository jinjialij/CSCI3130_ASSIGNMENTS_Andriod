package ca.dal.cs.csci3130.a2;

import java.util.regex.Pattern;

public class ValidationHelper {
    private static  Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static  String usernamePattern = ("^.*[^a-zA-Z0-9 ].*$");

    public static boolean isValidName(String input){
        if (input.matches(usernamePattern)){
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String input){
        if (!emailRegex.matcher(input).find()){
            return false;
        }
        return true;
    }
}
