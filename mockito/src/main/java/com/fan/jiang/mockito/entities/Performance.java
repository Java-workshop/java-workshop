package com.fan.jiang.mockito.entities;

/**
 * Created by fjiang on 2/28/17.
 */
public class Performance {
    private double note;

    public Performance(final double note) {
        this.note = note;
    }

    public double getNote() {
        return this.note;
    }

    public void setNote(final double note) {
        this.note = note;
    }
}
