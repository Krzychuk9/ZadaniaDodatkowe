package pl.kasprowski.sda.zadaniadodatkowe.zadanie5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataStructureAnalyzer {

    /**
     * Finds the shortest way from start point to destination point based on data
     *
     * @param data      array representation of graph
     * @param positions point where user starts and destination point (index 0 - start, index 1 - destination)
     * @return List of Migrant obj with shortest way from start point to destination point
     */
    public List<Migrant> analyze(DataStructure data, String[] positions) {
        int[][] array = data.getArray();
        int w1 = Integer.valueOf(positions[0].split("")[1]);
        int w2 = Integer.valueOf(positions[1].split("")[1]);
        List<Migrant> migrants = new ArrayList<>();
        List<Migrant> results = new ArrayList<>();
        migrants.add(new Migrant(w1, 0, new ArrayList<>()));

        for (int i = 0; i < migrants.size(); i++) {
            int index = migrants.get(i).getCurrentLocation() - 1;

            if (array[index][w2 - 1] != 0) {
                results.add(new Migrant(w2, migrants.get(i).getDistance() + array[index][w2 - 1], migrants.get(i).getLocations()));
            }
            if (results.size() == 0 || migrants.get(i).getDistance() < results.get(0).getDistance()) {
                for (int x = 0; x < array[index].length; x++) {
                    if (x == w2 - 1) {
                        continue;
                    }
                    if (array[index][x] != 0) {
                        Migrant migrant = new Migrant(x + 1, migrants.get(i).getDistance() + array[index][x], new ArrayList<>());
                        migrants.add(migrant);
                        migrant.getLocations().addAll(migrants.get(i).getLocations());
                        migrant.getLocations().add(migrant.getCurrentLocation());
                    }
                }
            }
            migrants.remove(i);
            i--;
        }
        int minDistance = results.stream().min(Comparator.comparing(s -> s.getDistance())).get().getDistance();
        return results.stream().filter((m) -> m.getDistance() == minDistance).collect(Collectors.toList());
    }
}

