package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Value {
    //Income value
    private Double value;
    //Splits
    private ArrayList<Double> divisions;





    //Link this Income to another income

    //Reading? Can go through all splits then go onto the remainder income after
    public Value(Double value, ArrayList<Double> divisions){
        this.value = value;
        this.divisions = divisions;
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
