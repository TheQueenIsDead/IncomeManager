package app;

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

public class DivisionXMLReader {

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
        NodeList initialDivisionList = doc.getElementsByTagName("initialDivision");

        for(int i = 0; i < initialDivisionList.getLength(); i++){
            Element initialDivision = (Element) initialDivisionList.item(i);
            System.out.println(initialDivision.getElementsByTagName("name").item(0).getTextContent());
            System.out.println(initialDivision.getElementsByTagName("double").item(0).getTextContent());
        }

        NodeList remainderDivisionList = doc.getElementsByTagName("remainderDivision");

        for(int i = 0; i < remainderDivisionList.getLength(); i++){
            Element initialDivision = (Element) remainderDivisionList.item(i);
            System.out.println(initialDivision.getElementsByTagName("name").item(0).getTextContent());
            System.out.println(initialDivision.getElementsByTagName("double").item(0).getTextContent());
        }
    }

    public static void parse() throws XMLStreamException, IOException {
        try (FileOutputStream fos = new FileOutputStream("test.xml")){
            XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);
            writer.writeStartDocument();
            writer.writeStartElement("test");
            // write stuff
            writer.writeEndElement();
        }
    }

    public DivisionProfile getDivision() {
        return divisionProfile;
    }
}
