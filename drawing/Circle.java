package drawing;

import java.awt.*;

public class Circle extends Shape implements Drawable {

    protected double radius=100;
    static int free_ID = 1;
    
    Circle(Point location, double radius, Color solidColor, Color borderColor) {
        super(location, solidColor, borderColor);
        this.radius=radius;
        ID = free_ID;
        type = Type.Circle;
        free_ID++;
    }

    @Override
    public void render(Graphics2D G) {
        G.setColor(solidColor);
        G.fillOval((int)(location.x-radius),(int)(location.y-radius),(int)radius*2,(int)radius*2);

        Stroke stroke=G.getStroke();
        G.setStroke(new BasicStroke(thickness));
        G.setColor(borderColor);
        G.drawOval((int)(location.x-radius),(int)(location.y-radius),(int)radius*2,(int)radius*2);
        G.setStroke(stroke);
    }

    public boolean isIn(Point p) {
        double dist=location.subtract(p).getRad();
        return dist<radius;
    }

    @Override
    public void increaseArea (double step){
        this.radius += step;

    }


    @Override
    public void MoveLocation(Point Step){
        this.location = this.location.add(Step);
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public int getBorderSize() {
        return this.thickness;
    }

    @Override
    public void increaseBorderSize(int Step) {
        this.thickness += Step;
    }
}
