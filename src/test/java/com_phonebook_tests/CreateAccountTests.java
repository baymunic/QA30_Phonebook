package com_phonebook_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void registerExistedUserNegativeTest(){

        // click on Login Link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "monkys@info.com");

        // enter password
        type(By.name("password"), "Money10000$");

        // click on Registration button
        click(By.name("registration"));

        // assert Sign Out button is present
        Assert.assertTrue(isAlertPresent());
    }

}
