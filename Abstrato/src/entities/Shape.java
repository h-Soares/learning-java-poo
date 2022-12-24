package entities;

import entities.enums.Color;

public abstract class Shape {//se tem algum método ABSTRATO, a classe tem que ser ABSTRATA!
    private Color color;

    public Shape() {
        super();
    }

    public Shape(Color color) {
        this.color = color;
    }

    public abstract double area();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }   
}