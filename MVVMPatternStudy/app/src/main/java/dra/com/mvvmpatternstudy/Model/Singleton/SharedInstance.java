package dra.com.mvvmpatternstudy.Model.Singleton;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

import dra.com.mvvmpatternstudy.ViewModel.ServerObservable;

public class SharedInstance implements Observer{         // TODO 서버를 옵저버로 / 완료
    // TODO Observable로 만들어서. MVVM 적용 //완료

    private String serverState;
    private int taskPostion = 1;

    // Singleton
    private SharedInstance() {}

    private static class SharedInstanceHolder {
        private static final SharedInstance instance = new SharedInstance();
    }
    public static SharedInstance getInstance() {
        return SharedInstanceHolder.instance;
    }

    // update 에서 받은 string 값으로 set
    private void serverStateChange(String serverState) {
        SharedInstanceHolder.instance.serverState = serverState;
    }

    // Observables
    public static ServerObservable serverObservable = new ServerObservable();

    public void addObserver(Observer observer) {
        serverObservable.addObserver(observer);
    }

    // 서버 상태값 반환
    public String getServerState() {

        return SharedInstanceHolder.instance.serverState;
    }

    // 4. ViewModel 에서 등록한 옵저버블에서 알람 받음
    @Override
    public void update(Observable o, Object arg) {

        // 알람 받은 옵저버블이 무엇인지 체크
        if( o instanceof ServerObservable) {
            this.serverStateChange("Server On");
            Log.i("SharedInstance", o + " 에서 String : " + arg + "감지");
        }
    }

    // 현재 선택한 CommandListItem Postion + 1
    public void setTaskPostion(int taskPostion) {
        this.taskPostion = taskPostion;
    }

    public int getTaskPostion() {
        return taskPostion;
    }

}
