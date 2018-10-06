
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
		
		//reset all mazes after BFS
		openMaze = reader.readMaze("open maze.txt");
		mediumMaze = reader.readMaze("medium maze.txt");
		largeMaze = reader.readMaze("large maze.txt");
	}
	
		
		
	public static Node bfs(char[][] m, int mxbound, int mybound, int x, int y)
	{
		
		q.add(new Node(x, y, null));

        while(!q.isEmpty()) {
        	
            Node p = q.remove();

            
//            System.out.println("Current node: " + p.getX() + ","+ p.getY() + " is " + openMaze[p.getY()][p.getX()] );

            if(isFree(m, mxbound, mybound, p.getX()+1,p.getY())) 
            {
                //m[p.getY()][p.getX()] = 'o';
                Node nextP = new Node(p.getX()+1,p.getY(), p); //east
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') { //goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';
                

//                System.out.println("Added to queue: " + nextP.getX() + "," + nextP.getY());
            }

            if(isFree(m, mxbound,mybound, p.getX()-1,p.getY())) {
                //m[p.getY()][p.getX()] = 'o';
                Node nextP = new Node(p.getX()-1,p.getY(), p); //west
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';

//                System.out.println("Added to queue: " + nextP.getX() + "," + nextP.getY());

            }

            if(isFree(m,mxbound,mybound, p.getX(),p.getY()+1)) {
                //m[p.getY()][p.getX()] = 'o';
                Node nextP = new Node(p.getX(),p.getY()+1, p); //south
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    return nextP;//exit is reached
                }
                m[nextP.getY()][nextP.getX()] = '.';

//                System.out.println("Added to queue: " + nextP.getX() + "," + nextP.getY());

            }

             if(isFree(m,mxbound,mybound, p.getX(),p.getY()-1)) {
                //m[p.getY()][p.getX()] = 'o';
                Node nextP = new Node(p.getX(),p.getY()-1, p); //north
                q.add(nextP);
                bfsCost++;
                if (m[nextP.getY()][nextP.getX()] == '*') {//goal test
                    System.out.println("Exit is reached!");
                    return nextP;
                }
                m[nextP.getY()][nextP.getX()] = '.';

//                System.out.println("Added to queue: " + nextP.getX() + "," + nextP.getY());

            }
             
             
             //print maze each time for testing
//             for(int i = 0; i < 20; i++)
//     		{
//     			for(int j = 0; j < 37; j++)
//     			{
//     				System.out.print(openMaze[i][j]);
//     				
//     			}
//     			System.out.println("");
//     		}
             //end print maze for testing
        }
        
        return null;
	}
	
    public static boolean isFree(char[][] m , int mxbound, int mybound, int x, int y) {
//		System.out.println("in isfree => x: " + x + " y: " + y);
//		System.out.println(m[y][x]);
		
    	if((x >= 0 && x < mxbound) && (y >= 0 && y < mybound)){
    			if((m[y][x] == 'o' || m[y][x] == '*')) {
//    				System.out.println("return true");
    				return true;
    				
    			}
        }
        return false;
    }
    
}