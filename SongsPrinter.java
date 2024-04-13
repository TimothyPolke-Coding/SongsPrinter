import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SongsPrinter
{
	public static void main(String[] args)
	{		
		File directory = new File("Songs");
		String filename = null;
		FileWriter myWriter = null;
		File[] folders = null;
		File[] files = null;
		
		try 
		{
			myWriter = new FileWriter(new File("Songs.txt"));
		}
		catch (IOException e)
		{
			System.exit(0);
		}
		
		folders = directory.listFiles();	
		for (File folder : folders) 
		{
			try 
			{
				myWriter.write(folder.getName() + "\n");
			}
			catch (IOException e)
			{
				System.exit(0);
			}
			
			files = folder.listFiles();	
			filename = "";
			for (File file : files) 
			{
				try 
				{
					filename = file.getName().substring(0, file.getName().length() - 4);
					
					myWriter.write("    " + filename + "\n");
				}
				catch (IOException e)
				{
					System.exit(0);
				}
			}
		}
		
		try 
		{
			myWriter.close();
		}
		catch (IOException e)
		{
			System.exit(0);
		}
	}		
}