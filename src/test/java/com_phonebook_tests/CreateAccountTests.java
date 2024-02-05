package com_phonebook_tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

}
