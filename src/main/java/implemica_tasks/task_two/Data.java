package implemica_tasks.task_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Data {
    private final static int MAX_COST = 200_000;
    private final static int MAX_COUNT_CITIES = 10_000;
    private final static int MAX_COUNT_PATHS = 100;
    private final List<City> cities = new ArrayList<>();
    private final List<City[]> paths = new ArrayList<>();

    public Data(String inputPath) {
        build(inputPath);
    }

    public List<City> getCities() {
        return cities;
    }

    public List<City[]> getPaths() {
        return paths;
    }

    private void build(String inputPath){

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) { // Initialize the file reader
            // Map with data about the network (graph)
            // Key - each citi
            // Value - map with data about neighbors each citi. Key - index, value - path cost
            Map<City, Map<Integer, Integer>> network = new HashMap<>();

            int countCities = Integer.parseInt(reader.readLine()); // Take count of cities from the file

            // If the count of cities > maximum allowable then throws the exception
            if (countCities > MAX_COUNT_CITIES) throw new IllegalArgumentException();

            for (int i = 1; i <= countCities; i++) { // Go through each city
                String name = reader.readLine(); // Take city name from the file

                City city = new City();
                city.setIndex(i);
                city.setName(name);

                cities.add(city); // Add city to list with cities

                // Map with data about current neighbors. Key - index, value - path cost
                Map<Integer, Integer> currentNeighbors = new HashMap<>();

                // Take count of neighbors in the city
                int countNeighbors = Integer.parseInt(reader.readLine());

                for (int j = 0; j < countNeighbors; j++) { // Go through each neighbor
                    // Take index and path cost
                    String[] neighborIndexAndCost = reader.readLine().split(" ");
                    Integer neighborIndex = Integer.valueOf(neighborIndexAndCost[0]);
                    int cost = Integer.parseInt(neighborIndexAndCost[1]);

                    // If path cost > maximum allowable then throws the exception
                    if (cost > MAX_COST ) throw new IllegalArgumentException();

                    currentNeighbors.put(neighborIndex, cost);// Add neighbor to map
                }

                network.put(city, currentNeighbors); // Add the city and its neighbors
            }


            setNeighborsInCities(network); // Set neighbors in each city

            int countPaths = Integer.parseInt(reader.readLine()); // Take count of paths from the file
            // If count of paths > maximum allowable then throws the exception
            if (countPaths > MAX_COUNT_PATHS) throw new IllegalArgumentException();

            for (int i = 0; i < countPaths; i++) { //Go through each path
                String[] path = reader.readLine().split(" "); // Take data about each path
                addPath(path); // Add path in list
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setNeighborsInCities(Map<City, Map<Integer, Integer>> demoNetwork){
        // Go through each city and its neighbors
        for (Map.Entry<City, Map<Integer, Integer>> nb : demoNetwork.entrySet()) {
            City city = nb.getKey(); // Take city
            // Map with data about current neighbors. Key - city, value - path cost
            Map<City, Integer> neighbors = new HashMap<>(); //

            for (Map.Entry<Integer, Integer> neighbor : nb.getValue().entrySet()) { // Go through each neighbor
                Integer index = neighbor.getKey(); // take neighbor index
                Integer cost = neighbor.getValue(); // // take neighbor path cost

                City cityNeighbor = getCityByIndex(index); // Find neighbor by index

                // Add neighbor and path cost
                neighbors.put(cityNeighbor, cost);
            }

            city.setNeighbors(neighbors);
        }
    }

    private void addPath(String[] path){
        String startName = path[0];
        String endName = path[1];

        City startCity = getCityByName(startName);
        City endCity = getCityByName(endName);

        paths.add(new City[]{startCity, endCity});
    }

    private City getCityByName(String name){
        return cities.stream()
                .filter(city -> city.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    private City getCityByIndex(int index){
        return cities.stream()
                .filter(c -> index == c.getIndex())
                .findFirst()
                .orElseThrow();
    }

}
