package dra.com.mvvmpatternstudy.ViewModel;


import dra.com.mvvmpatternstudy.Model.RobotState.RobotState;
import dra.com.mvvmpatternstudy.Model.RobotState.RobotStateManager;
import dra.com.mvvmpatternstudy.Model.SharedInstance;
import dra.com.mvvmpatternstudy.View.TestActivity;

public class MainViewModel implements BaseViewModel {

    public MainViewModel() {
        //옵저버 추가
        SharedInstance.getInstance().addObserver(SharedInstance.getInstance());
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    // 이벤트 리스너 함수
    // 새로운 데이터를 전달 받아 갱신 및 알람
    // View UI 갱신 (TestActivity)
    public void setServerState() {

        // 3. TestActivity(View) 에게서 데이터를 전달 받음
        SharedInstance.getInstance().serverObservable.action("변경 감지");

        // 5. SharedInstance 의 변경값을 TestActivity(View) 에게 View 갱신
        TestActivity.editText.setText(SharedInstance.getInstance().getServerState());
    }

    public void setRobotState(String command) {


        // 3. TestActivity(View) 에게서 데이터를 전달 받고 RobotStateManager 에 데이터 전달
        TestActivity.robotStateManager.setRobotState(command);

        // 5. RobotStateManager 의 변경값을 TestActivity(View) 에게 View 갱신
        TestActivity.editText.setText(RobotStateManager.getInstance().getRobotState());
    }
}
