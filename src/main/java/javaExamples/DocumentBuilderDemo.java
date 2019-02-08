package javaExamples;

import org.testng.annotations.Test;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;

public class DocumentBuilderDemo {

    @Test
    public static String getRequestBody(String countryISO) {

        // create a new DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // use the factory to create a documentbuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // create a new document from input stream
            FileInputStream fis = new FileInputStream("C:\\Users\\pavan.nemalikanti\\IdeaProjects\\JavaPractice\\src\\main\\resources\\GetCapitalCity_XML.xml");
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            //Get all
            NodeList nList = doc.getElementsByTagName("web:CapitalCity");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                System.out.println("");    //Just a separator
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    eElement.getElementsByTagName("web:sCountryISOCode").item(0).setTextContent(countryISO);
                    // System.out.println("Location : " + eElement.getElementsByTagName("web:sCountryISOCode").item(0).getTextContent());

                    //write the updated document to file or console
                    doc.getDocumentElement().normalize();

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("employee_updated.xml"));
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(source, result);
                    // System.out.println("XML file updated successfully");

                    StringWriter writer = new StringWriter();
                    transformer.transform(new DOMSource(doc), new StreamResult(writer));
                    return writer.getBuffer().toString();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
