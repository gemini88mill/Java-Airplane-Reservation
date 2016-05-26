package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gemin on 5/11/2016.
 *
 * User interface class, all thing related to the user interacting with the program go here.
 */
public class UI {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World");



        String[] classNames = {"FIRST", "BUSINESS", "ECONOMY", "SPECIAL"};
        int[] numberOfSeatsPerClass = {8, 40, 209};
        int totalSeats = 257;

        Airplane airplane = new Airplane("Boeing", "JFK", "MIA", classNames, numberOfSeatsPerClass, "777",
                new Seat[totalSeats], 4, 8, 9, 257);
        airplane.setAirplaneLengthFirst(2);
        airplane.setAirplaneLengthBusiness(5);
        airplane.setAirplaneLengthEconomy(26);

        airplane.seatConstructor(airplane.getSeats());

        int i = airplane.airplaneSeatConstructor(airplane, "FIRST", airplane.getNumberOfSeatsPerClass()[0]);
        airplane.sortSeats(airplane.getSeats());

        //airplane seats are now properly constructed and ready for purchase
        //System.out.println("i = " + i);

        System.out.println("Airplane: " + airplane.getAirplaneName());
        System.out.println("Depart: " + airplane.getAirplaneDepartureLocation());
        System.out.println("Arrive: " + airplane.getAirplaneArrivalLocation());
        System.out.println("Seats: "  + airplane.getSeats().length);
        System.out.println("");
        System.out.println("");

        //need a few methods for sorting seats to find them quickly
        //todo sorting method to find seats on airplanes


        //assign passenger to seat
        //airplane.assignPassenger(new Passenger("John Doe", "WINDOW", "FIRST", null));


    }


    public void seatSelectionPrompt(Passenger passenger, ArrayList<Seat> availableSeats) {
        Scanner scan = new Scanner(System.in);


    }
}
