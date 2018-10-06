

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * The MazeReader class reads the lines and cols of a text file and outputs/returns a 2D array data structure of the maze for us to manipulate.
 */
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
				for(int i = 0; i < width; i++)	//for each col.
				{
					String line = in.next();	//for each line
		
					for(int j = 0; j < height; j++)
					{
						maze[i][j] = line.charAt(j); //the next spot in the 2d array is the next character in the text file.
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