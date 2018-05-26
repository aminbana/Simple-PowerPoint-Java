package drawing;

public class AnimationSize extends Animation {
    Shape shape;
    boolean increasingSize = true;
    double increaseStep = 2;
    int increaseFactor = 1;
    AnimationSize(int StepDelay ,int increaseFactor , double increaseStep , Shape shape){
        super(StepDelay);
        this.shape = shape;
        this.increaseStep = increaseStep;
        this.increaseFactor = increaseFactor;
    }

    @Override
    public void step (){
        if (increasingSize == true){
            shape.increaseArea(increaseStep);
            if (shape.getArea() > shape.getInitArea() * increaseFactor){
                increasingSize = false;
            }

        }
        else{
            shape.increaseArea(-increaseStep);
            if (shape.getArea() < shape.getInitArea()){
                increasingSize = true;
            }
        }

    }
}