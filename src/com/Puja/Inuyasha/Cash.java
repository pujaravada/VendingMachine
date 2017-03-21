package com.Puja.Inuyasha;

/**
 * Created by Puja on 3/20/17.
 */
public enum Cash {

    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

    private int denomination;
    private Cash(int denomination) {
        this.denomination = denomination;
    }
    public int getDenomination() {
        return denomination;
    }
}
