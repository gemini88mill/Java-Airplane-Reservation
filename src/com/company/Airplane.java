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

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");

        String[] classNames = {"FIRST", "BUSINESS", "ECONOMY", "SPECIAL"};
        int[] numberOfSeatsPerClass = {8, 40, 209};
        int totalSeats = 257;

        Airplane airplane = new Airplane("Boeing", "JFK", "MIA", classNames, numberOfSeatsPerClass, "777",
                new Seat[totalSeats], 4, 8, 9);
        airplane.setAirplaneLengthFirst(2);
        airplane.setAirplaneLengthBusiness(5);
        airplane.setAirplaneLengthEconomy(26);

        seatConstructor(airplane.getSeats());

        int i = airplane.airplaneSeatConstructor(airplane, "FIRST", airplane.getNumberOfSeatsPerClass()[0]);

        //airplane seats are now properly constructed and ready for purchase
        //System.out.println("i = " + i);

        System.out.println("Airplane: " + airplane.getAirplaneName());
        System.out.println("Depart: " + airplane.getAirplaneDepartureLocation());
        System.out.println("Arrive: " + airplane.getAirplaneArrivalLocation());
        System.out.println("Seats: "  + airplane.getSeats().length);
        System.out.println("");
        System.out.println("");

        //assign passenger to seat
        airplane.assignPassenger(new Passenger("John Doe", "WINDOW", "FIRST", null));


    }

    private void assignPassenger(Passenger passenger) {
        //assigns passenger to seat
        ArrayList<Seat> AvailableSeats = new ArrayList<>();

        //todo add all the seats, negating the already occupied seats
        
        //tag passenger to seat on plane
        //mark seat as occupied
        //


    }

    private static void seatConstructor(Seat[] seats) {
        for(int x = 0; x < seats.length; x++) seats[x] = new Seat(null, false, false, false, false, false);
    }



    private int airplaneSeatConstructor(Airplane airplane, String className, int numberOfSeats){
        /*Airplane Seat Creator, loops through the seats and attaches credentials to them based on the type of plane
        * being formed.*/

        //currently only one plane type. 777.
        //777 seat number 257
        //does have a first class section.

        char ch;
        int pos;
        int y = 0;
        for(int x = 0; x < 257; x++){
            if(x < 8){
                y = firstClassSeatConstructor(x, y);
            } else if (x >= 8 && x < 40){
                y = businessClassSeatConstructor(x, y);
            } else {
                y = economyClassSeatConstructor(x, y);
            }
        }


//        //todo refactor based on classes instead of one lump sum of places.
//        //System.out.println("iteration");
//        if(className.equals("TERM")){
//            return 1;
//        }else {
//            if (className.equals("FIRST")) {
//                for (int x = 0; x < numberOfSeats; x++) {
//                    airplane.getSeats()[x].setOccupied(false);
//                    airplane.getSeats()[x].setFirstClass(true);
//                    airplane.getSeats()[x].setBusinessClass(false);
//
//                    if ((x % 4) == 0 || (x % 4) == 3) {
//                        airplane.getSeats()[x].setWindowSeat(true);
//                        airplane.getSeats()[x].setAisleSeat(false);
//                    } else {
//                        airplane.getSeats()[x].setAisleSeat(true);
//                        airplane.getSeats()[x].setWindowSeat(false);
//                    }
//
//                    //todo make new method that preforms this arbitrarily
//
////                    if((x % 4) == 0){
////                        y++;
////                    }
////                        ch = (char) ('a' + x % 4);
////                        airplane.getSeats()[x].setSeatName(Integer.toString(y));
////                        String seatName = airplane.getSeats()[x].getSeatName() + ch;
////                        //System.out.println(seatName.toUpperCase());
////                        airplane.getSeats()[x].setSeatName(seatName.toUpperCase());
//
////                    if(x / airplane.getAirplaneRowDepthFirst() == 0){
////                        ch = (char) ('a' + x % 4);
////                        airplane.getSeats()[x].setSeatName("1");
////                        String seatName = airplane.getSeats()[x].getSeatName() + ch;
////                        //System.out.println(seatName.toUpperCase());
////                        airplane.getSeats()[x].setSeatName(seatName.toUpperCase());
////                    } else if(x / airplane.getAirplaneRowDepthFirst() == 1){
////                        ch = (char) ('a' + (x % 4));
////                        airplane.getSeats()[x].setSeatName("2");
////                        String seatName = airplane.getSeats()[x].getSeatName() + ch;
////                        //System.out.println(seatName.toUpperCase());
////                        airplane.getSeats()[x].setSeatName(seatName.toUpperCase());
////                    }
//                }
//                //System.out.println("in first");
//                return airplaneSeatConstructor(airplane, "BUSINESS", 40);
//            }
//            if (className.equals("BUSINESS")) {
//                //y = airplane.airplaneLengthFirst;
//                for (int x = 0; x < numberOfSeats; x++) {
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setBusinessClass(true);
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setFirstClass(false);
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setOccupied(false);
//
////                    //window seat marker
////                    if ((x % 8) == 0 || (x % 8) == 7) {
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setWindowSeat(true);
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setAisleSeat(false);
////                    }
////                    //aisle seat marker
////                    else if((x % 8) == 1 || (x % 8) == 2 || (x % 8) == 5 || (x % 8) == 6){
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setWindowSeat(false);
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setAisleSeat(true);
////                    }
////                    //neither window or aisle seat marker
////                    else {
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setAisleSeat(false);
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setWindowSeat(false);
////                    }
//
//                    if((x % 8) == 0){
//                        y++;
//                    }
//                    ch = (char) ('a' + x % 8);
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setSeatName(Integer.toString(y));
//                    String seatName = airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].getSeatName() + ch;
//                    //System.out.println(seatName.toUpperCase());
//                    airplane.getSeats()[x].setSeatName(seatName.toUpperCase());
//
////                    if(x / airplane.getAirplaneRowDepthBusiness() == 0){
////                        ch = (char) ('a' + x % 8);
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setSeatName(Integer.toString(airplane.getAirplaneRowDepthFirst() + 1));
////                        String seatName = airplane.getSeats()[ airplane.getNumberOfSeatsPerClass()[0] + x].getSeatName() + ch;
////                        //System.out.println(seatName.toUpperCase());
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setSeatName(seatName.toUpperCase());
////                    } else if(x / airplane.getAirplaneRowDepthFirst() == 1){
////                        ch = (char) ('a' + (x % 8));
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setSeatName("2");
////                        String seatName = airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].getSeatName() + ch;
////                        //System.out.println(seatName.toUpperCase());
////                        airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setSeatName(seatName.toUpperCase());
////                    }
//
//                }
//                //System.out.println("in business");
//                return airplaneSeatConstructor(airplane, "ECONOMY", 209);
//            }
//            if (className.equals("ECONOMY")) {
//                for (int x = 0; x < numberOfSeats; x++) {
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + airplane.getNumberOfSeatsPerClass()[1] + x].setBusinessClass(false);
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + airplane.getNumberOfSeatsPerClass()[1] + x].setFirstClass(false);
//                    airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + airplane.getNumberOfSeatsPerClass()[1] + x].setOccupied(false);
//                }
//                //System.out.println("in economy");
//                return airplaneSeatConstructor(airplane, "SPECIAL", 26);
//            }
//            if (className.equals("SPECIAL")) {
//               // System.out.println("in special");
//                return airplaneSeatConstructor(airplane, "TERM", 273);
//            }
//        }
        return 0;

    }

    private int economyClassSeatConstructor(int x, int y) {

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

        if((x % 9) <= 0){
            y++;
        }
        ch = (char) ('a' + x % 9);
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
