package com.fan.jiang.mockito.entities;

import com.fan.jiang.mockito.entities.exceptions.InvalidAddressException;
import com.fan.jiang.mockito.entities.exceptions.InvalidStreetException;

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

    public void checkStreet() {
        if (street.length() < 3) {
            throw new InvalidStreetException("The StreetName is too short");
        }
    }

    public void checkAddress() {
        try {
            checkStreet();
        } catch (Exception ex) {
            throw new InvalidAddressException("Address is invalid", ex);
        }
    }

    public void sayHi() {
        System.out.println("hi");
    }
}
