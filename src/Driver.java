
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
	static int dfsCost = 0;
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
		System.out.println("End of DFS - Cost for open maze.txt = " + dfsCost + "\n");
		
		

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
		System.out.println("End of DFS - Cost for medium maze.txt = " + dfsCost + "\n");
		
		
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
		System.out.println("End of DFS - Cost for large maze.txt = " + dfsCost + "\n");
		
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
	
	public static Node dfs(char[][] m, int mxbound, int mybound, int x, int y)
	{
		dfsCost = 0; //reset cost for new instance
		
		s.add(new Node(x, y, null));

        while(!s.isEmpty()) {
        	
            Node p = s.pop();

            if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) 
            {
                Node nextP = new Node(p.getX()+1,p.getY(), p); //east
                s.push(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') { //goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) {
                Node nextP = new Node(p.getX()-1,p.getY(), p); //west
                s.push(nextP);
                dfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) {
                Node nextP = new Node(p.getX(),p.getY()+1, p); //south
                s.push(nextP);
                dfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    return nextP;//exit is reached
                }
                m[nextP.getY()][nextP.getX()] = '.';
            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) {
                Node nextP = new Node(p.getX(),p.getY()-1, p); //north
                s.push(nextP);
                dfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
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