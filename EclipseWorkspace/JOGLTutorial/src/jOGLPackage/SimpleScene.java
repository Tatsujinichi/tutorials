package jOGLPackage;
import java.awt.Frame;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

public class SimpleScene implements GLEventListener
{
	public static void main(String[] args)
	{
		final GLProfile glp = GLProfile.getDefault();
		final GLCapabilities caps = new GLCapabilities(glp);
		final GLCanvas canvas = new GLCanvas(caps);

		final AWTFrameFactory frameFactory = new AWTFrameFactory(300, 300,
				"Main");
		final Frame frame = frameFactory.Create();
		frame.add(canvas);

		canvas.addGLEventListener(new SimpleScene());
	}

	@Override
	public void display(GLAutoDrawable drawable)
	{
		Update();
		Render(drawable);
	}

	private void Update()
	{

	}

	private void Render(GLAutoDrawable drawable)
	{
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL.GL_TRIANGLES);
		
		GlModel model = new GlModel();
		model.Add(new D3Vertex(-1, -1, 0));
		model.Add(new D3Vertex(0, 1, 0));
		model.Add(new D3Vertex(1, -1, 0));

		for(D3Vertex vertex : model.GetVertexList())
		{
			//gl.glColor3d(vertex.Color.D1, vertex.Color.D2, vertex.Color.D3);
			//TODO: investigate 'doublebuffer'
			gl.glVertex3d(vertex.D1, vertex.D2, vertex.D3); 
		}
		
		gl.glEnd();
	}

	@Override
	public void dispose(GLAutoDrawable arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4)
	{
		// TODO Auto-generated method stub

	}
}
