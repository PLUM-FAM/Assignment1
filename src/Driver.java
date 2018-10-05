
import java.util.*;
import java.io.*;

public class Driver 
{	
	
	public static Queue<Node> q = new LinkedList<Node>();
	public static int openMazeStartx;
	public static int openMazeStarty;
	public static int openMazeFinishx;
	public static int openMazeFinishy;
	
	static char[][] openMaze;
	static char[][] mediumMaze;
	static char[][] largeMaze;
	
	
	public static void main(String args[])
	{
		MazeReader reader = new MazeReader();
		

		openMaze = reader.readMaze("open maze.txt");
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				//System.out.print(openMaze[i][j]);
				
				//figure out start & finish state for open maze
				if(openMaze[i][j] == 'P')//start
				{
					openMazeStartx =j;
					openMazeStarty = i;
				}
				if(openMaze[i][j] == '*')//finish
				{
					openMazeFinishx =j;
					openMazeFinishy =i;
				}
				
			}
			//System.out.println("");
		}

		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
				
				//figure out start & finish state for open maze
				if(openMaze[i][j] == 'P')//start
				{
					openMazeStartx =j;
					openMazeStarty = i;
				}
				if(openMaze[i][j] == '*')//finish
				{
					openMazeFinishx =j;
					openMazeFinishy =i;
				}
				
			}
			System.out.println("");
		}
		
		System.out.println(openMazeStartx + " " + openMazeStarty);
		Node n = bfs(openMaze, openMazeStartx, openMazeStarty);
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
				
			}
			System.out.println("");
		}
		
		
		//reset maze after bfs


		
		
//		reader = new MazeReader();
//		
//		mediumMaze = reader.readMaze("medium maze.txt");
//		for(int i = 0; i < 23; i++)
//		{
//			for(int j = 0; j < 61; j++)
//			{
//				System.out.print(mediumMaze[i][j]);
//			}
//			System.out.println("");
//
//		}
//		
//		reader = new MazeReader();
//		largeMaze = reader.readMaze("large maze.txt");
//		for(int i = 0; i < 31; i++)
//		{
//			for(int j = 0; j < 81; j++)
//			{
//				System.out.print(largeMaze[i][j]);//
//			}
//			System.out.println("");
//
//		}		
//		
//	}
	}
		
		
	public static Node bfs(char[][] m, int x, int y)
	{
		System.out.println("in bfs");
		q.add(new Node(x, y, null));

        while(!q.isEmpty()) {
            Node p = q.remove();

            if (m[p.getY()][p.getX()] == '*') {
                System.out.println("Exit is reached!");
                return p;
            }

            if(isFree(m, p.getX()+1,p.getY())) 
            {
                m[p.getX()][p.getY()] = '*';
                Node nextP = new Node(p.getX()+1,p.getY(), p);
                q.add(nextP);
            }

            if(isFree(m, p.getX()-1,p.getY())) {
                m[p.getX()][p.getY()] = '*';
                Node nextP = new Node(p.getX()-1,p.getY(), p);
                q.add(nextP);
            }

            if(isFree(m, p.getX(),p.getY()+1)) {
                m[p.getX()][p.getY()] = '*';
                Node nextP = new Node(p.getX(),p.getY()+1, p);
                q.add(nextP);
            }

             if(isFree(m, p.getX(),p.getY()-1)) {
                m[p.getX()][p.getY()] = '*';
                Node nextP = new Node(p.getX(),p.getY()-1, p);
                q.add(nextP);
            }
        }
        return null;
    }
	
    public static boolean isFree(char[][] m ,int x, int y) {
		System.out.println("in isfree" + x + " " + y);

        if((x >= 0 && x < m.length) && (y >= 0 && y < m[x].length) && (m[x][y] == '.' || m[x][y] == 'P')) {
            return true;
        }
        return false;
    }

}