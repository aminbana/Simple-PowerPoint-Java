package drawing;

public class AnimationMove extends Animation {
    Shape shape;
    boolean GoingOrComing = true;
    Point MoveStep;
    double MoveLimits = 1;
    AnimationMove(int StepDelay ,double MoveLimits , Point MoveStep , Shape shape){
        super(StepDelay);
        this.shape = shape;
        this.MoveStep = MoveStep;
        this.MoveLimits = MoveLimits;
    }

    @Override
    public void step (){
        if (GoingOrComing == true){
            shape.MoveLocation(MoveStep);

            if (((shape.getLocation().subtract(shape.getInitLocation())).abs()) > MoveLimits){
                GoingOrComing = false;
            }

        }
        else{
            shape.MoveLocation(new Point(0 , 0).subtract(MoveStep));
            if (shape.getLocation().subtract(shape.getInitLocation()).abs() < MoveStep.abs()){
                GoingOrComing = true;
            }
            }

        }

    public void setMoveStep(Point moveStep) {
        MoveStep = moveStep;
    }

    public Point getMoveStep() {
        return MoveStep;
    }
}