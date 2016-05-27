package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemin on 5/11/2016.
 *
 * Passenger class, All information that the passenger has is displayed here.
 */
public class Passenger {

    private String passengerLuggageCount;
    private String passengerMealOption;
    private boolean isFirstClass;
    private boolean isBusinessClass;
    private boolean isWindowSeat;
    private boolean isAisle;

    private String passengerName;
    private String passengerSeatRequest; //aisle window or neither
    private String passengerClassPreference; //economy, business, or first
    private String passengerSeatAssignment;


    //--------------------------------------constructors----------------------------------------------------------------

    public Passenger(String passengerMealOption, boolean isFirstClass, String passengerLuggageCount) {
        this.passengerMealOption = passengerMealOption;
        this.isFirstClass = isFirstClass;
        this.passengerLuggageCount = passengerLuggageCount;
    }

    public Passenger(String passengerName, String passengerSeatRequest, String passengerClassPreference,
                     String passengerSeatAssignment) {
        this.passengerName = passengerName;
        this.passengerSeatRequest = passengerSeatRequest;
        this.passengerClassPreference = passengerClassPreference;
        this.passengerSeatAssignment = passengerSeatAssignment;
    }
    //------------------------------------------------------------------------------------------------------------------

    public void assignPassengerToSeat(Passenger passenger, Seat[] seat, Airplane airplane) {
        //gets passenger information and assigns passenger to the seats available

        classLabeler(passenger);

        //check if seat is occupied
        Seat[] availableSeats = new Seat[airplane.getAirplaneMaxSeats()];

        for (int i = 0; i < seat.length; i++) {

            //if seat is not occupied, put seats in available seats
            if (!seat[i].isOccupied()) {
                availableSeats[i] = seat[i];
            }

        }

        //Seat[] classSpecificSeats = new Seat[availableSeats.length];
        List<Seat> classSeats = new ArrayList<>();

        for (int i = 0; i < availableSeats.length; i++) {
            if (availableSeats[i].isFirstClass() == passenger.isFirstClass()) {
                if (availableSeats[i].isWindowseat() == passenger.isWindowSeat() || availableSeats[i].isAisleSeat() == passenger.isAisle()) {
                    classSeats.add(availableSeats[i]);
                }
            }
            if (availableSeats[i].isBusinessClass() == passenger.isBusinessClass()) {
                if (availableSeats[i].isWindowseat() == passenger.isWindowSeat() || availableSeats[i].isAisleSeat() == passenger.isAisle()) {
                    classSeats.add(availableSeats[i]);
                }
            } else {
                if (availableSeats[i].isWindowseat() == passenger.isWindowSeat() || availableSeats[i].isAisleSeat() == passenger.isAisle()) {
                    classSeats.add(availableSeats[i]);
                }

            }
            //ex: Passenger(Joe smith, window, first, null)
            //ex: Seat(1A, First Class, Window)

            //check passenger credentials

            //show seats available
            //mark seat for passenger
            //mark seat as occupied.
        }
    }

    private void classLabeler(Passenger passenger) {
        switch(passenger.getPassengerClassPreference()){
            case "FIRST":
                setFirstClass(true);
                setBusinessClass(false);
                break;
            case "BUSINESS":
                setFirstClass(false);
                setBusinessClass(true);
                break;
            case "ECONOMY":
                setFirstClass(false);
                setBusinessClass(false);
                break;
            default:
                System.err.println("Improper Selection, please check passenger credentials");
                break;
        }

        switch (passenger.getPassengerSeatRequest()){
            case "WINDOW":
                setAisle(false);
                setWindowSeat(true);
                break;
            case "AISLE":
                setAisle(true);
                setWindowSeat(false);
                break;
            case "NA":
                setAisle(false);
                setWindowSeat(false);
                break;
            default:
                System.err.println("Improper Selection, please check passenger credentials");
                break;
        }
    }

    private Seat checkSeatSelection(String passengerClassPreference, Seat[] availableSeats, Passenger passenger) {

        return null;
    }


    //---------------------------getters and setters--------------------------------------------------------------------

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerLuggageCount() {
        return passengerLuggageCount;
    }

    public void setPassengerLuggageCount(String passengerLuggageCount) {
        this.passengerLuggageCount = passengerLuggageCount;
    }

    public String getPassengerSeatRequest() {
        return passengerSeatRequest;
    }

    public void setPassengerSeatRequest(String passengerSeatRequest) {
        this.passengerSeatRequest = passengerSeatRequest;
    }

    public String getPassengerMealOption() {
        return passengerMealOption;
    }

    public void setPassengerMealOption(String passengerMealOption) {
        this.passengerMealOption = passengerMealOption;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }

    public String getPassengerClassPreference() {
        return passengerClassPreference;
    }

    public void setPassengerClassPreference(String passengerClassPreference) {
        this.passengerClassPreference = passengerClassPreference;
    }

    public String getPassengerSeatAssignment() {
        return passengerSeatAssignment;
    }

    public void setPassengerSeatAssignment(String passengerSeatAssignment) {
        this.passengerSeatAssignment = passengerSeatAssignment;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        isBusinessClass = businessClass;
    }

    public boolean isWindowSeat() {
        return isWindowSeat;
    }

    public void setWindowSeat(boolean windowSeat) {
        isWindowSeat = windowSeat;
    }

    public boolean isAisle() {
        return isAisle;
    }

    public void setAisle(boolean aisle) {
        isAisle = aisle;
    }
}
