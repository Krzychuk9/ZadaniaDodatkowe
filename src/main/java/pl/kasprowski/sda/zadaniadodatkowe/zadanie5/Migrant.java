package pl.kasprowski.sda.zadaniadodatkowe.zadanie5;

import java.util.List;
import java.util.stream.Collectors;

public class Migrant {
    private int currentLocation;
    private List<Integer> locations;
    private int distance;

    public Migrant(int currentLocation, int distance, List<Integer> locations) {
        this.currentLocation = currentLocation;
        this.distance = distance;
        this.locations = locations;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public List<Integer> getLocations() {
        return locations;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        if (locations.size() == 0) {
            return "Wybrano sąsiednie wierzchołki, droga wynosi: " + distance;
        }
        return "Najkrótsza droga do W" + currentLocation + ", przez pocyję: W" + locations.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(", W")) +
                ", wynosi: " + distance;
    }

}
