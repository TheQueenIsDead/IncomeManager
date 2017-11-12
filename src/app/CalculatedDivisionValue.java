package app;

import java.text.DecimalFormat;

public class CalculatedDivisionValue {

    private String name;
    private Double weight;
    private Double value;
    private Double percentage;

    CalculatedDivisionValue(String name, Double weight, Double value, Double percentage){
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

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public String getValue() {
        return new DecimalFormat("$##.##").format(value);
    }
}
