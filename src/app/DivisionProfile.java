package app;

import java.util.ArrayList;
import java.util.HashMap;

public class DivisionProfile {

    private ArrayList<Double> divisions;
    private ArrayList<Double> remainderDivisions;

    private Double value;
    private Double remainderValue;
    private HashMap<Double, Double> divisionValues;
    private HashMap<Double, Double> remainderDivisionValues;
    //Auto calc remainder

    public DivisionProfile(ArrayList<Double> divisions){
        this.divisions = divisions;
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
            if(div < 0){
                return false;
            }
        }
        if(remainderDivisions != null){
            for(double div: remainderDivisions){
                if(div < 0){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Populates the divisionValue hashmap if the division profile does not split the value
     * to a negative number (Ie, if we want to split it into 3x$50 divisions but we only have a $70 starting value)
     * @return Returns true if the operation completed successfully
     */
    private boolean calculateDivisionValues() {
        //checks to see if we've calculated the divisionvalues for the initial value
        //If we have it calculates the remainderValues based on the remainder
        HashMap mapToUse;
        Double valueToUse;
        if(divisionValues == null) { //Use value and initial div profile
            valueToUse = this.value; //Keeps track of the remainder
            mapToUse = this.divisionValues;
        } else {
            valueToUse = this.remainderValue;
            mapToUse = this.remainderDivisionValues;
        }

        System.out.println("CurrentValue:" + count);
        for(double div: divisions){
            System.out.println(div);
            boolean isPercentage = (div % 1 != 0.0);
            System.out.println(isPercentage);

            //If we're under 0 and we have another division, then the value is too small for the profile,
            //Or the profile is too large for the value
            if (remainder < 0){
                return false;
            }

            if(isPercentage){
                double percentageValue = count * div;
                divisionValues.put(div, percentageValue);
                count = count - percentageValue;
            } else {
                values.put(div, div);
                count = count - div;
            }
        }
        this.remainderDouble = count;
        return true;
    }

    /**
     * Allows the profile to have a second list of divisions that ca be applied to
     * a remainder value by a third party
     * @param divisions An ArrayList of doubles defining the divisions for a remaining value
     */
    public void addRemainderDivisions(ArrayList<Double> divisions){
        this.remainderDivisions = divisions;
    }
}
