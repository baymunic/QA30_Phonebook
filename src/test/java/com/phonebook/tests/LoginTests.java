package com.phonebook.tests;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){

        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest(){

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User().setEmail("monkys@info.com")
                .setPassword("Money10000$"));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("button")));
    }
    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail(){

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User()
                .setPassword("Money10000$"));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
