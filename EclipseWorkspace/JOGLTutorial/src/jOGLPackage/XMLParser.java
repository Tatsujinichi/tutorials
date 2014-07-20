package jOGLPackage;

import jOGLPackage.COLLADA.Geometry;
import jOGLPackage.COLLADA.Mesh;

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

public class XMLParser<T>
{
	public static Geometry ParseXMLFile(String path) throws ParserConfigurationException, SAXException, IOException
	{
		Geometry geometry;
		Mesh mesh;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(path);
		//doc.getDocumentElement().normalize();
		Element element = doc.getDocumentElement();
		
		Element library_geometriesElement = GetFirstChildElementNodeByTag(element, "library_geometries");
		Element geometryElement = GetFirstChildElementNodeByTag(library_geometriesElement, "geometry");
		Element meshElement = GetFirstChildElementNodeByTag(geometryElement, "mesh");
		List<Element> sourcePositionsElement = GetChildElementNodesByTag(meshElement, "source");
		Element float_arrayElement = GetFirstChildElementNodeByTag(sourcePositionsElement.get(0), "float_array");
		System.out.println(float_arrayElement.getTextContent());
		

		return null;
		//return geometry;
	}
	
	private static List<Element> GetChildElementNodesByTag(Node node, String tag)
	{
		List<Element> retList = new ArrayList<Element>();
	
		NodeList nodes = node.getChildNodes();
		
		int numberOfNodes = nodes.getLength();
		for(int i = 0; i < numberOfNodes; i++)
		{
			Node childNode = nodes.item(i);
			if(childNode.getNodeType() == Node.ELEMENT_NODE)
			{
				if(childNode.getNodeName() == tag)
				{
					retList.add((Element)childNode);
				}
			}
		}
		return retList;
	}
	
	private static Element GetFirstChildElementNodeByTag(Node node, String tag)
	{	
		NodeList nodes = node.getChildNodes();
		
		int numberOfNodes = nodes.getLength();
		for(int i = 0; i < numberOfNodes; i++)
		{
			Node childNode = nodes.item(i);
			if(childNode.getNodeType() == Node.ELEMENT_NODE)
			{
				if(childNode.getNodeName() == tag)
				{
					return (Element)childNode;
				}
			}
		}
		return null;
	}
}
