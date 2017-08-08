package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Value {
    //Income value
    private Double value;
    //Splits
    private ArrayList<Double> divisions;

    private HashMap<Double, Double> values = new HashMap<>();
    //Auto calc remainder
    private Value remainder; //Null
    private Double remainderDouble;



    //Link this Income to another income

    //Reading? Can go through all splits then go onto the remainder income after
    public Value(Double value, ArrayList<Double> divisions){
        this.value = value;
        this.divisions = divisions;
        divideInitialValue();
    }

    private boolean divideInitialValue() {
        Double count = value; //Keeps track of the remainder
        System.out.println("CurrentValue:" + count);
        for(double div: divisions){
            System.out.println(div);
            boolean isPercentage = (div % 1 != 0.0);
            System.out.println(isPercentage);

            //Check to make sure we're still above 0
            if (count < 0){
                return false;
            }

            if(isPercentage){
                double percentageValue = count * div;
                values.put(div, percentageValue);
                count = count - percentageValue;
            } else {
                values.put(div, div);
                count = count - div;
            }
        }
        this.remainderDouble = count;
        return true;
    }

    public HashMap<Double, Double> getValues() {
        return values;
    }

    public String toString(){
        String rtn = "This Value contains";
        for(double key: values.keySet()){
            rtn += " " + key + " " + values.get(key);
        }
        rtn += " with a remainder of " + remainderDouble;
        return rtn;
    }
}
