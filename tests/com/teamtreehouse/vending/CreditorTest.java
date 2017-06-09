package com.teamtreehouse.vending;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        // Arrange Phase
        // Creditor creditor = new Creditor();

        // Act Phase
        creditor.addFunds(25);
        creditor.addFunds(25);

        // Assert Phase
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test(expected = NotEnoughFundsException.class)
    public void deductingMoreMoneyThenAvailableFunds() throws Exception {
        creditor.addFunds(50);
        creditor.deduct(75);
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
    }

    @Test
    public void refundingResetsAvailableFundsToZero() throws Exception {
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }
}