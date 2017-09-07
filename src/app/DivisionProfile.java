package app;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class DivisionProfile {

    private Double value;
    private Double remainderValue;

    private ArrayList<Double> divisions;
    private ArrayList<Pair<Double, Double>> divisionValues;


    public DivisionProfile(ArrayList<Double> divisions){
        this.divisions = divisions;
        divisionValues = new ArrayList<>();
    }

    public DivisionProfile(String xmlURL){
        System.out.println("Implement parsing an XML here.");
    }

    /**
     * Checks to make sure that none of the division values are negative
     * @return Returns true if all values are above 0.
     */
    public boolean validateDivisions(){
        for(double div: divisions){
            if(div <= 0){
                return false;
            }
        }
        return true;
    }

    public void setValue(Double value){
        this.value = value;
    }

    public ArrayList<Pair<Double, Double>> getDivisionValues(){
        return divisionValues;
    }

    /**
     * Populates the divisionValue hashmap if the division profile does not split the value
     * to a negative number (Ie, if we want to split it into 3x$50 divisions but we only have a $70 starting value)
     * @return Returns true if the operation completed successfully
     */
    public boolean calculateDivisionValues() {
        double count = value;

        System.out.println("CurrentValue:" + count);
        for(double div: divisions){
            boolean isPercentage = (div % 1 != 0.0);

            //If we're under 0 and we have another division, then the value is too small for the profile,
            //Or the profile is too large for the value
            if (count < 0){
                return false;
            }

            if(isPercentage){
                double percentageValue = count * div;
                divisionValues.add(new Pair(div, percentageValue));
                count = count - percentageValue;
            } else {
                divisionValues.add(new Pair(div, div));
                count = count - div;
            }
        }
        this.remainderValue = count;
        return true;
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
