package jOGLPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Import<T>
{
	//TODO: create reader /parser
	
	public T Convert(String path)
	{
		return null;
	}
	
	//TODO: abstract serialization elsewhere
	public void SerializeToDisk(T o, String path)
	{
		FileOutputStream fs = null;
		ObjectOutputStream out = null;
		try
		{
			fs = new FileOutputStream(path);
			out = new ObjectOutputStream(fs);
			out.writeObject(o);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fs.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T SerializeFromDisk(String path)
	{
		FileInputStream fs = null;
		ObjectInputStream in = null;
		try
		{
			fs = new FileInputStream(path);
			in = new ObjectInputStream(fs);
			return (T)in.readObject();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				fs.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
