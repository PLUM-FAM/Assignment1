
/*
 * 
 */
	public class NodeH {

	private int x;
	private int y;
	private double h; //used to store heuristic value
	
	//constructor for instance variables.
	public NodeH(int x, int y, double h)
	{
		this.x =x;
		this.y =y;
		this.h = h;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public double getH()
	{
		return h;
	}
}
