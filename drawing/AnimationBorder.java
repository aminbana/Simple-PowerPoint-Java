package drawing;

public class AnimationBorder extends Animation {

    Shape shape;
    int increaseStep;
    int increaseFactor;
    boolean increasingBorderSize;
    AnimationBorder(int StepDelay , int increaseStep , int increaseFactor , Shape shape){
        super(StepDelay);
        this.shape = shape;
        this.increaseFactor = increaseFactor;
        this.increaseStep = increaseStep;
        increasingBorderSize = true;
    }

    @Override
    public void step() {
        if (increasingBorderSize){
            shape.increaseBorderSize(increaseStep);

            if (shape.getBorderSize() > shape.getInitThickness() * increaseFactor){
                increasingBorderSize = false;
            }

        }
        else{
            shape.increaseBorderSize(-increaseStep);
            double BorderSize = shape.getBorderSize();
            if (shape.getBorderSize() < shape.getInitThickness()){
                increasingBorderSize = true;
            }
        }
    }
}
