package drawing;

import java.awt.*;

public class Triangle extends Shape implements Drawable {

    Point vertices[];

    public Triangle(Point a,Point b, Point c,Color solidColor, Color borderColor) {
        super(new Point((a.getX()+b.getX()+c.getX())/3,(a.getY()+b.getY()+c.getY())/3),solidColor,borderColor);
        vertices=new Point[]{a.subtract(location),b.subtract(location),c.subtract(location)};
    }

    public Triangle(Point a,Point b, Point c) {
        this(a,b,c,Color.BLUE,Color.ORANGE);
    }

    public double getArea() {
        return 1;
    }

    @Override
    public void render(Graphics2D G) {
        G.setColor(solidColor);
        Point positions[]=new Point[]{vertices[0].add(location),vertices[1].add(location),vertices[2].add(location)};
        int Xs[]=new int[]{(int)positions[0].getX(),(int)positions[1].getX(),(int)positions[2].getX()};
        int Ys[]=new int[]{(int)positions[0].getY(),(int)positions[1].getY(),(int)positions[2].getY()};
        G.fillPolygon(Xs,Ys,Xs.length);

        G.setStroke(new BasicStroke((int) thickness));
        G.setColor(borderColor);
        G.drawPolygon(Xs,Ys,Xs.length);
    }

    public boolean isIn(Point p) {
        return false;
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
