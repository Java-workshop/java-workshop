package com.fan.jiang.mockito.entities;


/**
 * Created by fjiang on 2/20/17.
 */
public class Employee {

    private String name;
    private int age;
    private Address address;
    private Performance performance;

    public Employee() {
    }

    public Employee(final String name, final int age, final Address address, final Performance performance) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.performance = performance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Performance getPerformance() {
        return this.performance;
    }

    public void setPerformance(final Performance performance) {
        this.performance = performance;
    }
}
