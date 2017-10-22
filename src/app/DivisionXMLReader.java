package app;

import javafx.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads values from an XML file and compiles them into a list that can be accessed.
 * The list contains a pair where the key is the name of the division, and the
 * value is the amount it represents.
 */
public class DivisionXMLReader {

    private ArrayList<Pair<String, Double>> divisionList = new ArrayList<>();
    private DivisionProfile divisionProfile;


    public DivisionXMLReader(String url) throws ParserConfigurationException, IOException, SAXException {
        //Build then print the document
        Document doc = buildDoc(url);
        readDoc(doc);
    }

    private Document buildDoc(String url) throws IOException, SAXException, ParserConfigurationException {
        //Build the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(url);
        Document doc = builder.parse(file);
        return doc;
    }

    private void readDoc(Document doc){
        //Initial Divisions
        NodeList divisions = doc.getElementsByTagName("division");

        for(int i = 0; i < divisions.getLength(); i++){
            Element initialDivision = (Element) divisions.item(i);
            String name = initialDivision.getElementsByTagName("name").item(0).getTextContent();
            Double value = Double.parseDouble(initialDivision.getElementsByTagName("double").item(0).getTextContent());
            divisionList.add(new Pair<>(name, value));
        }

        createProfile();

        //TODO - Remove maybe? Deprecated functionality
//        NodeList remainderDivisionList = doc.getElementsByTagName("remainderDivision");
//
//        for(int i = 0; i < remainderDivisionList.getLength(); i++){
//            Element initialDivision = (Element) remainderDivisionList.item(i);
//            System.out.println(initialDivision.getElementsByTagName("name").item(0).getTextContent());
//            System.out.println(initialDivision.getElementsByTagName("double").item(0).getTextContent());
//        }
    }

    private void createProfile(){
        ArrayList<Double> values = new ArrayList();
        for(Pair p: divisionList){
            values.add((double) p.getValue());
        }

        divisionProfile = new DivisionProfile(values);
    }

//    public static void parse() throws XMLStreamException, IOException {
//        try (FileOutputStream fos = new FileOutputStream("test.xml")){
//            XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
//            XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);
//            writer.writeStartDocument();
//            writer.writeStartElement("test");
//            // write stuff
//            writer.writeEndElement();
//        }
//    }

    public DivisionProfile getDivision() {
        return divisionProfile;
    }
}
