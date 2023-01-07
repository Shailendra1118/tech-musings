package com.sports.rafael.intervals;

import java.util.*;

public class CarPool {
    public static void main(String[] args) {
        CarPool pool = new CarPool();
        int[][] trips = {{9,3,4},{9,1,7},{4,2,4},{7,4,5}}; //{{2,1,5}, {3,3,7}};
        int capacity = 23;
        boolean possible = pool.carPooling(trips, capacity);

        System.out.println("Is Possible: "+possible);
    }

    private boolean carPooling(int[][] trips, int capacity) {
        //sanity check
        if(trips.length == 1) {
            return trips[0][0] > capacity ? false : true;
        }
        //Set<Trip> sortedTrips = new TreeSet<>();
        List<Trip> listOfTrips = new ArrayList<>();
        for(int i=0; i<trips.length; i++) {
            int passengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            Trip trip = new Trip(from, to, passengers);
            listOfTrips.add(trip);
        }

        Collections.sort(listOfTrips);
        Trip prevTrip = listOfTrips.get(0);
        int totalPassengers = prevTrip.passengers;
        for(int i=1; i<listOfTrips.size(); i++) {
            Trip currTrip = listOfTrips.get(i);
            if(prevTrip.to > currTrip.from) {
                //means overlapping trip
                totalPassengers += currTrip.passengers;
            }else {
                //not overlapping
                totalPassengers = currTrip.passengers;
            }
            if(totalPassengers > capacity)
                return false;
        }
        return true;
    }

    class Trip implements Comparable<Trip>{
        int from;
        int to;
        int passengers;
        public Trip(int from, int to, int passengers) {
            this.from = from;
            this.to = to;
            this.passengers = passengers;
        }
        @Override
        public int compareTo(Trip o) {
            return Integer.compare(this.from, o.from);
        }
    }
}
