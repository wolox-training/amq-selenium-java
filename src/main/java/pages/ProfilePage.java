package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the register form
 */
public class ProfilePage extends SignUpPage {

    @FindBy(xpath = "//div[@class='container page']//h1[text()='Your Settings']")
    private WebElement titleProfilePage;

    @FindBy(xpath = "//input[@placeholder='URL of profile picture']")
    private WebElement inputUrlProfilePicture;

    @FindBy(xpath = "//textarea[@placeholder='Short bio about you']")
    private WebElement inputBiography;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    private WebElement inputNewPassword;

    @FindBy(xpath = "//button[normalize-space()='Or click here to logout.']")
    private WebElement buttonLogOut;


    public ProfilePage() {
        super();
    }

    public String getTitleYourSettings() {
        return getTextElement(titleProfilePage);
    }

    public void sendTextUrlProfilePictureField(String urlPicture) {
        sendKeystoElement(inputUrlProfilePicture, urlPicture);
    }

    public void sendTextBiographyField(String biography) {
        sendKeystoElement(inputBiography, biography);
    }

    public void sendTextNewPasswordField(String password) {
        sendKeystoElement(inputNewPassword, password);
    }

    public void clicLogOutButton(){
        clickElement(buttonLogOut);
    }

}
