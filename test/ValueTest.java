import app.Value;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ValueTest {
    @Test
    public void testConstructor(){
        ArrayList divs = new ArrayList(Arrays.asList(0.10, 25.0, 0.125, 0.125811));
        Value v = new Value(100.0, divs);

        System.out.println("ValueTest:" + v.getValues());
        System.out.println(v.toString());
    }
}
