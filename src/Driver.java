
import java.util.*;
import java.io.*;

public class Driver 
{	
	//Queue created for BFS
	public static Queue<Node> q = new LinkedList<Node>();
	
	// Stack created for DFS
	public static Stack<Node> s = new Stack<>();
	
	//Array List for Astar search.
	public static ArrayList<NodeH> a = new ArrayList<NodeH>();
	
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
	
	// GREEDY path cost & nodes expanded counter
	static int greedyPathCost = 0;
	static int greedyNodesExpanded = 0;
	
	//ASTAR path cost counter variable
	static int astarPathCost = 0;
	static int astarNodesExpanded = 0;
	
	
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
		
		printOpenMaze();
		
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
		printMediumMaze();
		
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
		printLargeMaze();
		
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
		
		printOpenMaze();
		
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
		
		printMediumMaze();
		
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
		
		printLargeMaze();
		
		// Printing out DFS nodes expanded and Path cost for large maze
		System.out.println("End of DFS - Nodes Expanded for large maze.txt = " + dfsNodesExpanded );
		System.out.println("             Path Cost for large maze.txt = " + dfsPathCost + "\n");
		
		//reset all mazes after DFS
		resetMazes(reader);
		
		
		
		/*
		 * *********************************************************************
		 * OPEN MAZE GREEDY FIRST 
		 * *********************************************************************
		 */
		NodeH l = greedyFirst(openMaze, 37,20, openMazeStartx, openMazeStarty, openMazeFinishx, openMazeFinishy);
		
		// nested for loop to print out the new maze with the path traveled using greedy first search
		printOpenMaze();
		
		// Printing out GREEDY FIRST nodes expanded and Path cost for large maze
		System.out.println("End of OPEN GREEDY FIRST - Nodes Expanded for open maze.txt = " + astarNodesExpanded );
		System.out.println("                   Path Cost for open maze.txt = " + astarPathCost + "\n");		
		
		/*
		 * *********************************************************************
		 * MEDIUM MAZE GREEDY FIRST 
		 * *********************************************************************
		 */
		NodeH l1 = greedyFirst(mediumMaze, 61,23, mediumMazeStartx, mediumMazeStarty, mediumMazeFinishx, mediumMazeFinishy);
		
		// nested for loop to print out the new maze with the path traveled using greedy first search
		printMediumMaze();
		
		// Printing out GREEDY FIRST nodes expanded and Path cost for large maze
		System.out.println("End of MEDIUM GREEDY FIRST - Nodes Expanded for open maze.txt = " + astarNodesExpanded );
		System.out.println("           		     Path Cost for medium maze.txt = " + astarPathCost + "\n");
		
		/*
		 * *********************************************************************
		 * LARGE MAZE GREEDY FIRST 
		 * *********************************************************************
		 */
		NodeH l2 = greedyFirst(largeMaze, 81,31, largeMazeStartx, largeMazeStarty, largeMazeFinishx, largeMazeFinishy);
		
		// nested for loop to print out the new maze with the path traveled using greedy first search
		printLargeMaze();
		
		// Printing out DFS nodes expanded and Path cost for large maze
		System.out.println("End of LARGE GREEDY FIRST - Nodes Expanded for open maze.txt = " + astarNodesExpanded );
		System.out.println("             		ePath Cost for large maze.txt = " + astarPathCost + "\n");
		//reset all mazes after GREEDY FIRST
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
	

    


	
	public static NodeH greedyFirst(char[][] m, int mxbound, int mybound, int x, int y, int fX, int fY)
	{
		//a is the instance of arraylist
		NodeH p = new NodeH(x,y,999999999);
		a.add(p);
		
		while(a.isEmpty() != true)
		{
		
			//search arraylist for node with lowest h value		
			p = new NodeH(x,y,999999999); //this line resets p so that if the old p is still the smallest, the program doesnt stay on that node forever (infinite loop)
			for (NodeH n : a)
			{
				if(n.getH() < p.getH()) 
				{
					p = n;
				}
			}
			//remove p from arraylist.
			a.remove(p);
			astarPathCost++;
			
			//TODO
			//add frontier of p to a
			//also need to include a goal check (when frontier is added).
			//are goal checks in the right spot for a*? will this affect nodes expanded vs path cost.
			
			if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) //east
            {
                NodeH nextP = new NodeH(p.getX()+1,p.getY(), findDistance(p.getX()+1,p.getY(), fX,fY)); 
                a.add(nextP);
                astarNodesExpanded++;
                if (m[nextP.getY()][nextP.getX()] == '*') { //goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }
            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) //west
            {
                NodeH nextP = new NodeH(p.getX()-1,p.getY(), findDistance(p.getX()-1,p.getY(), fX, fY)); 
                a.add(nextP);
                astarNodesExpanded++;

                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) //south
            {
                NodeH nextP = new NodeH(p.getX(),p.getY()+1, findDistance(p.getX(),p.getY()+1, fX, fY)); 
                a.add(nextP);
                astarNodesExpanded++;

                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                	System.out.println("Exit is reached!");
                    return nextP;//exit is reached
                }
                m[nextP.getY()][nextP.getX()] = '.';//mark where we have been.
            }


             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) //north
             {
                NodeH nextP = new NodeH(p.getX(),p.getY()-1, findDistance(p.getX(),p.getY()-1, fX, fY)); 
                a.add(nextP);
                astarNodesExpanded++;
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
	 * finding the cardinal distance to the finish state using the distance formula & the inputted x and y coords to the finish state x and y coords.
	 * this methods is used for heuristics
	 * distance = sqrt((x2-x1)^2 + (y2-y1)^2)
	 * cX = current node x coord
 	 * cY = current node y coord
 	 * fX = finish node x coord
 	 * fY = finish node y coord
	 */
	public static double findDistance(int cX, int cY, int fX, int fY)
	{
		int x = fX-cX;
		int y = fY-cY;
		double x2 = Math.pow(x, 2);
		double y2 = Math.pow(y, 2);
		double d = Math.sqrt(x2+y2);	
		return d;
		
	}
	
	/*
	 * finding the astar heuristic by using the following:
	 * f(n)=g(n)+h(n)
	 * where n is the next node on the path, g(n) is the cost of the path from the start node to n,
 	 * and h(n) is a heuristic function that estimates the cost of the cheapest path from n to the goal. 
 	 * 
 	 * Calls our findDistance function to do the actual math.
 	 * cX = current node x coord
 	 * cY = current node y coord
 	 * fX = finish node x coord
 	 * fY = finish node y coord
 	 * sX = start node x coord
 	 * sY = start node y coord
	 */
	public static double findAstarHeuristic(int cX, int cY, int fX, int fY, int sX, int sY)
	{
		double dToS = findDistance(cX,cY,sX,sY);
		double dToF = findDistance(cX, cY, fX, fY);
		return dToF + dToS;
				
	}
	
	private static void printOpenMaze() {
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 37; j++)
			{
				System.out.print(openMaze[i][j]);
			}
			System.out.println("");
		}
	}
	private static void printMediumMaze() {
		for(int i = 0; i < 23; i++)
		{
			for(int j = 0; j < 61; j++)
			{
				System.out.print(mediumMaze[i][j]);
			}
			System.out.println("");
		}
	}
	private static void printLargeMaze() {
		for(int i = 0; i < 31; i++)
		{
			for(int j = 0; j < 81; j++)
			{
				System.out.print(largeMaze[i][j]);
			}
			System.out.println("");
		}
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