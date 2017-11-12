import app.DivisionProfile;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisionProfileTest {
//    @Test
//    public void createDivisionProfileArrayList(){
//        ArrayList<Double> divs = new ArrayList<>();
//        divs.add(1.0);
//        divs.add(2.0);
//        divs.add(3.0);
//        DivisionProfile divPro = new DivisionProfile(divs);
//    }
//    @Test
//    public void createDivisionProfileXML(){
//        //TODO - Feature yet to be implemented
//        Assertions.assertTrue(true);
//    }
//    @Test
//    public void validateDivisionsValidDoubles(){
//        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.125, 30.0, 42.0, 0.31415)));
//        Assertions.assertTrue(divPro.validateDivisions());
//    }
//    @Test
//    public void validateDivisionsInvalidDoubles(){
//        DivisionProfile divProNegative = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.125, 30.0, 42.0, -0.31415)));
//        DivisionProfile divProZero = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.125, 30.0, 0.0, 42.0)));
//        Assertions.assertFalse(divProNegative.validateDivisions());
//        Assertions.assertFalse(divProZero.validateDivisions());
//    }
//    @Test
//    public void calculateDivisionValues(){
//        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.5, 10.0, 0.5, 10.0)));
//        divPro.setValue(100.0);
//        divPro.calculateDivisionValues();
//        Assertions.assertEquals(50, (double) divPro.getDivisionValues().get(0).getValue());
//        Assertions.assertEquals(10, (double) divPro.getDivisionValues().get(1).getValue());
//        Assertions.assertEquals(20, (double) divPro.getDivisionValues().get(2).getValue());
//        Assertions.assertEquals(10, (double) divPro.getDivisionValues().get(3).getValue());
    }

    //Commented out as I have removed the idea of splitting the remainder, for now at least

//    @Test
//    public void validateDivisionsWithValidRemainder(){
//        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
//        divPro.addRemainderDivisions(new ArrayList<>(Arrays.asList(4.0, 5.0, 6.0)));
//        Assertions.assertTrue(divPro.validateDivisions());
//    }
//    @Test
//    public void validateDoubleValuesWithInvalidRemainder(){
//        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
//        divPro.addRemainderDivisions(new ArrayList<>(Arrays.asList(4.0, 5.0, -6.0)));
//        Assertions.assertFalse(divPro.validateDivisions());
//
//    }
//}
