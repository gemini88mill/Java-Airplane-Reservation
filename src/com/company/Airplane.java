package com.company;

import java.util.ArrayList;
import java.util.Date;

/**
 * Public class Airplane. Airplane is used as the main class.
 * Airplane will accept a few perams, it has a Passenger, Seat, Flight departure and arrival dates and destinations.
 * Airplane main hub will be MIA, and for the first edition the airplane will fly to new york for a trip of about three
 * hours.
 *
 * Additionally, Airplane must be aware for the current date and time, as it need to take off at certain times of the
 * day. So the program must know the current time.
 */

public class Airplane {

    //Description objects
    private String airplaneName;

    //Location Objects
    private String airplaneArrivalLocation;
    private String airplaneDepartureLocation;

    //Seat Objects
    private String classNames[];
    private int numberOfSeatsPerClass[];
    private String planeType;
    private Seat seats[];

    //Class Description Objects
    private int airplaneRowDepthFirst;
    private int airplaneRowDepthBusiness;
    private int airplaneRowDepthEconomy;
    private int airplaneLengthFirst;
    private int airplaneLengthBusiness;
    private int airplaneLengthEconomy;


    //Time Objects
    private Date departureTime;
    private Date arrivalTime;

    public Airplane(String airplaneName, String airplaneArrivalLocation, String airplaneDepartureLocation,
                    String[] classNames, int[] numberOfSeatsPerClass, String planeType, Seat[] seats,
                    int airplaneRowDepthFirst, int airplaneRowDepthBusiness, int airplaneRowDepthEconomy) {

        this.airplaneName = airplaneName;
        this.airplaneArrivalLocation = airplaneArrivalLocation;
        this.airplaneDepartureLocation = airplaneDepartureLocation;
        this.classNames = classNames;
        this.numberOfSeatsPerClass = numberOfSeatsPerClass;
        this.planeType = planeType;
        this.seats = seats;
        this.airplaneRowDepthFirst = airplaneRowDepthFirst;
        this.airplaneRowDepthBusiness = airplaneRowDepthBusiness;
        this.airplaneRowDepthEconomy = airplaneRowDepthEconomy;
    }



    public void assignPassenger(Passenger passenger) {
        //assigns passenger to
        UI ui = new UI();
        ArrayList<Seat> availableSeats = new ArrayList<>();

        //todo add all the seats, negating the already occupied seats

        for(int x = 0; x < getSeats().length; x++){
            //add seats to ArrayList of seats.
            if(!getSeats()[x].isOccupied()){
                availableSeats.add(getSeats()[x]);
            }
        }



        //goes to dialog for seat selector
        //ui.seatSelectionPrompt(passenger, availableSeats);
        
        //tag passenger to seat on plane
        //mark seat as occupied
        //


    }

    public void seatConstructor(Seat[] seats) {
        for(int x = 0; x < seats.length; x++) seats[x] = new Seat(null, false, false, false, false, false);
    }



    public int airplaneSeatConstructor(Airplane airplane, String className, int numberOfSeats){
        /*Airplane Seat Creator, loops through the seats and attaches credentials to them based on the type of plane
        * being formed.*/

        //currently only one plane type. 777.
        //777 seat number 257
        //does have a first class section.

        char ch;
        int pos;
        int y = 0;
        int economyX = 0;
        for(int x = 0; x < 257; x++){

            //x = number of seat in total

            if(x < 8){
                y = firstClassSeatConstructor(x, y);
            } else if (x >= 8 && x < 40){
                y = businessClassSeatConstructor(x, y);
            } else {
                y = economyClassSeatConstructor(x, y, economyX);
                economyX++;
            }
        }

        return 0;

    }

    private int economyClassSeatConstructor(int x, int y, int economyX) {

        char ch;

        getSeats()[x].setOccupied(false);
        getSeats()[x].setFirstClass(false);
        getSeats()[x].setBusinessClass(false);

        if((x % 9) == 0 || (x % 9) == 8){
            getSeats()[x].setWindowSeat(true);
            getSeats()[x].setAisleSeat(false);
        } else if((x % 9) == 2 || (x % 9) == 3 || (x % 9) == 5 || (x % 9) == 6){
            getSeats()[x].setWindowSeat(false);
            getSeats()[x].setAisleSeat(true);
        } else {
            getSeats()[x].setAisleSeat(false);
            getSeats()[x].setWindowSeat(false);
        }

        //need to make x and y reset to account for the displacement in the economy class

        if((economyX % 9) <= 0){
            y++;
        }

        ch = (char) ('a' + economyX % 9);
        getSeats()[x].setSeatName(Integer.toString(y));
        String seatName = getSeats()[x].getSeatName() + ch;
        System.out.println(seatName.toUpperCase());
        getSeats()[x].setSeatName(seatName.toUpperCase());


        return y;
    }

