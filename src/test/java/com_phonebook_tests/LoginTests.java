package com_phonebook_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginRegisteredUserPositiveTest(){
        // click on Login Link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "monkys@info.com");

        // enter password
        type(By.name("password"), "Money10000$");

        // click on Login button
        click(By.name("login"));

        // Assert
        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
    }
}
