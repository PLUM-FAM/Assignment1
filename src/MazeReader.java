

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeReader 
{
	public String[][] readOpen()
	{
		String[][] openMaze = new String[20][37];
		try
		{
			Scanner in = new Scanner(new FileReader("open maze.txt"));
			for(int i = 0; i < 20; i++)
			{
				for(int j = 0; j < 37; j++)
				{
					if(in.hasNext())
					{
						openMaze[i][j] = in.next();
					}
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
		return openMaze;
	}
	
	public String[][] readMedium()
	{
		String[][] mediumMaze = new String[23][61];
		try
		{
			Scanner in = new Scanner(new FileReader("medium maze.txt"));
			for(int i = 0; i < 23; i++)
			{
				for(int j = 0; j < 61; j++)
				{
					mediumMaze[i][j] = in.next();
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
		return  mediumMaze;
	}
	
	public String[][] readLarge()
	{
		String[][] largeMaze = new String[31][81];
		try
		{
			Scanner in = new Scanner(new FileReader("large maze.txt"));
			for(int i = 0; i < 31; i++)
			{
				for(int j = 0; j < 81; j++)
				{
					largeMaze[i][j] = in.next();
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
		return largeMaze;
	}
}