package entities;

import entities.enums.Color;
import entities.interfaces.Shape;

public abstract class AbstractShape implements Shape { //não implementa aqui pois é classe abstrata.
    private Color color;                               //As classes que herdam implementam.

    public AbstractShape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}