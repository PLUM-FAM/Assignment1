
	public class Node {

	private int x;
	private int y;
	private Node parent;
	
	
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
