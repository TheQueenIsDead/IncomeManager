package app;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class DivisionProfile {

    public Double value;
    private Double remainderValue; //TODO - Probably remove since we just add a new CalculatedDivisionValue

    private ArrayList<Pair<String, Double>> divisions;
    private ArrayList<CalculatedDivisionValue> divisionValues;


    public DivisionProfile(ArrayList<Pair<String, Double>> divisionList){
        this.divisions = divisionList;
        divisionValues = new ArrayList<>();
    }

    //TODO - Note, probably not necessary anymore, we come straight from DXMLReader
    public DivisionProfile(String xmlURL){
        System.out.println("Implement parsing an XML here.");
    }

    /**
     * Checks to make sure that none of the division values are negative
     * @return Returns true if all values are above 0.
     */
    public boolean validateDivisions(){
        for(Pair<String, Double> div: divisions){
            if(div.getValue() <= 0){
                return false;
            }
        }
        return true;
    }

    public void setValue(Double value){
        this.value = value;
        divisionValues = new ArrayList<>();
        calculateDivisionValues();
    }

    public ArrayList<CalculatedDivisionValue> getDivisionValues(){
        return divisionValues;
    }

    /**
     * Populates the divisionValue hashmap if the division profile does not split the value
     * to a negative number (Ie, if we want to split it into 3x$50 divisions but we only have a $70 starting value)
     * @return Returns true if the operation completed successfully
     */
    public boolean calculateDivisionValues() {

        if(value == null){ //"Error" if no value has been set
            return false;
        }

        double count = value;

        System.out.println("CurrentValue:" + count);
        for(Pair<String, Double> div: divisions){
            String name = div.getKey();
            Double divisor = div.getValue();
            boolean isPercentage = (divisor % 1 != 0.0);

            //If we're under 0 and we have another division, then the value is too small for the profile,
            //Or the profile is too large for the value
            if (count < 0){
                return false;
            }

        //TODO - Give the DivisionProfile access to the Name string of the division from the reader, and pass it in here
            if(isPercentage){
                double percentageValue = count * divisor;
                divisionValues.add(new CalculatedDivisionValue(name, divisor, percentageValue, divisor));
                count = count - percentageValue;
            } else {
                divisionValues.add(new CalculatedDivisionValue(name, divisor, divisor, divisor/value));
                count = count - divisor;
            }
        }
        divisionValues.add(new CalculatedDivisionValue("Remainder", null, count, count/value));
        this.remainderValue = count;
        return true;
    }

    public int count(){
        return divisionValues.size();
    }

//    /**
//     * Allows the profile to have a second list of divisions that ca be applied to
//     * a remainder value by a third party
//     * @param divisions An ArrayList of doubles defining the divisions for a remaining value
//     */
//    public void addRemainderDivisions(ArrayList<Double> divisions){
//        this.remainderDivisions = divisions;
//    }
}
