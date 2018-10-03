
import java.util.*;
import java.io.*;

public class Driver 
{	
	public static void main(String args[])
	{
		MazeReader reader = new MazeReader();

		char[][] openMaze = reader.readMaze("open maze.txt");
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);// create a new instance of node for each .
			}
			System.out.println("");
		}
		
		reader = new MazeReader();
		
		char[][] mediumMaze = reader.readMaze("medium maze.txt");
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{
				System.out.print(mediumMaze[i][j]);
			}
			System.out.println("");

		}
		
		reader = new MazeReader();
		char[][] largeMaze = reader.readMaze("large maze.txt");
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{
				System.out.print(largeMaze[i][j]);//
			}
			System.out.println("");

		}		
		
	}

}