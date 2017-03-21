package com.Puja.Inuyasha;

/**
 * Created by Puja on 3/20/17.
 */
public class Payment {

    int paymentid;
    String PaymentType;

    public Payment(int paymentid, String paymentType) {
        this.paymentid = paymentid;
        PaymentType = paymentType;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }
}
