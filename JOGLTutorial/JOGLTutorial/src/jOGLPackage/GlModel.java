package jOGLPackage;
import java.util.ArrayList;
import java.util.List;


public class GlModel 
{
	public List<ColoredVertex> ColoredVertexList;
	
	public GlModel()
	{
		ColoredVertexList = new ArrayList<ColoredVertex>();
	}
	
	public void AddNewD3Tuple(ColoredVertex cv)
	{
		ColoredVertexList.add(cv);
	}
}
