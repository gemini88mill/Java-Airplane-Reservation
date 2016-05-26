package com.company;

import java.util.List;

/**
 * Created by gemin on 5/11/2016.
 */


public class Seat {

    private String seatName;
    private boolean isFirstClass;
    private boolean isBusinessClass;
    private boolean isWindowseat;
    private boolean isAisleSeat;
    private boolean isOccupied;

    //--------------------------------------constructors----------------------------------------------------------------

    public Seat(String seatName, boolean isFirstClass, boolean isBusinessClass, boolean isWindowseat,
                boolean isAisleSeat, boolean isOccupied) {
        this.seatName = seatName;
        this.isFirstClass = isFirstClass;
        this.isBusinessClass = isBusinessClass;
        this.isWindowseat = isWindowseat;
        this.isAisleSeat = isAisleSeat;
        this.isOccupied = isOccupied;
    }

    //todo effective sorting method for seats
    //inserts a seat into the trie
    public void insert(Seat seat){

    }

    public void search(){

    }

    public void startsWith(){

    }



    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        isBusinessClass = businessClass;
    }

    public boolean isWindowseat() {
        return isWindowseat;
    }

    public void setWindowSeat(boolean windowseat) {
        isWindowseat = windowseat;
    }

    public boolean isAisleSeat() {
        return isAisleSeat;
    }

    public void setAisleSeat(boolean aisleSeat) {
        isAisleSeat = aisleSeat;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
