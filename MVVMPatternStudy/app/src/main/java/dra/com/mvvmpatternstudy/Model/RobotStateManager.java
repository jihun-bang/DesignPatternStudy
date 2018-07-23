package dra.com.mvvmpatternstudy.Model;

import android.content.Context;

public class RobotStateManager {
    private RobotState robotState;

    public RobotStateManager(RobotState robotState) {
        this.robotState = robotState;
    }

    public void robotStatePlay() {
        this.robotState = robotState.robotStatePlay();
    }

    public void robotStatePause() {
        this.robotState = robotState.robotStatePause();
    }

    public void robotStateStop() {
        this.robotState = robotState.robotStateStop();
    }
}
