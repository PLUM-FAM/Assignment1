

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
	
//	public char[][] readOpen()
//	{
//		char[][] openMaze = new char[20][37];
//		try
//		{
//			Scanner in = new Scanner(new FileReader("open maze.txt"));
//			for(int i = 0; i < 20; i++)
//			{
//				String line = in.next();
//
//				for(int j = 0; j < 37; j++)
//				{
//					openMaze[i][j] = line.charAt(j);
//					//System.out.println(line.charAt(j));
//				}
//			}
//		}
//		catch(IOException e)
//		{
//			System.out.println("Error reading file");
//		}
//		return openMaze;
//	}
//	
//	public char[][] readMedium()
//	{
//		char[][] mediumMaze = new char[23][61];
//		try
//		{
//			Scanner in = new Scanner(new FileReader("open maze.txt"));
//			for(int i = 0; i < 23; i++)
//			{
//				String line = in.next();
//
//				for(int j = 0; j < 61; j++)
//				{
//					mediumMaze[i][j] = line.charAt(j);
//					//System.out.println(line.charAt(j));
//				}
//			}
//		}
//		catch(IOException e)
//		{
//			System.out.println("Error reading file");
//		}
//		return mediumMaze;
//	}
//	
//	public char[][] readLarge()
//	{
//		char[][] largeMaze = new char[31][81];
//		try
//		{
//			Scanner in = new Scanner(new FileReader("open maze.txt"));
//			for(int i = 0; i < 31; i++)
//			{
//				String line = in.next();
//
//				for(int j = 0; j < 81; j++)
//				{
//					largeMaze[i][j] = line.charAt(j);
//					//System.out.println(line.charAt(j));
//				}
//			}
//		}
//		catch(IOException e)
//		{
//			System.out.println("Error reading file");
//		}
//		return largeMaze;
//	}
	
	
	
	
}