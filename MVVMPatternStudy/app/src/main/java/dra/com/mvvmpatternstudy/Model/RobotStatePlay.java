package dra.com.mvvmpatternstudy.Model;

public class RobotStatePlay implements RobotState{
    @Override
    public RobotState robotStatePlay() {
        return this;
    }

    @Override
    public RobotState robotStatePause() {
        return new RobotStatePause();
    }

    @Override
    public RobotState robotStateStop() {
        return new RobotStateStop();
    }
}
