package dtos;

public class Profile {
    private static String urlProfilePicture = "";
    private static String userName = "";
    private static String biography = "";
    private static String email = "";
    private static String newPassword = "";

    public static String getUrlProfilePicture() {
        return urlProfilePicture;
    }

    public static void setUrlProfilePicture(String urlProfilePicture) {
        Profile.urlProfilePicture = urlProfilePicture;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Profile.userName = userName;
    }

    public static String getBiography() {
        return biography;
    }

    public static void setBiography(String biography) {
        Profile.biography = biography;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Profile.email = email;
    }

    public static String getNewPassword() {
        return newPassword;
    }

    public static void setNewPassword(String newPassword) {
        Profile.newPassword = newPassword;
    }
}
