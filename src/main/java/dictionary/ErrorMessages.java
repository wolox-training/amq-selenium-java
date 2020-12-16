package dictionary;

import java.util.Arrays;
import java.util.List;

public class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String EMAIL_INVALID_FORMAT_AT = "Incluye un signo \"@\" en la dirección de correo electrónico. La dirección \"%s\" no incluye el signo \"@\".";
    public static final String USER_NAME_ALREADY_EXISTS = "username has already been taken";
    public static final String EMAIL_ALREADY_EXISTS = "email has already been taken";
    public static final String PASSWORD_SHORT = "password is too short (minimum is 6 characters)";


    public static List<String> getUserNameCanNotBlank() {
        return Arrays.asList("username is invalidcan't be blank", "password can't be blank", "email can't be blank");
    }

}
