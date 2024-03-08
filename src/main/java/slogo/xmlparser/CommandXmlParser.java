package slogo.xmlparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CommandXmlParser {

  private String commandName;
  private String commandDescription;
  private final Map<String, String> parameterDescription;
  private List<String> paramOrder;
  private int numParamsExpected;
  private String returnValueType; //do we even need this since everything returns a double?
  private String implementationName;
  private String commandCategory; //do we need this??
  private String commandExample;

  public CommandXmlParser() {
    this.parameterDescription = new HashMap<>();
    this.paramOrder = new ArrayList<>();
  }

  public void readXml(String commandName) throws FileNotFoundException {
    String dataFolderPath = "data/commandsXML/";
    String path = dataFolderPath + commandName + ".xml";

    File file = new File(path);

    if (!file.exists()) {
      throw new FileNotFoundException("File not found: " + path);
    }

    Document doc = parseFile(path);
    parseDocument(doc);

  }

  private void parseDocument(Document doc) throws FileNotFoundException {

    Node commandNode = doc.getElementsByTagName("command").item(0);

    Element element = (Element) commandNode;

    if (element.getElementsByTagName("*").getLength() == 0) {
      throw new FileNotFoundException();
    }

    // parse all configuration data presented as single (not nested) fields
    parseSingleFields(element);

    // parse parameters
    parseParameters(element.getElementsByTagName("parameters").item(0));

  }

  private void parseParameters(Node parametersNode) {
    Element parameterElement = (Element) parametersNode;
    NodeList parametersNodeList = parameterElement.getElementsByTagName("*");

    // iterate through the parameters node list to obtain the value for each parameter
    // and create new entries in the parameters hashmap
    for (int i = 0; i < parametersNodeList.getLength(); i++) {
      Node parameterNode = parametersNodeList.item(i);
      String name = parameterNode.getNodeName();

      this.paramOrder.add(name);
      if (!name.equals("list_begin") && !name.equals("list_end")){
        this.parameterDescription.put(name, parameterNode.getTextContent());
      }
    }
  }

  public List<String> getParamOrder(){
    return paramOrder;
  }

  private void parseSingleFields(Element element) {
    commandName = element.getElementsByTagName("canonical_name").item(0).getTextContent();
    commandCategory = element.getElementsByTagName("category").item(0).getTextContent();
    commandExample = element.getElementsByTagName("example").item(0).getTextContent();
    commandDescription = element.getElementsByTagName("description").item(0).getTextContent();
    returnValueType = element.getElementsByTagName("return_value").item(0).getTextContent();
    numParamsExpected = Integer.parseInt(
        element.getElementsByTagName("number_of_expected_parameters").item(0).getTextContent());
    implementationName = element.getElementsByTagName("implementing_class").item(0)
        .getTextContent();
  }

  private Document parseFile(String path) throws FileNotFoundException {
    try {
      // create a new File object for the XML file
      File file = new File(path);

      return createDocument(file, path);
    } catch (NullPointerException | ParserConfigurationException | IOException | SAXException e) {
      throw new FileNotFoundException();
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

  public String getCommandName() {
    return commandName;
  }

  public String getCommandDescription() {
    return commandDescription;
  }

  public Map<String, String> getParameters() {
    return parameterDescription;
  }

  public int getNumParamsExpected() {
    return numParamsExpected;
  }

  public String getReturnValueType() {
    return returnValueType;
  }

  public String getImplementationName() {
    return implementationName;
  }

  public String getCommandCategory() {
    return commandCategory;
  }

  public String getExample(){return commandExample;}
}
