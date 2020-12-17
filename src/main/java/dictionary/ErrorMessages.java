package dictionary;

import java.util.Arrays;
import java.util.List;

public final class ErrorMessages {

    private ErrorMessages() {
    }

    /**
     * Expected error messages within the web application
     */
    public static final String USER_NAME_ALREADY_EXISTS = "username has already been taken";
    public static final String EMAIL_ALREADY_EXISTS = "email has already been taken";
    public static final String PASSWORD_SHORT_FLIED = "password is too short (minimum is 6 characters)";
    public static final List<String> FIELDS_CAN_NOT_BLANCK= Arrays.asList("username is invalidcan't be blank", "password can't be blank", "email can't be blank");

    /**
     * Error messages that will be displayed in Asserts
     */
    public static final String TITLE_NOT_OBTAINED = "The expected title was not obtained";
    public static final String EMAIL_EXISTING = "Error message for existing email not found";
    public static final String EMAIL_ERROR_MSG = "The error message in the mail field is not what is expected";
    public static final String EMAIL_STATUS_ERROR_MSG = "The state of the field is not as expected";
    public static final String USER_NAME_EXISTING = "Error message for existing user name not found";
    public static final String PASSWORD_SHORT = "Error message for short password not found";
    public static final String PASSWORD_ERROR_MSG = "Password is seen when inspecting password field";
    public static final String FIELDS_BLANCK = "The messages obtained do not correspond to those expected from blank fields";


}
