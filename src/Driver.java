
import java.util.*;
import java.io.*;

public class Driver 
{	
	
	public static Queue<Node> q = new LinkedList<Node>();
	
	public static int openMazeStartx;
	public static int openMazeStarty;
	public static int openMazeFinishx;
	public static int openMazeFinishy;
	
	public static int mediumMazeStartx;
	public static int mediumMazeStarty;
	public static int mediumMazeFinishx;
	public static int mediumMazeFinishy;
	
	public static int largeMazeStartx;
	public static int largeMazeStarty;
	public static int largeMazeFinishx;
	public static int largeMazeFinishy;
	
	static char[][] openMaze;
	static char[][] mediumMaze;
	static char[][] largeMaze;
	
	static int bfsCost = 0;
	static int dfsCost = 0;
	static int greedyCost = 0;
	static int astarCost = 0;
	
	
	public static void main(String args[])
	{
		/*
		 * ************************************
		 * OPEN MAZE BFS 
		 * ************************************
		 */
		
		MazeReader reader = new MazeReader();
		openMaze = reader.readMaze("open maze.txt");
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
		
		Node n = bfs(openMaze, 37,20, openMazeStartx, openMazeStarty);
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("End of BFS - Cost for open maze.txt = " + bfsCost);
		
		

		/*
		 * ************************************
		 * MEDIUM MAZE BFS 
		 * ************************************
		 */
		
		reader = new MazeReader();
		mediumMaze = reader.readMaze("medium maze.txt");
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{	
				//figure out start & finish state for open maze
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
		
		Node m = bfs(mediumMaze, 61,23, mediumMazeStartx, mediumMazeStarty);
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{
				System.out.print(mediumMaze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("End of BFS - Cost for medium maze.txt = " + bfsCost);
		
		
		/*
		 * ************************************
		 * LARGE MAZE BFS 
		 * ************************************
		 */
		
		reader = new MazeReader();
		largeMaze = reader.readMaze("large maze.txt");
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{	
				//figure out start & finish state for open maze
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
		
		Node o = bfs(largeMaze, 81, 31, largeMazeStartx, largeMazeStarty);
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{
				System.out.print(largeMaze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("End of BFS - Cost for large maze.txt = " + bfsCost);
		
		Node p = greedy(openMaze, 37,20, openMazeStartx, openMazeStarty);
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("End of Greedy - Cost for open maze.txt = " + greedyCost);
		
		//reset all mazes after BFS
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
                if (m[nextP.getY()][nextP.getX()] == '*') { //goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) {
                Node nextP = new Node(p.getX()-1,p.getY(), p); //west
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) {
                Node nextP = new Node(p.getX(),p.getY()+1, p); //south
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    return nextP;//exit is reached
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) {
                Node nextP = new Node(p.getX(),p.getY()-1, p); //north
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

        }
        return null;
	}
	
	/*
	 * Needs to find the Manhattan Distance from the children of the current node to the finish point
	 * The next node chosen should be the child with the shortest Manhattan Distance
	 * 
	 * TODO
	 * 1.) Find a way to pass in finish point without hard-coding each maze's finish
	 * 2.) Return the children as nodes
	 * 3.) Find each child's Manhattan Distance
	 * 4.) Compare and pick the shortest child
	 */
	public static Node greedy(char[][] m, int mxbound, int mybound, int x, int y)
	{
		greedyCost = 0;
		int manhattanDistance = 0;
		int finishx = 0;
		int finishy = 0;
		if(m == openMaze)
		{
			finishx = openMazeFinishx;
			finishy = openMazeFinishy;
		}
		else if(m == mediumMaze)
		{
			finishx = mediumMazeFinishx;
			finishy = mediumMazeFinishy;
		}
		else if(m == largeMaze)
		{
			finishx = largeMazeFinishx;
			finishy = largeMazeFinishy;
		}
		else
		{
			System.out.println("Unknown maze");
		}
		manhattanDistance = findManhattan(x, y, finishx, finishy);
		System.out.println("Manhattan Distance = " + manhattanDistance);
		return null;
	}
	
	public static int findManhattan(int currentNodex, int currentNodey, int finishx, int finishy)
	{
		return (Math.abs(currentNodex - finishx) + Math.abs(currentNodey - finishy));
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