package drawing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

enum Type
{
    Circle , Rectangle;
}


public abstract class Shape implements Drawable, Animatable {
    protected Point location;
    protected double InitArea;
    protected int InitThickness;
    protected Point InitLocation;

    protected Color solidColor=Color.WHITE, borderColor=Color.BLACK;
    protected int thickness=3;
    protected Color initSolidColor;
    protected Color initBorderColor;

    protected ArrayList<Animation> animations=new ArrayList<>();

    Type type;

    int ID;


    Shape(Point location) {
        this.location=location;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    Shape(Point location,Color solidColor,Color borderColor) {
        this.location=location;
        this.borderColor=borderColor;
        this.solidColor=solidColor;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Color getSolidColor() {
        return solidColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setSolidColor(Color color) {
        this.solidColor=color;
    }

    public void setBorderColor(Color color) {
        this.borderColor=color;
    }

    public abstract boolean isIn(Point p);

    public abstract double getArea();

    public abstract int getBorderSize();


    public void MoveLocation(Point Step){

    }


    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    public void increaseArea (double Step){

    }

    public void increaseBorderSize (int Step){

    }


    @Override
    public void step() {
        Iterator<Animation> cur=animations.iterator();
        while(cur.hasNext()) {
            cur.next().animate();
        }
    }


    public double getInitArea() {
        return InitArea;
    }

    public void setInitArea(double initArea) {
        InitArea = initArea;
    }

    public int getInitThickness() {
        return InitThickness;
    }

    public void setInitThickness(int initThickness) {
        InitThickness = initThickness;
    }

    public Point getInitLocation() {
        return InitLocation;
    }

    public void setInitLocation(Point initLocation) {
        InitLocation = initLocation;
    }

    public Color getInitSolidColor() {
        return initSolidColor;
    }

    public void setInitSolidColor(Color initSolidColor) {
        this.initSolidColor = initSolidColor;
    }

    public Color getInitBorderColor() {
        return initBorderColor;
    }

    public void setInitBorderColor(Color initBorderColor) {
        this.initBorderColor = initBorderColor;
    }
}
