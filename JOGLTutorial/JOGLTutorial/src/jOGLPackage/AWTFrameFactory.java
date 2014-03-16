package jOGLPackage;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTFrameFactory
{

	private final int _width;
	private final int _height;
	private final String _name;

	// TODO: add more options...
	public AWTFrameFactory(int width, int height, String name)
	{
		_width = width;
		_height = height;
		_name = name;
	}

	public Frame Create()
	{
		final Frame frame = new Frame(_name);
		frame.setSize(_width, _height);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		return frame;
	}
}
