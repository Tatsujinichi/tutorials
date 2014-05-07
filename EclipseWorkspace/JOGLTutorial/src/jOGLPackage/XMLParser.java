package jOGLPackage;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser<T>
{
	public static void ParseXMLFile(String path) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(path);
		doc.getDocumentElement().normalize();
		//Element element = doc.getDocumentElement();
		
		Node library_geometries = doc.getElementsByTagName("library_geometries").item(0);
		Node geometries = library_geometries.get
		Node mesh = geometries.getFirstChild();
		NodeList sources = mesh.getChildNodes();
		
		System.out.println(sources.getLength());
		for(int i = 0; i < sources.getLength(); i++)
		{
			Node node = sources.item(i);
			System.out.println(node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) 
			{	 
				Element element = (Element)node;
				if(element.hasAttribute("Cube-mesh-positions"))
				{
					int count = Integer.parseInt(element.getAttribute("count"));
					NodeList floatelements = element.getElementsByTagName("float_array");
					Node floatNode = floatelements.item(0);
					Element floatElement = (Element)floatNode;
					String stringFloatArray = floatElement.getTextContent();
					System.out.println(stringFloatArray);
					//float_array
				}
			}
		}
	}
	
	private static String getValue(String tag, Element element) 
	{
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}


		//Read more: http://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz2xstzickE
}
