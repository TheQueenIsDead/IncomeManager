package app;

import java.util.ArrayList;

public class DivisionProfile {

    private ArrayList<Double> divisions;
    private ArrayList<Double> remainderDivisions;

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
     * Allows the profile to have a second list of divisions that ca be applied to
     * a remainder value by a third party
     * @param divisions An ArrayList of doubles defining the divisions for a remaining value
     */
    public void addRemainderDivisions(ArrayList<Double> divisions){
        this.remainderDivisions = divisions;
    }
}
