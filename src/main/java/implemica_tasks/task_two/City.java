package implemica_tasks.task_two;

import java.util.Map;
import java.util.Objects;

public class City {
    private int index;
    private String name;
    private int weight;
    private Map<City, Integer> neighbors;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Map<City, Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Map<City, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return index == city.index && name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }
}
