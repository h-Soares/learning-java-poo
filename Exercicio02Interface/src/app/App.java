package app;

import entities.Circle;
import entities.Rectangle;
import entities.enums.Color;

public class App {
    public static void main(String[] args) {
        //ou AbstractShape = new Circle/Rectangle...
        Circle circle = new Circle(Color.BLACK, 2); 
        Rectangle rectangle = new Rectangle(Color.WHITE, 2, 2);

        System.out.println("Color: " + circle.getColor() + " Area: " + circle.area());
        System.out.println("Color: " + rectangle.getColor() + " Area: " + rectangle.area());
    }
}