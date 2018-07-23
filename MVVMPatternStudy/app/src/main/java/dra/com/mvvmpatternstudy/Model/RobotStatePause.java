package dra.com.mvvmpatternstudy.Model;

public class RobotStatePause implements RobotState{
    @Override
    public RobotState robotStatePlay() {
        return new RobotStatePlay();
    }

    @Override
    public RobotState robotStatePause() {
        return this;
    }

    @Override
    public RobotState robotStateStop() {
        return new RobotStateStop();
    }
}
