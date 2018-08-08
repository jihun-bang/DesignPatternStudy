package dra.com.mvvmpatternstudy.Model.RobotState;

public class RobotStateManager {
    private RobotState robotState;
    private String robotStateText;

    public RobotStateManager(RobotState robotState){
        RobotStateManagerHolder.instance.robotState = robotState;
    }

    // Singleton
    private RobotStateManager() {}
    private static class RobotStateManagerHolder {
        private static final RobotStateManager instance = new RobotStateManager();
    }
    public static RobotStateManager getInstance() {
        return RobotStateManagerHolder.instance;
    }

    public void rPlay() {
        this.robotState = robotState.rPlay();
        this.robotStateText = "Play";
    }

    public void rPause() {
        this.robotState = robotState.rPause();
        this.robotStateText = "Pause";
    }
    public void rStop() {
        this.robotState = robotState.rStop();
        this.robotStateText = "Stop";
    }

    // 4. ViewModel 에서 command 를 비교후에 메소드 수행.
    public void setRobotState(String command) {
        if(command == "play"){
            rPlay();
        }
        else if(command == "pause") {
            rPause();
        }
        else {
            rStop();
        }
    }

    public String getRobotState() {
        return this.robotStateText;
    }
}