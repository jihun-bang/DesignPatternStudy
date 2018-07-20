package dra.com.mvvmpatternstudy.ViewModel;

import android.databinding.ObservableField;

import dra.com.mvvmpatternstudy.Model.SharedInstance;

public class MainViewModel implements BaseViewModel {

    private SharedInstance model;

    //옵저버블 추가
    //serverState 는 텍스트 뷰 변수, serverStateBtn : 버튼 변수
    public final ObservableField<String> serverState = new ObservableField<>();
    public final ObservableField<String> serverStateBtn = new ObservableField<>();

    public MainViewModel() {
        model = new SharedInstance();
    }

    @Override
    public void onCreate() {
        serverStateBtn.set("Servo On");
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
    // View UI 갱신
    public void setServerState() {

        if( serverStateBtn.get() == "Server OFF") {
            serverStateBtn.set("Server On");
            serverState.set("Ready");
        }
        else
        {
            serverStateBtn.set("Server OFF");
            serverState.set("Servo On");
        }
    }
}
