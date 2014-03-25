package jOGLPackage;
import java.util.ArrayList;
import java.util.List;


public class GlModel implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private List<D3Vertex> _vertexList;
	
	public GlModel()
	{
		_vertexList = new ArrayList<D3Vertex>();
	}
	
	public void Add(D3Vertex v)
	{
		_vertexList.add(v);
	}
	
	public List<D3Vertex> GetVertexList()
	{
		return _vertexList;
	}
}
