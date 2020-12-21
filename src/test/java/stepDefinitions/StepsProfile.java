package stepDefinitions;

import dtos.Profile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProfilePage;
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
        Assert.assertEquals(TITLE_NOT_OBTAINED, TITLE_YOUR_SETTINGS, profilePage.getTitleContainerPage());
    }

    @And("the registered userName and Email are correctly displayed")
    public void theRegisteredUserNameAndEmailAreCorrectlyDisplayed() {
        Assert.assertEquals(USER_NAME_PROFILE_ERROR,Profile.getUserName(), profilePage.getValuerUserNameField());
        Assert.assertEquals(EMAIL_PROFILE_ERROR,Profile.getEmail(), profilePage.getValuerEmailField());
    }

    @Then("the profile information will be modified")
    public void theProfileInformationWillBeModified() {
        Profile.setUrlProfilePicture(FakerManager.getInstance().getFaker().internet().image());
        Profile.setUserName(FakerManager.getInstance().getFaker().name().username().replace(".", ""));
        Profile.setEmail(FakerManager.getInstance().getFaker().internet().emailAddress());
        Profile.setNewPassword(FakerManager.getInstance().getFaker().internet().password());
    }
}
