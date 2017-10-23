package app;

public class CalculatedDivisionValue {

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getValue() {
        return value;
    }

    private String name;
    private Double weight;
    private Double value;

    public CalculatedDivisionValue(String name, Double weight, Double value){
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String toString(){
        return "Name: "  + name + ", Weight: " + weight + ", Value: "  + value;
    }
}
