package dra.com.mvvmpatternstudy.Model;

public interface RobotState {
    public RobotState robotStatePlay();
    public RobotState robotStatePause();
    public RobotState robotStateStop();
}