    private int businessClassSeatConstructor(int x, int y) {
        char ch;

        getSeats()[x].setBusinessClass(true);
        getSeats()[x].setFirstClass(false);
        getSeats()[x].setOccupied(false);

        if ((x % 8) == 0 || (x % 8) == 7) {
            getSeats()[x].setWindowSeat(true);
            getSeats()[x].setAisleSeat(false);
        }
        //aisle seat marker
        else if((x % 8) == 1 || (x % 8) == 2 || (x % 8) == 5 || (x % 8) == 6){
            getSeats()[x].setWindowSeat(false);
            getSeats()[x].setAisleSeat(true);
        }
        //neither window or aisle seat marker
        else {
            getSeats()[x].setAisleSeat(false);
            getSeats()[x].setWindowSeat(false);
        }

        if((x % 8) <= 0){
            y++;
        }
        ch = (char) ('a' + x % 8);
        getSeats()[x].setSeatName(Integer.toString(y));
        String seatName = getSeats()[x].getSeatName() + ch;
        System.out.println(seatName.toUpperCase());
        getSeats()[x].setSeatName(seatName.toUpperCase());

        return y;
    }

    private int firstClassSeatConstructor(int x, int y) {
        char ch;

        getSeats()[x].setOccupied(false);
        getSeats()[x].setFirstClass(true);
        getSeats()[x].setBusinessClass(false);

        if ((x % 4) == 0 || (x % 4) == 3) {
            getSeats()[x].setWindowSeat(true);
            getSeats()[x].setAisleSeat(false);
        } else {
            getSeats()[x].setAisleSeat(true);
            getSeats()[x].setWindowSeat(false);
        }

        if((x % 4) <= 0){
            y++;
        }
        ch = (char) ('a' + x % 4);
        getSeats()[x].setSeatName(Integer.toString(y));
        String seatName = getSeats()[x].getSeatName() + ch;
        System.out.println(seatName.toUpperCase());
        getSeats()[x].setSeatName(seatName.toUpperCase());

        return y;
    }

    //---------------------------------getters and setters-------------------------------------------------------------

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getAirplaneArrivalLocation() {
        return airplaneArrivalLocation;
    }

    public void setAirplaneArrivalLocation(String airplaneArrivalLocation) {
        this.airplaneArrivalLocation = airplaneArrivalLocation;
    }

    public String getAirplaneDepartureLocation() {
        return airplaneDepartureLocation;
    }

    public void setAirplaneDepartureLocation(String airplaneDepartureLocation) {
        this.airplaneDepartureLocation = airplaneDepartureLocation;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public String[] getClassNames() {
        return classNames;
    }

    public void setClassNames(String[] classNames) {
        this.classNames = classNames;
    }

    public int[] getNumberOfSeatsPerClass() {
        return numberOfSeatsPerClass;
    }

    public void setNumberOfSeatsPerClass(int[] numberOfSeatsPerClass) {
        this.numberOfSeatsPerClass = numberOfSeatsPerClass;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getAirplaneRowDepthFirst() {
        return airplaneRowDepthFirst;
    }

    public void setAirplaneRowDepthFirst(int airplaneRowDepthFirst) {
        this.airplaneRowDepthFirst = airplaneRowDepthFirst;
    }

    public int getAirplaneRowDepthBusiness() {
        return airplaneRowDepthBusiness;
    }

    public void setAirplaneRowDepthBusiness(int airplaneRowDepthBusiness) {
        this.airplaneRowDepthBusiness = airplaneRowDepthBusiness;
    }

    public int getAirplaneRowDepthEconomy() {
        return airplaneRowDepthEconomy;
    }

    public void setAirplaneRowDepthEconomy(int airplaneRowDepthEconomy) {
        this.airplaneRowDepthEconomy = airplaneRowDepthEconomy;
    }

    public int getAirplaneLengthFirst() {
        return airplaneLengthFirst;
    }

    public void setAirplaneLengthFirst(int airplaneLengthFirst) {
        this.airplaneLengthFirst = airplaneLengthFirst;
    }

    public int getAirplaneLengthEconomy() {
        return airplaneLengthEconomy;
    }

    public void setAirplaneLengthEconomy(int airplaneLengthEconomy) {
        this.airplaneLengthEconomy = airplaneLengthEconomy;
    }

    public int getAirplaneLengthBusiness() {
        return airplaneLengthBusiness;
    }

    public void setAirplaneLengthBusiness(int airplaneLengthBusiness) {
        this.airplaneLengthBusiness = airplaneLengthBusiness;
    }
}
