package dra.com.mvvmpatternstudy.Model.RobotState;

import android.view.View;

import dra.com.mvvmpatternstudy.View.TestActivity;

public class RobotStatePause implements RobotState{
    @Override
    public RobotState rPlay() {
        System.out.println("로봇 시작");
        TestActivity.btnRobotPause.setVisibility(View.VISIBLE);
        TestActivity.btnRobotPlay.setVisibility(View.INVISIBLE);
        TestActivity.btnRobotStop.setEnabled(true);
        return new RobotStatePlay();
    }

    @Override
    public RobotState rPause() {
        System.out.println("동일 상태");
        return this;
    }

    @Override
    public RobotState rStop() {
        System.out.println("로봇 정지");
        TestActivity.btnRobotStop.setEnabled(false);
        return new RobotStateStop();
    }
}
