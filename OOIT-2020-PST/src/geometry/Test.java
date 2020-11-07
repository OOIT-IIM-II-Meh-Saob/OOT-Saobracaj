package geometry;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.setX(3);
		p1.setY(5);
		p1.setSelected(true);

		System.out.println("X koordinata tacke p1 je: " + p1.getX());
		System.out.println("Y koordinata tacke p1 je: " + p1.getY());
		System.out.println("Parametar selected ima vrednost: " + p1.getSelected());
		
		Point p2 = new Point();
		p2.setX(13);
		p2.setY(15);
		p2.setSelected(true);
		
		System.out.println("Udaljenost izmedju tacaka p1 i p2 je: " + p2.distance(p1.getX(), p1.getY()));
		p1.setX(p2.getX());
		System.out.println("Udaljenost izmedju tacaka p1 i p2 je: " + p2.distance(p1.getX(), p1.getY()));
	
		p1 = p2;
	}

}
