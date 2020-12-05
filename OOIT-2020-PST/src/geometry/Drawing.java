package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		Point p1 = new Point(50, 50);
		p1.draw(g);
		g.setColor(Color.RED);
		Line l1 = new Line(new Point(100, 100), new Point(200, 200));
		l1.draw(g);
		g.setColor(Color.GREEN);
		l1.getStartPoint().draw(g);
		
		g.setColor(Color.BLACK);
		Rectangle r1 = new Rectangle(l1.getEndPoint(), 100, 50);
		r1.draw(g);
		
		Circle c1 = new Circle(new Point(500, 100), 80);
		c1.draw(g);
		c1.getCenter().draw(g);
		
		Donut d1 = new Donut(new Point(800, 100), 50, 25);
		d1.draw(g);
		
		Rectangle r2 = new Rectangle(new Point(500, 500), 50, 50);
		r2.draw(g);
		
		int innerRD2 = (int)(r2.getHeight()*Math.sqrt(2))/2;

		Donut d2 = new Donut(new Point(r2.getUpperLeft().getX()+r2.getHeight()/2,r2.getUpperLeft().getY()+r2.getHeight()/2)
				, 80, innerRD2);
		d2.draw(g);
	}

}
