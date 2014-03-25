package jOGLPackage;


public class ColoredVertex extends D3Vertex
{
	public ColoredVertex(D3Color color, D3Vertex vertex)
	{
		super(vertex.D1, vertex.D2, vertex.D3);
		Color = color;
	}
	
	private static final long serialVersionUID = 1L;
	public D3Color Color;
}
