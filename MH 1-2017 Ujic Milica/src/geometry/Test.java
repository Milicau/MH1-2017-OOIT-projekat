package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TACKA
		Point p1 = new Point(30, 30);
		System.out.println(p1);
		p1.moveBy(2, 3);
		System.out.println(p1);
		p1.moveTo(2, 3);
		System.out.println(p1);
		System.out.println(p1.distance(3, 2));
		
		//LINIJA
		Line l1 = new Line(new Point(p1.getX(), p1.getY()), new Point(50, 50));
		System.out.println(l1);
		l1.moveBy(2, 3);
		System.out.println(l1);
		l1.moveTo(2, 3);
		System.out.println(l1);
		System.out.println(l1.length());
		
		//KRUG
		Circle c1 = new Circle(p1, 8);
		System.out.println(c1);
		c1.moveBy(2, 3);
		System.out.println(c1);
		c1.moveTo(5, 3);
		System.out.println(c1);
		System.out.println(c1.area());
		Circle c2 = c1;
		System.out.println(c1.equals(c2));
		System.out.println(c1.contains(80, 60));
		System.out.println(c1.contains(p1));
		
		//PRAVOUGAONIK
		Rectangle r1 = new Rectangle(new Point(10, 50), 40, 50);
		System.out.println(r1);
		r1.moveBy(2, 3);
		System.out.println(r1);
		r1.moveTo(2, 8);
		System.out.println(r1);
		System.out.println(r1.area());
		System.out.println(r1.contains(p1));
		System.out.println(p1);
		System.out.println(r1.contains(5, 9));
		
		//KROFNA
		Donut d1 = new Donut(p1, 50, 20);
		System.out.println(d1);
		System.out.println(d1.area());
	}

}
