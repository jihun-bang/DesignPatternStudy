package dra.com.mvvmpatternstudy.Model.RobotState;

import android.view.View;

import dra.com.mvvmpatternstudy.View.TestActivity;

public class RobotStatePlay implements RobotState{

    @Override
    public RobotState rPlay() {
        System.out.println("동일 상태");
        return this;
    }

    @Override
    public RobotState rPause() {
        System.out.println("일시 정지");
        TestActivity.btnRobotPause.setVisibility(View.INVISIBLE);
        TestActivity.btnRobotPlay.setVisibility(View.VISIBLE);
        return new RobotStatePause();
    }

    @Override
    public RobotState rStop() {
        System.out.println("로봇 정지");
        TestActivity.btnRobotPlay.setVisibility(View.VISIBLE);
        TestActivity.btnRobotStop.setEnabled(false);
        return new RobotStateStop();
    }
}
