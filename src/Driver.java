
import java.util.*;
import java.io.*;

public class Driver 
{	
	
	public static Queue<Node> q = new LinkedList<Node>();
	public static Stack<Node> s = new Stack<>();
	
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
	static int dfsNodesExpanded = 0;
	static int dfsPathCost = 0;
	static int greedyCost = 0;
	static int astarCost = 0;
	
	
	public static void main(String args[])
	{
		MazeReader reader = new MazeReader();
		
		//Reading all maze files and getting initial values
		resetMazes(reader);
		getStartandFinish();
		
//		/*
//		 * ************************************
//		 * OPEN MAZE BFS 
//		 * ************************************
//		 */
//		
//		
//		Node n = bfs(openMaze, 37,20, openMazeStartx, openMazeStarty);
//		for(int i = 0; i < 20; i++)
//		{
//			for(int j = 0; j < 37; j++)
//			{
//				System.out.print(openMaze[i][j]);
//			}
//			System.out.println("");
//		}
//		System.out.println("End of BFS - Cost for open maze.txt = " + bfsCost);
//		
//		
//
//		/*
//		 * ************************************
//		 * MEDIUM MAZE BFS 
//		 * ************************************
//		 */
//		
//		Node m = bfs(mediumMaze, 61,23, mediumMazeStartx, mediumMazeStarty);
//		for(int i = 0; i < 23; i++)
//		{
//			for(int j = 0; j < 61; j++)
//			{
//				System.out.print(mediumMaze[i][j]);
//			}
//			System.out.println("");
//		}
//		System.out.println("End of BFS - Cost for medium maze.txt = " + bfsCost);
//		
//		
//		/*
//		 * ***********************************************************************
//		 * LARGE MAZE BFS 
//		 * ***********************************************************************
//		 */
//		
//		
//		Node o = bfs(largeMaze, 81, 31, largeMazeStartx, largeMazeStarty);
//		for(int i = 0; i < 31; i++)
//		{
//			for(int j = 0; j < 81; j++)
//			{
//				System.out.print(largeMaze[i][j]);
//			}
//			System.out.println("");
//		}
//		System.out.println("End of BFS - Cost for large maze.txt = " + bfsCost);
		
//		resetMazes(reader);
		
	
		
		/*
		 * *************************************************************************
		 * OPEN MAZE DFS 
		 * *************************************************************************
		 */
		
		Node r = dfs(openMaze, 37,20, openMazeStartx, openMazeStarty);
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("End of DFS - Nodes Expanded for open maze.txt = " + dfsNodesExpanded);
		System.out.println("             Path Cost for open maze.txt = " + dfsPathCost + "\n");
		

		/*
		 * *********************************************************************
		 * MEDIUM MAZE DFS 
		 * *********************************************************************
		 */
		
		Node p = dfs(mediumMaze, 61,23, mediumMazeStartx, mediumMazeStarty);
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{
				System.out.print(mediumMaze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("End of DFS - Nodes Expanded for medium maze.txt = " + dfsNodesExpanded );
		System.out.println("             Path Cost for medium maze.txt = " + dfsPathCost + "\n");
		
		/*
		 * *********************************************************************
		 * LARGE MAZE DFS 
		 * *********************************************************************
		 */
		
		
		Node q = dfs(largeMaze, 81, 31, largeMazeStartx, largeMazeStarty);
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{
				System.out.print(largeMaze[i][j]);
			}
			System.out.println("");
		}
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
		
		// finding large maze start and finish coordinates
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
	}

	private static void resetMazes(MazeReader reader) {
		openMaze = reader.readMaze("open maze.txt");
		mediumMaze = reader.readMaze("medium maze.txt");
		largeMaze = reader.readMaze("large maze.txt");
	}	
	
	
	/*
	 * out breadth-first search method uses a queue data structure to keep track of visited nodes and uses a set of conditional statements to add valid
	 * nodes to the current frontier.
	 */
		
	public static Node bfs(char[][] m, int mxbound, int mybound, int x, int y)
	{
		bfsCost = 0; //reset cost for new instance
		
		q.add(new Node(x, y, null));

        while(!q.isEmpty()) {
        	
            Node p = q.remove(); //p is the current node/point that we are looking at. the frontier of p includes valid nodes to the east, west, south, and north of p.

            
            /* 
             * this group of conditional statements checks the frontier in this order (east,west,south,north)
             * for valid nodes to add to the queue.
             */
            if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) //east
            {
                Node nextP = new Node(p.getX()+1,p.getY(), p); 
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') { //goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.'; //mark where we have been.
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) { //west
                Node nextP = new Node(p.getX()-1,p.getY(), p); 
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) { //south
                Node nextP = new Node(p.getX(),p.getY()+1, p); 
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                	System.out.println("Exit is reached!");
                	return nextP;//exit is reached
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) { //north
                Node nextP = new Node(p.getX(),p.getY()-1, p); 
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

        }
        return null;
	}
	
	
	/*
	 * our depth first search uses a stack data structure to keep track of what nodes we are visiting through our search. It uses a similar method as BFS for
	 * finding the frontier and adding valid nodes to it.
	 */
	public static Node dfs(char[][] m, int mxbound, int mybound, int x, int y)
	{
		dfsNodesExpanded = 0; //reset cost for new instance
		dfsPathCost = 0;
		
		s.add(new Node(x, y, null));

        while(!s.isEmpty()) {
        	
            Node p = s.pop(); //the current node (or point) that we are looking at is popped off of the stack 
            
            dfsPathCost++; //every time we move to another node the path cost is increased by 1.

            /* 
             * this group of conditional statements checks the frontier in this order (east,west,south,north)
             * for valid nodes to add to the stack.
             */
            if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) //east
            {
                Node nextP = new Node(p.getX()+1,p.getY(), p); 
                s.add(nextP);
                dfsNodesExpanded++;
                if (m[nextP.getY()][nextP.getX()] == '*') { //goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) //west
            {
                Node nextP = new Node(p.getX()-1,p.getY(), p); 
                s.add(nextP);
                dfsNodesExpanded++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) //south
            {
                Node nextP = new Node(p.getX(),p.getY()+1, p); 
                s.add(nextP);
                dfsNodesExpanded++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                	System.out.println("Exit is reached!");
                    return nextP;//exit is reached
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) //north
             {
                Node nextP = new Node(p.getX(),p.getY()-1, p); 
                s.add(nextP);
                dfsNodesExpanded++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }
        }
        return null; //if no exit/goal state is found.
	}
	
	/*
	 * The isFree method takes in a maze (2d character array) its x and y bounds, and an x and y coord of the current node to check. 
	 *  It then checks if the coords are in bounds, and if the node at those coords is valid (i.e. is a 'o' or the finish state '*').
	 *  it returns true if all of those are true.
	 *  It returns false if the node being checked at coords x,y is out of bounds or is a wall (i.e. '%').
	 */
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