import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

public class SimpleScene implements GLEventListener {
    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("AWT Window Test");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter(){
        	  public void windowClosing(WindowEvent we){
        		    System.exit(0);
        		  }
        		});
        canvas.addGLEventListener(new SimpleScene());
    }

	@Override
	public void display(GLAutoDrawable drawable) {
	    update();
	    render(drawable);
	}

	private void render(GLAutoDrawable drawable) {
	    GL2 gl = drawable.getGL().getGL2();
	  
	    // draw a triangle filling the window
	    gl.glBegin(GL.GL_TRIANGLES);
	    gl.glColor3f(1, 0, 0);
	    gl.glVertex2f(-1, -1);
	    gl.glColor3f(0, 1, 0);
	    gl.glVertex2f(0, 1);
	    gl.glColor3f(0, 0, 1);
	    gl.glVertex2f(1, -1);
	    gl.glEnd();	
	}

	private void update() {

		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// TODO Auto-generated method stub
		
	}
}
