package drawing;

import java.awt.*;

public class Line extends Shape implements Drawable {
    Point end;

    public Line(Point start, Point end) {
        this(start,end, Color.RED,Color.BLACK);
    }

    public Line(Point start,Point end,Color solidColor, Color borderColor) {
        super(start,solidColor,borderColor);
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double getArea() {
        return 0;
    }

    @Override
    public void render(Graphics2D G) {
        ((Graphics2D)G).setStroke(new BasicStroke((int) thickness));
        G.setColor(this.solidColor);
        G.drawLine((int)location.getX(),(int)location.getY(),(int)end.getX(),(int)end.getY());
    }

    public boolean isIn(Point p) {
        return false;
    }


    @Override
    public int getBorderSize() {
        return thickness;
    }
}
