package dra.com.mvvmpatternstudy.Model.RobotState;

import android.view.View;

import dra.com.mvvmpatternstudy.View.TestActivity;

public class RobotStateStop implements RobotState{
    @Override
    public RobotState rPlay() {
        System.out.println("로봇 시작");
        TestActivity.btnRobotPlay.setVisibility(View.INVISIBLE);
        TestActivity.btnRobotPause.setVisibility(View.VISIBLE);
        TestActivity.btnRobotStop.setEnabled(true);
        return new RobotStatePlay();
    }

    @Override
    public RobotState rPause() {
        System.out.println("이미 정지된 상태");
        TestActivity.btnRobotPause.setVisibility(View.VISIBLE);
        return this;
    }

    @Override
    public RobotState rStop() {
        System.out.println("동일 상태");
        TestActivity.btnRobotStop.setEnabled(false);
        return this;
    }
}
