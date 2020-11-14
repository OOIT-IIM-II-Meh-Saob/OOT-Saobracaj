package geometry;

public class Test {

	public static void main(String[] args) {
		// VEZBE 2
		Point p1 = new Point();
		p1.setX(3);
		p1.setY(5);
		p1.setSelected(true);

		System.out.println("X koordinata tacke p1 je: " + p1.getX());
		System.out.println("Y koordinata tacke p1 je: " + p1.getY());
		System.out.println("Parametar selected ima vrednost: " + p1.isSelected());
		
		Point p2 = new Point();
		p2.setX(13);
		p2.setY(15);
		p2.setSelected(true);
		
		System.out.println("Udaljenost izmedju tacaka p1 i p2 je: " + p2.distance(p1.getX(), p1.getY()));
		p1.setX(p2.getX());
		System.out.println("Udaljenost izmedju tacaka p1 i p2 je: " + p2.distance(p1.getX(), p1.getY()));
	
		p1 = p2;
		
		// VEZBE 3
		Line l1 = new Line();
		l1.setStartPoint(p1);
		l1.setEndPoint(p2);
		l1.setSelected(true);
		
		p1.setX(33);
		l1.getStartPoint().setX(55);
		
		System.out.println("X startPoint l1: " + l1.getStartPoint().getX());
		System.out.println("X p1: " + p1.getX());
		
		Line l2 = new Line();
		l2.setEndPoint(new Point());
		l2.getEndPoint().setY(12);
		l2.getEndPoint().setX(10);
		System.out.println("X endPoint l2: " + l2.getEndPoint().getX());
		
		Rectangle r1 = new Rectangle();
		System.out.println("Area r1: " + r1.area());
		r1.setUpperLeft(l1.getEndPoint());
		
		Rectangle r2 = new Rectangle();
		r2.setUpperLeft(new Point());
		r2.getUpperLeft().setY(15);
		r2.setHeight(10);
		r2.setWidth(15);
		System.out.println("Circumference r2: " + r2.circumference());
		
		Circle c1 = new Circle();
		c1.setCenter(p2);
		System.out.println("\n\nX center c1: " + c1.getCenter().getX() +
				"\n\tY center c1: " + c1.getCenter().getY() +
				"\nRadius c1: " + c1.getR());
		
		// Postaviti radijus kruga c1 na vrednost udaljenosti tacaka centra kruga
		// c1 i pocetne tacke linije l1
		c1.setR((int) c1.getCenter().distance(l1.getStartPoint().getX(), l1.getStartPoint().getY()));
	
		// Postaviti parametar selected kruga c1 na vrednost izraza koji proverava
		// da li je x centra kruga c1 vece od y koordinate tacke gore levo 
		// pravougaonika r1
		c1.setSelected(c1.getCenter().getX() > r1.getUpperLeft().getY());
		
		// Postaviti y koordinatu krajnje tacke linije l1 na vrednost razlike 
		// koordinata centra kruga c1 umanjene za vrednost zbira x koordinate 
		// tacke gore levo pravougaonika r1 i povrsine kruga c1
		l1.getEndPoint().setY((int) ((c1.getCenter().getX() - c1.getCenter().getY())
				- (r1.getUpperLeft().getX() + c1.area())));
	}

}
