package com.company;

/**
 * Created by gemin on 5/11/2016.
 *
 * Passenger class, All information that the passenger has is displayed here.
 */
public class Passenger {

    private String passengerLuggageCount;
    private String passengerMealOption;
    private boolean isFirstClass;

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

    public void assignPassengerToSeat(Passenger passenger, Seat[] seat, Airplane airplane){
        //gets passenger information and assigns passenger to the seats available

        //check if seat is occupied
        Seat[] availableSeats = new Seat[airplane.getAirplaneMaxSeats()];

        for (int i = 0; i < seat.length; i++){
            if(!seat[i].isOccupied()){

            }
        }

        //check passenger credentials
        //show seats available
        //mark seat for passenger
        //mark seat as occupied.
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
}
