package dictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class contains the error messages expected in the web application and those that will be displayed
 * in case of a failed validation
 */
public final class ErrorMessages {

    private ErrorMessages() {
    }

    /**
     * Expected error messages within the web application
     */
    public static final String USER_NAME_ALREADY_EXISTS = "username has already been taken";
    public static final String EMAIL_ALREADY_EXISTS = "email has already been taken";
    public static final String PASSWORD_SHORT_FLIED = "password is too short (minimum is 6 characters)";
    public static final List<String> FIELDS_CAN_NOT_BLANCK = Collections.unmodifiableList(Arrays.asList("username can't be blank", "password can't be blank", "email can't be blank"));
    public static final String FIELDS_LOGIN_BLANCK = "email or password can't be blank";
    public static final String FIELDS_LOGIN_INVALIDATE = "email or password is invalid";
    public static final String FIELDS_ARTICLES_BLANCK = "Article fields must not be blank";
    public static final String ARTICLES_DELETE_MSG = "The article was successfully removed";

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
    public static final String INVALID_DATA = "Invalid data error message is not displayed";
    public static final String DO_NOT_SHOW_EDITOR_PANEL = "The article creation or editing panel is not displayed";
    public static final String ARTICLE_TITLE_ERROR = "The title of the article obtained was not what was expected";
    public static final String ARTICLE_CONTENT_ERROR = "The content of the article obtained was not what was expected";
    public static final String ARTICLE_DELETE_ERROR = "No successful article removal message was displayed";
    public static final String ARTICLE_NOT_FOUND_GLOBAL_FEED = "The article was not obtained in global feed";


}
