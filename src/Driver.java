
import java.util.*;
import java.io.*;

public class Driver 
{	
	//Queue created for BFS
	public static Queue<Node> q = new LinkedList<Node>();
	
	// Stack created for DFS
	public static Stack<Node> s = new Stack<>();
	
	//Start and finish coordinate variables for open maze
	public static int openMazeStartx;
	public static int openMazeStarty;
	public static int openMazeFinishx;
	public static int openMazeFinishy;
	
	//Start and finish coordinate variables for medium maze
	public static int mediumMazeStartx;
	public static int mediumMazeStarty;
	public static int mediumMazeFinishx;
	public static int mediumMazeFinishy;
	
	//Start and finish coordinate variables for large maze
	public static int largeMazeStartx;
	public static int largeMazeStarty;
	public static int largeMazeFinishx;
	public static int largeMazeFinishy;
	
	// Creating a double char array for all mazes 
	static char[][] openMaze;
	static char[][] mediumMaze;
	static char[][] largeMaze;
	
	// path cost counter variable for BFS
	static int bfsCost = 0;
	
	// DFS counter variables for nodes expanded and path cost 
	static int dfsNodesExpanded = 0;
	static int dfsPathCost = 0;
	
	// GREEDY path cost counter variable
	static int greedyCost = 0;
	
