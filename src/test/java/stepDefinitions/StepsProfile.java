package stepDefinitions;

import dtos.Profile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProfilePage;
import utils.DataManager;
import utils.FakerManager;

import static dictionary.ErrorMessages.*;
import static dictionary.WebApplicationTexts.TITLE_YOUR_SETTINGS;

/**
 * Class containing the steps Definitions of the Sign Up scenarios
 */
public class StepsProfile {

    private ProfilePage profilePage;

    public StepsProfile() {
        this.profilePage = new ProfilePage();
    }

    @And("the system displays the profile edit form")
    public void theSystemDisplaysTheProfileEditForm() {
        Assert.assertEquals(TITLE_NOT_OBTAINED, TITLE_YOUR_SETTINGS, profilePage.getTitleYourSettings());
    }

    @And("the registered userName and Email are correctly displayed")
    public void theRegisteredUserNameAndEmailAreCorrectlyDisplayed() {
        Assert.assertEquals(USER_NAME_PROFILE_ERROR, DataManager.getInstance().getProfile().getUserName(), profilePage.getValuerUserNameField());
        Assert.assertEquals(EMAIL_PROFILE_ERROR, DataManager.getInstance().getProfile().getEmail(), profilePage.getValuerEmailField());
    }

    @Then("the profile information will be modified")
    public void theProfileInformationWillBeModified() {
        profilePage.clearProfileFlieds();
        Profile profile = new Profile();
        profile.setUrlProfilePicture(FakerManager.getInstance().getFaker().internet().avatar());
        profile.setUserName(FakerManager.getInstance().getFaker().name().username().replace(".", ""));
        profile.setBiography(FakerManager.getInstance().getFaker().name().fullName());
        profile.setEmail(FakerManager.getInstance().getFaker().internet().emailAddress());
        profile.setNewPassword(FakerManager.getInstance().getFaker().internet().password());
        profilePage.sendTextUrlProfilePictureField(profile.getUrlProfilePicture());
        profilePage.sendTextUserNameField(profile.getUserName());
        profilePage.sendTextBiographyField(profile.getBiography());
        profilePage.sendTextEmailField(profile.getEmail());
        profilePage.sendTextNewPasswordField(profile.getNewPassword());
        DataManager.getInstance().setProfile(profile);
    }

    @And("updated information persists in fields")
    public void updatedInformationPersistsInFields() {
        Assert.assertEquals(URL_PROFILE_PICTURE_ERROR, DataManager.getInstance().getProfile().getUrlProfilePicture(), profilePage.getValueUrlProfilePictureField());
        Assert.assertEquals(USER_NAME_PROFILE_ERROR, DataManager.getInstance().getProfile().getUserName(), profilePage.getValuerUserNameField());
        Assert.assertEquals(BIOGRAPHY_PROFILE_ERROR, DataManager.getInstance().getProfile().getBiography(), profilePage.getTextBiographyField());
        Assert.assertEquals(EMAIL_PROFILE_ERROR, DataManager.getInstance().getProfile().getEmail(), profilePage.getValuerEmailField());
    }

    @And("clear required fields")
    public void clearRequiredFields() {
        profilePage.clearProfileFlieds();
    }

    @Then("I click on the log out button")
    public void iClickOnTheLogOutButton() {
        profilePage.clickLogOutButton();
    }
}
