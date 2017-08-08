import app.DivisionProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisionProfileTest {
    @Test
    public void createDivisionProfileArrayList(){
        ArrayList<Double> divs = new ArrayList<>();
        divs.add(1.0);
        divs.add(2.0);
        divs.add(3.0);
        DivisionProfile divPro = new DivisionProfile(divs);
    }
    @Test
    public void createDivisionProfileXML(){
        Assertions.assertTrue(false);
    }
    @Test
    public void validateDivisionsValidDoubles(){
        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.125, 30.0, 42.0, 0.31415)));
        Assertions.assertTrue(divPro.validateDivisions());
    }
    @Test
    public void validateDivisionsInvalidDoubles(){
        DivisionProfile divProNegative = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.125, 30.0, 42.0, -0.31415)));
        DivisionProfile divProZero = new DivisionProfile(new ArrayList<Double>(Arrays.asList(0.125, 30.0, 42.0, -0.31415)));
        Assertions.assertFalse(divProNegative.validateDivisions());
        Assertions.assertFalse(divProZero.validateDivisions());
    }
    @Test
    public void validateDivisionsWithValidRemainder(){
        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
        divPro.addRemainderDivisions(new ArrayList<>(Arrays.asList(4.0, 5.0, 6.0)));
        Assertions.assertTrue(divPro.validateDivisions());
    }
    @Test
    public void validateDoubleValuesWithInvalidRemainder(){
        DivisionProfile divPro = new DivisionProfile(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
        divPro.addRemainderDivisions(new ArrayList<>(Arrays.asList(4.0, 5.0, -6.0)));
        Assertions.assertFalse(divPro.validateDivisions());

    }
}
