package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
            int num = scan.nextInt();
        List<Shape> shapes = new ArrayList<>();
        System.out.println();
        
        for(int i = 1; i <= num; i++) {
            System.out.println("Shape #" + i + " data:");
            System.out.print("Rectangle or Circle? (r/c): ");
                char rc = scan.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
                scan.nextLine();
                Color color = Color.valueOf(scan.nextLine().toUpperCase());
            
            if(rc == 'r') {
                System.out.print("Width: ");
                    double width = scan.nextDouble();
                System.out.print("Height: ");
                    double height = scan.nextDouble();
                shapes.add(new Rectangle(color, width, height));
                System.out.println();
            }
            else if (rc == 'c') {
                System.out.print("Radius: ");
                    double radius = scan.nextDouble();
                shapes.add(new Circle(color, radius));
                System.out.println();
            }
        }
        System.out.println("SHAPE AREAS:");
        for(Shape shape : shapes)
            System.out.println(shape.area());
        
        scan.close();
    }
}