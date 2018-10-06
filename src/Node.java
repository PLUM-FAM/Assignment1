
/*
 * class Node so we can create individual instances of each dot (movable space) in the maze.
 * each instance of node needs an x and y coordinate and a parent for reference when we are searching the maze.
 */
	public class Node {

	private int x;
	private int y;
	private Node parent;
	
	//constructor for instance variables.
	public Node(int x, int y, Node parent)
	{
		this.x =x;
		this.y =y;
		this.parent = parent;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public Node getParent()
	{
		return parent;
	}
}