	//ASTAR path cost counter variable
	static int astarCost = 0;
	
	
	public static void main(String args[])
	{
		// new MazeReader Instance named "reader"
		MazeReader reader = new MazeReader();
		
		//Reading all maze files and getting initial values using methods
		resetMazes(reader);
		getStartandFinish();
		
		/*
		 * ******************************************************************************
		 * OPEN MAZE BFS 
		 * ******************************************************************************
		 */
		
		// calling BFS method and setting the return value to node n
		// passing in the current maze, the dimensions of the current maze, and the starting coordinates
		Node n = bfs(openMaze, 37,20, openMazeStartx, openMazeStarty);
		
		// nested for loop to print out the new maze with the path traveled using BFS
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
			}
			System.out.println("");
		}
		
		// printing out the BFS path cost for open maze
		System.out.println("End of BFS - Cost for open maze.txt = " + bfsCost + "\n");
		

		/*
		 * *******************************************************************************
		 * MEDIUM MAZE BFS 
		 * *******************************************************************************
		 */
		
		// calling BFS method and setting the return value to node m
		// passing in the current maze, the dimensions of the current maze, and the starting coordinates
		Node m = bfs(mediumMaze, 61,23, mediumMazeStartx, mediumMazeStarty);
		
		// nested for loop to print out the new maze with the path traveled using BFS
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{
				System.out.print(mediumMaze[i][j]);
			}
			System.out.println("");
		}
		
		// printing out the BFS path cost for medium maze
		System.out.println("End of BFS - Cost for medium maze.txt = " + bfsCost + "\n");
		
		
		/*
		 * ********************************************************************************
		 * LARGE MAZE BFS 
		 * ********************************************************************************
		 */
		
		// calling BFS method and setting the return value to node o
		// passing in the current maze, the dimensions of the current maze, and the starting coordinates
		Node o = bfs(largeMaze, 81, 31, largeMazeStartx, largeMazeStarty);
		
		// nested for loop to print out the new maze with the path traveled using BFS
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{
				System.out.print(largeMaze[i][j]);
			}
			System.out.println("");
		}
		
		// printing out the BFS path cost for large maze
		System.out.println("End of BFS - Cost for large maze.txt = " + bfsCost + "\n");
		
		//Reset all the mazes to their original values 
		resetMazes(reader);
		
	
		
		/*
		 * *************************************************************************
		 * OPEN MAZE DFS 
		 * *************************************************************************
		 */
		
		// calling DFS method and setting the return value to node r
		// passing in the current maze, the dimensions of the current maze, and the starting coordinates
		Node r = dfs(openMaze, 37,20, openMazeStartx, openMazeStarty);
		
		// nested for loop to print out the new maze with the path traveled using DFS
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
			}
			System.out.println("");
		}
		
		// Printing out DFS nodes expanded and Path cost for open maze
		System.out.println("End of DFS - Nodes Expanded for open maze.txt = " + dfsNodesExpanded);
		System.out.println("             Path Cost for open maze.txt = " + dfsPathCost + "\n");
		

		/*
		 * *********************************************************************
		 * MEDIUM MAZE DFS 
		 * *********************************************************************
		 */
		
		// calling DFS method and setting the return value to node p
		// passing in the current maze, the dimensions of the current maze, and the starting coordinates
		Node p = dfs(mediumMaze, 61,23, mediumMazeStartx, mediumMazeStarty);
		
		// nested for loop to print out the new maze with the path traveled using DFS
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{
				System.out.print(mediumMaze[i][j]);
			}
			System.out.println("");
		}
		
		// Printing out DFS nodes expanded and Path cost for medium maze
		System.out.println("End of DFS - Nodes Expanded for medium maze.txt = " + dfsNodesExpanded );
		System.out.println("             Path Cost for medium maze.txt = " + dfsPathCost + "\n");
		
		/*
		 * *********************************************************************
		 * LARGE MAZE DFS 
		 * *********************************************************************
		 */
		
		// calling DFS method and setting the return value to node q
		// passing in the current maze, the dimensions of the current maze, and the starting coordinates
		Node q = dfs(largeMaze, 81, 31, largeMazeStartx, largeMazeStarty);
		
		// nested for loop to print out the new maze with the path traveled using DFS
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{
				System.out.print(largeMaze[i][j]);
			}
			System.out.println("");
		}
		
		// Printing out DFS nodes expanded and Path cost for large maze
		System.out.println("End of DFS - Nodes Expanded for large maze.txt = " + dfsNodesExpanded );
		System.out.println("             Path Cost for large maze.txt = " + dfsPathCost + "\n");
		
		//reset all mazes after DFS
		resetMazes(reader);
	}




	private static void getStartandFinish() {
		
		// finding open maze start and finish coordinates
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
				
			{	
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
		}
		
		// finding Medium maze start and finish coordinates
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{	
				//figure out start & finish state for medium maze
				if(mediumMaze[i][j] == 'P')//start
				{
					mediumMazeStartx =j;
					mediumMazeStarty = i;
				}
				if(mediumMaze[i][j] == '*')//finish
				{
					mediumMazeFinishx =j;
					mediumMazeFinishy =i;
				}	
			}
		}
		
		// finding large maze start and finish coordinates
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{	
				//figure out start & finish state for large maze
				if(largeMaze[i][j] == 'P')//start
				{
					largeMazeStartx =j;
					largeMazeStarty = i;
				}
				if(largeMaze[i][j] == '*')//finish
				{
					largeMazeFinishx =j;
					largeMazeFinishy =i;
				}	
			}
		}
	}




	private static void resetMazes(MazeReader reader) {
		
		//Reading all default maze files
		openMaze = reader.readMaze("open maze.txt");
		mediumMaze = reader.readMaze("medium maze.txt");
		largeMaze = reader.readMaze("large maze.txt");
	}	
	
	
	
		
	public static Node bfs(char[][] m, int mxbound, int mybound, int x, int y)
	{
		bfsCost = 0; //reset cost for new instance
		
		q.add(new Node(x, y, null));
		

        while(!q.isEmpty()) {
        	
            Node p = q.remove();

            

            if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) 
            {
                Node nextP = new Node(p.getX()+1,p.getY(), p); //east
                q.add(nextP);
                bfsCost++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) {
                Node nextP = new Node(p.getX()-1,p.getY(), p); //west
                q.add(nextP);
                bfsCost++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) {
                Node nextP = new Node(p.getX(),p.getY()+1, p); //south
                q.add(nextP);
                bfsCost++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) {
                Node nextP = new Node(p.getX(),p.getY()-1, p); //north
                q.add(nextP);
                bfsCost++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

        }
        return null;
	}




	public static Node goalCheck(char[][] m, Node nextP) {
		if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
			System.out.println("Exit is reached!");
			return nextP;//exit is reached
		}
		return null;
	}
	
	
	public static Node dfs(char[][] m, int mxbound, int mybound, int x, int y)
	{
		dfsNodesExpanded = 0; //reset cost for new instance
		dfsPathCost = 0;
		
		s.add(new Node(x, y, null));

        while(!s.isEmpty()) {
        	
            Node p = s.pop();
            dfsPathCost++;

            if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) 
            {
                Node nextP = new Node(p.getX()+1,p.getY(), p); //east
                s.add(nextP);
                dfsNodesExpanded++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) {
                Node nextP = new Node(p.getX()-1,p.getY(), p); //west
                s.add(nextP);
                dfsNodesExpanded++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) {
                Node nextP = new Node(p.getX(),p.getY()+1, p); //south
                s.add(nextP);
                dfsNodesExpanded++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) {
                Node nextP = new Node(p.getX(),p.getY()-1, p); //north
                s.add(nextP);
                dfsNodesExpanded++;
                goalCheck(m, nextP);
                m[nextP.getY()][nextP.getX()] = '.';
            }
        }
        return null;
	}
	
	
    public static boolean isFree(char[][] m , int mxbound, int mybound, int x, int y) {
		
    	if((x >= 0 && x < mxbound) && (y >= 0 && y < mybound))
    	{
    			if((m[y][x] == 'o' || m[y][x] == '*')) 
    			{
    				return true;
    			}
        }
        return false;
    }
    
}