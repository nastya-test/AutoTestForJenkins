package cucumber.steps;

import data.generator.UserGenerator;
import static cucumber.pageobjects.mainPage.LoginPage.*;

public class Authorize {

    public static void authorized(){
            loginButton.click();
            loginField.click();
            loginField.setValue(UserGenerator.validUserLogin());
            signInButton.click();
            passwordField.click();
            passwordField.setValue(UserGenerator.validUserPassword());
            signInButton.click();
    }
}
