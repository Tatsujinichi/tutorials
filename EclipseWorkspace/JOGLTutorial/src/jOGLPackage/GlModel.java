package jOGLPackage;
import java.util.ArrayList;
import java.util.List;


public class GlModel implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
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
