package drawing;

import java.awt.*;
import java.util.Random;


public class AnimationColor extends Animation {
    Shape shape;
    AnimationColor(int StepDelay , Shape shape){
        super(StepDelay);
        this.shape = shape;
    }

    @Override
    public void step (){
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        Color randomColor = new Color(r, g, b);
        shape.setSolidColor(randomColor );
    }
}
