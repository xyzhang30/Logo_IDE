package slogo.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ViewParser {

  private static final String folderPath = "data/viewXML/";
  private final List<String> options;

  private String type;

  public ViewParser() {
    options = new ArrayList<>();
  }

  public void readXml(String type) throws FileNotFoundException {
    options.clear();
    this.type = type;
    String path = folderPath + type + ".xml";
    File file = new File(path);
    if (!file.exists()) {
      throw new FileNotFoundException("File not found: " + path);
    }
    Document doc = parseFile(path);
    parseDocument(doc);
  }

  private void parseDocument(Document doc) {
    // Modify this method to parse themes instead of commands

    Node optionNodes = doc.getElementsByTagName(type).item(0);

    Element element = (Element) optionNodes;

    if (!(element.getElementsByTagName(type).getLength() == 0)) {
      parseThemes(element.getElementsByTagName(type));
    }

  }

  private void parseThemes(NodeList optionsNodes) {
    for (int i = 0; i < optionsNodes.getLength(); i++) {
      Node optionNodes = optionsNodes.item(i);
      options.add(optionNodes.getTextContent());
    }
  }

  public List<String> getOptions() {
    return options;
  }

  private Document parseFile(String path) throws FileNotFoundException {
    try {
      // create a new File object for the XML file
      File file = new File(path);

      return createDocument(file, path);
    } catch (NullPointerException | ParserConfigurationException | IOException | SAXException e) {
      throw new FileNotFoundException("Error parsing the XML file");
    }
  }

  private Document createDocument(File file, String path)
      throws ParserConfigurationException, IOException, SAXException {
    // create a new instance of document builder factory that allows for a document builder
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    // checking for well-formatted XML
    dbf.setValidating(false);
    dbf.setNamespaceAware(true);

    // create an instance of document builder to parse the XML file
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();

    return doc;
  }
}
