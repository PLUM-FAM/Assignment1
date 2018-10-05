

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeReader 
{
	public char[][] readMaze(String filename)
	{
			char[][] maze;
			int width;
			int height;
			
			if(filename.equals("open maze.txt"))
			{
				maze = new char[20][37];
				width = 20;
				height = 37;
			}
			else if(filename.equals("medium maze.txt"))
			{
				maze = new char[23][61];
				width = 23;
				height = 61;
			}else
			{
				maze = new char[31][81];
				width = 31;
				height = 81;
			}
			
			try {
				Scanner in = new Scanner(new FileReader(filename));
				System.out.println("");
				System.out.println(filename);
				for(int i = 0; i < width; i++)
				{
					String line = in.next();
		
					for(int j = 0; j < height; j++)
					{
						maze[i][j] = line.charAt(j);
					}
				}
			}
			catch(IOException e)
			{
				System.out.println("Error reading file");
			}
			return maze;
	}
	
}