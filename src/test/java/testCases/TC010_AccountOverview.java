package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsOverviewPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC010_AccountOverview extends BaseClass {

    @Test
    public void verifyAccountOverview() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        AccountsOverviewPage aop = new AccountsOverviewPage(driver);

        // Login
        lp.setUsername(p.getProperty("UsernameID"));
        lp.setPassword(p.getProperty("UserPasswordId"));
        lp.clickSubmit();
        logger.info("Logged in successfully");

        // Select first account
        String accountNum = aop.getFirstAccountNumber();
        logger.info("First account found: " + accountNum);
        aop.clickFirstAccount();
        logger.info("Clicked on first account successfully");

        // Verify account details page
        Assert.assertEquals(aop.getAccountDetailsHeading(), "Account Details");

        // --- Debit transactions ---
        aop.filterTransactions("September", "Debit");
        Thread.sleep(2000);

        if (aop.hasTransactions()) {
            // Click first transaction
            aop.clickTransactionByIndex(1);
            Thread.sleep(1000);
            Assert.assertTrue(aop.isTransactionDetailsDisplayed(), "Transaction Details page not displayed");
            System.out.println("Debit transaction verified: " + aop.getTransactionDetailsHeading());
        } else {
            System.out.println("No Debit transactions found for September.");
        }

        // Navigate back and click a random transaction
        driver.navigate().back();
        if (aop.hasTransactions()) {
            aop.clickTransactionByIndex(5);
            Thread.sleep(1000);
        }

        // --- Credit transactions---
        driver.navigate().back();
        aop.filterTransactions("October", "Credit");
        Thread.sleep(2000);

        if (aop.hasTransactions()) {
            aop.clickTransactionByIndex(1); // click first if exists
            Thread.sleep(1000);
            Assert.assertTrue(aop.isTransactionDetailsDisplayed(), "Transaction Details page not displayed");
            System.out.println("Credit transaction verified: " + aop.getTransactionDetailsHeading());
        } else {
            System.out.println("No Credit transactions found for October.");
        }
    }
}
