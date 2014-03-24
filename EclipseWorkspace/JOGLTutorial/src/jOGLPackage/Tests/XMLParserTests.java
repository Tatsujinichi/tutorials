package jOGLPackage.Tests;

import static org.junit.Assert.*;
import jOGLPackage.XMLParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XMLParserTests
{
	@Test
	public void TestParseXMLFile()
	{
		String path = "C:\\DEV\\tutorials\\JOGLTutorial\\JOGLTutorial\\res\\cube.dae";
		try
		{
			XMLParser.ParseXMLFile(path);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
