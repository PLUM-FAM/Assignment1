
import java.util.*;
import java.io.*;

public class Driver 
{	
	public static void main(String args[])
	{
		MazeReader reader = new MazeReader();

		String[][] openMaze = reader.readOpen();
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; i++)
			{
				System.out.println(openMaze[i][j]);
			}
		}
		
		String[][] mediumMaze = reader.readMedium();
		
		String[][] largeMaze = reader.readLarge();
		
		
	}

}