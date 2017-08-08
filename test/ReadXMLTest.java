import app.DivisionXMLReader;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadXMLTest {
    @Test
    public void readXML() throws IOException, SAXException, ParserConfigurationException {
        DivisionXMLReader reader = new DivisionXMLReader("/home/david/IdeaProjects/IncomeManager/resource/TestDivisions.xml");
    }
}
