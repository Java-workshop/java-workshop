package com.fan.jiang.mockito.entities;

/**
 * Created by fjiang on 2/28/17.
 */
public class Address {
    private String street;
    private String number;

    public Address(final String street, final String number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }
}
