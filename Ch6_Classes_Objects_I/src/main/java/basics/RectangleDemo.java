package basics;

public class RectangleDemo {

	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle(4, 3);

		System.out.println(rectangle);
		System.out.println("Area: " + rectangle.getArea());
		System.out.println("Perimeter: " + rectangle.getPerimeter());

		rectangle.setLength(10);
		rectangle.setWidth(5);

		System.out.println(rectangle);
		System.out.println("Area: " + rectangle.getArea());
		System.out.println("Perimeter: " + rectangle.getPerimeter());

        Rectangle kitchen = new Rectangle(23, 30);
        Rectangle bedroom = new Rectangle();
        Rectangle den = new Rectangle();

	}
}
