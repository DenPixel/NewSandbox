package implemica_tasks.task_two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final int INFINITY = 1_000_000;
    private List<City> cities;
    private List<City[]> paths;

    public Solution(Data data) {
        build(data);
    }

    private void build(Data data){
        this.paths = data.getPaths();
        this.cities = data.getCities();
    }

    public void searchMinWayCosts(String outputPath){
        StringBuilder forOutput = new StringBuilder();

        for (City[] path : paths) { // Go through each path
            for (City tempCity : cities) tempCity.setWeight(INFINITY); // Set weight in each city

            City startCity = path[0]; // Take start city

            City endCity = path[1]; // Take end city

            startCity.setWeight(0); // Set weight in start city

            walk(startCity,endCity);

            int endCityWeight = endCity.getWeight(); // Take weight of the neighboring city
            forOutput.append(
                    // If weight of the neighboring city == INFINITY then min path cost not found
                    // and add to text "Not found" for output
                    // or if != then min path cost found
                    endCityWeight == INFINITY ? "Not found" : endCityWeight
            );
            forOutput.append(System.lineSeparator());
        }

        // output results
        output(outputPath, forOutput.toString());
    }



    private void walk(City city, City endCity){
        if(city.equals(endCity)) return; // If city == end city then return

        Map<City, Integer> neighbors = city.getNeighbors(); // Take neighbors of the current city

        for (Map.Entry<City, Integer> neighbor : neighbors.entrySet()) { // Go through each neighbor
            City nextCity = neighbor.getKey(); // Take neighbor
            int cost = neighbor.getValue(); // Take path cost
            int currentWeight = cost + city.getWeight(); // Calculate current weight

            if (currentWeight < nextCity.getWeight()){ // If current wight < weight of the neighboring city then
                nextCity.setWeight(currentWeight); // set weight in the neighboring city = current wight
                walk(nextCity, endCity); // Go to the neighbor city
            }
        }
    }

    private void output(String outputPath, String forOutput){
        try {
            Files.writeString(Path.of(outputPath), forOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
