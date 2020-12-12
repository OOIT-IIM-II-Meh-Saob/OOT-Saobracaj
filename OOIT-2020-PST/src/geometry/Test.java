package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// VEZBE 2
		Point p1 = new Point();
		p1.setX(3);
		p1.setY(5);
		p1.setSelected(true);
		
		System.out.println("X koordinata tacke p1 je: " + p1.getX());
		System.out.println("Y koordinata tacke p1 je: " + p1.getY());
		System.out.println("Selected je postavljeno na: " + p1.isSelected());
		
		Point p2 = new Point();
		p2.setX(13);
		p2.setY(15);
		p2.setSelected(true);
		
		double distance = p1.distance(p2.getX(), p2.getY());
		System.out.println("Udaljenost izmedju tacaka p1 i p2 je " + distance);
		p1.setX(p2.getX());
		double distance2 = p1.distance(p2.getX(), p2.getY());
		System.out.println("Udaljenost izmedju tacaka p1 i p2 je " + distance2);
		
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
		l2.setStartPoint(p2);
		l2.setEndPoint(new Point());
		l2.getEndPoint().setY(20);
		
		// Izracunati i ispisati udaljenost pocetne tacke linije l1 i krajnje tacke linije l2
		System.out.println(l1.getStartPoint().distance(l2.getEndPoint().getX(), l2.getEndPoint().getY()));
	
		Rectangle r1 = new Rectangle();
		System.out.println("Area r1: " + r1.area());
		
		r1.setUpperLeft(l2.getEndPoint());
		
		r1.setHeight(10);
		r1.setWidth(15);
		System.out.println("Area r1: " + r1.area());
		
		Rectangle r2 = new Rectangle();
		r2.setUpperLeft(new Point());
		r2.setHeight(5);
		r2.setWidth(10);
		System.out.println("Circumference r2: " + r2.circumference());
		
		Circle c1 = new Circle();
		c1.setCenter(new Point());
		System.out.println("\n\nX center c1: " + c1.getCenter().getX() +
				"\nY center c1: " + c1.getCenter().getY() + 
				"\nR c1: " + c1.getR() +
				"\nSelected c1: " + c1.isSelected());
		
		// Postaviti radijus kruga c1 na vrednost udaljenosti centra kruga c1 i pocetne tacke linije l1
		c1.setR((int) c1.getCenter().distance(l1.getStartPoint().getX(), l1.getStartPoint().getY()));
		System.out.println("R c1: " + c1.getR());
		
		// Postaviti selected parametar kruga c1 na vrednost izraza koji proverava da li je x centra kruga c1 vece od y koordinate upperLeft tacke r1
		c1.setSelected(c1.getCenter().getX() > r1.getUpperLeft().getY());
		System.out.println(c1.isSelected());
		
		// Postaviti y koordinatu krajnje tacke l1 na vrednost razlike koordinata centra kruga c1 umanjene
		// za vrednost zbira x koordinate upperLeft tacke pravougaonika r1 i povrsine kruga c1
		l1.getEndPoint().setY((int) ((c1.getCenter().getX() - c1.getCenter().getY()) 
				-
				(r1.getUpperLeft().getX() + c1.area())));
		System.out.println(l1.getEndPoint().getY());
		
		// VEZBE 4
		System.out.println(p1);
		System.out.println(l1);
		System.out.println(r1);
		System.out.println(c1);
		
		p1 = p2;
		
		Point p3 = new Point(6, 7);
		Line l3 = new Line(p3, new Point(12, 13));
		Rectangle r3 = new Rectangle(new Point(p3.getX(), p3.getY()), 50, 100);
		
		p3.setX(50);
		
		System.out.println("X p3: " + p3.getX());
		System.out.println("X startPoint l3: " + l3.getStartPoint().getX());
		System.out.println("X upperLeft r3: " + r3.getUpperLeft().getX());
		
		Circle c3 = new Circle(new Point(), 10, true);
		System.out.println(c3);
		
		// Kreirati pravougaonik r4 tako da ima iste koordinate kao pocetna tacka
		// linije l3 i tako da se promenom x i y koordinata pocetne tacke linije l3
		// ne promene x i y koordinate tacke gore levo pravougaonika r4
		// Visina treba da bude jednaka duzini linije l3
		// Sirina treba da bude jednaka povrsini pravougaonika r3 umanjenoj za povrsinu
		// kruga c3
		// Selected parametar postaviti na vrednost izraza konjukcije selected krajnje 
		// tacke linije l3 i p3
		Rectangle r4 = new Rectangle(new Point(l3.getStartPoint().getX(), l3.getStartPoint().getY()),
				(int) (r3.area() - c3.area()), (int) l3.length(), 
				l3.getEndPoint().isSelected() && p3.isSelected());
		
		System.out.println(r4 + ", selected: " + r4.isSelected());
		
		Point p5 = new Point(5, 6);
		Point p6 = p5;
		Point p7 = new Point(5, 6);
		
		System.out.println("p5 == p6: " + (p5 == p6));
		System.out.println("p5 == p7: " + (p5 == p7));
		
		System.out.println("p5 equals p6: " + p5.equals(p6));
		System.out.println("p5 equals p7: " + p5.equals(p7));
		
		System.out.println("p5 equals l3: " + p5.equals(l3));
		
		Line l4 = new Line(new Point(10, 11), new Point(12, 13));
		Line l5 = new Line(new Point(10, 11), new Point(12, 13));
		
		System.out.println("l4 equals l5: " + l4.equals(l5));
		
		// VEZBE 5
		Point p8 = new Point(6, 7);
		System.out.println("p7 contains p8: " + p7.contains(p8.getX(), p8.getY()));
		System.out.println("p7 contains p8 + 1: " + p7.contains(p8.getX() + 1, p8.getY() + 1));
		
		Line l6 = new Line(new Point(10, 15), new Point(20, 25));
		System.out.println("l6 contains (21, 25): " + l6.contains(21, 25));
		
		Circle c4 = new Circle(p5, 10);
		System.out.println("c4 contains p8: " + c4.contains(p8));
		System.out.println("c4 contains (6, 7): " + c4.contains(6, 7));
		
		Donut d1 = new Donut();
		// d1.center = new Point(10, 20);
		d1.setCenter(new Point(10, 20));
		d1.setInnerR(10);
		d1.setR(50);
		
		System.out.println(d1);
		System.out.println("d1 contains (24, 20): " + d1.contains(24, 20));
		Circle c5 = new Circle(d1.center, d1.r);
		System.out.println("d1 equals c5: " + d1.equals(c5));
		
		Donut d2 = new Donut(new Point(10, 20), 50, 10);
		System.out.println("d1 equals d2: " + d1.equals(d2));
		
		System.out.println("d1 area: " + d1.area());
		System.out.println("d1 circumference: " + d1.circumference());
		
		//VEZBE 7
		System.out.println("\nVezbe 7:");
		System.out.println(p1);
		p1.moveBy(5, 3);
		System.out.println(p1);
		p1.moveTo(5, 3);
		System.out.println(p1);
		
		System.out.println(l1);
		l1.moveBy(5, 3);
		System.out.println(l1);
		l1.moveTo(5, 3);
		System.out.println(l1);
		
		System.out.println(r1);
		r1.moveBy(5, 3);
		System.out.println(r1);
		r1.moveTo(5, 3);
		System.out.println(r1);
		
		System.out.println(c1);
		c1.moveBy(5, 3);
		System.out.println(c1);
		c1.moveTo(5, 3);
		System.out.println(c1);
		
		System.out.println(d1);
		d1.moveBy(5, 3);
		System.out.println(d1);
		d1.moveTo(5, 3);
		System.out.println(d1);
		
		Shape d3 = new Donut(p1, 10, 2);
		Shape p9 = new Point();
		Shape l9 = l1;
		Shape c9 = c1;
		
		//Shape[] shapes = new Shape[4];
		Shape[] shapes = { d3, p9, l9, c9 };
		System.out.println("\n");
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}
		
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].moveBy(1, 2);
		}
		
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}
		
		int[] ints = { 5, 2, 3, 4, 1 };
		System.out.println("Nesortiran niz: ");
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		
		Arrays.sort(ints);
		
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		
		Point p10 = new Point(10, 10);
		Point p20 = new Point(20, 20);
		Point p30 = new Point(30, 30);
		Point p40 = new Point(40, 40);
		Point[] points = {p30, p10, p20, p40};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		
		Arrays.sort(points);
		
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		
		Line l10 = new Line(new Point(10, 10), new Point(100, 100));
		Line l20 = new Line(new Point(20, 20), new Point(200, 200));
		Line l30 = new Line(new Point(30, 30), new Point(300, 300));
		Line l40 = new Line(new Point(40, 40), new Point(400, 400));
		
		Line[] lines = {l30, l10, l20, l40};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
		
		Arrays.sort(lines);
		
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
		
		Rectangle r10 = new Rectangle(p1, 10, 10);
		Rectangle r20 = new Rectangle(p2, 20, 20);
		Rectangle r30 = new Rectangle(p3, 30, 30);
		
		Rectangle[] rectangles = {r30, r10, r20};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i] + ", area: " + rectangles[i].area());
		}
		
		Arrays.sort(rectangles);
		
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i] + ", area: " + rectangles[i].area());
		}
		
		Circle c10 = new Circle(p1, 10);
		Circle c20 = new Circle(p1, 20);
		Circle c30 = new Circle(p1, 30);
		Donut d40 = new Donut(p1, 30, 10);
		
		Circle[] circles = {c30, c10, c20, d40};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < circles.length; i++) {
			System.out.println(circles[i] + ", area: " + circles[i].area());
		}
		
		Arrays.sort(circles);
		
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < circles.length; i++) {
			System.out.println(circles[i] + ", area: " + circles[i].area());
		}
		
		
	}

}
