package dra.com.mvvmpatternstudy.Model;

public class RobotStateStop implements RobotState{
    @Override
    public RobotState robotStatePlay() {
        return new RobotStatePlay();
    }

    @Override
    public RobotState robotStatePause() {
        return new RobotStatePause();
    }

    @Override
    public RobotState robotStateStop() {
        return this;
    }
}
