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
    private Double percentage;

    public CalculatedDivisionValue(String name, Double weight, Double value, Double percentage){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.percentage = percentage;
    }

    public String toString(){
        return "Name: "  + name + ", Weight: " + weight + ", Value: "  + value + ". It is " + percentage + " of its total.";
    }

    public Double getPercentage() {
        return percentage;
    }

//    public void setPercentage(double percentage){
//        this.percentage = percentage;
//    }
}
