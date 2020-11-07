package geometry;

public class Point {
	private int x;
	private int y;
	private boolean selected;
	
	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
