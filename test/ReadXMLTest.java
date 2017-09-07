import app.DivisionXMLReader;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadXMLTest {
    @Test
    public void readTestDivisionsXML() throws IOException, SAXException, ParserConfigurationException {
        DivisionXMLReader reader = new DivisionXMLReader("resource/TestDivisions.xml");
    }
}
