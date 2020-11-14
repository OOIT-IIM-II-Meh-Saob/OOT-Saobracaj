package geometry;

public class Circle {
	private Point center;
	private int r;
	private boolean selected;
	
	public double area() {
		return r * r * Math.PI;
	}
	
	public double circumference() {
		return 2 * r * Math.PI;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getR() {
		return r;
	}
	
	public void setR(int r) {
		this.r = r;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
