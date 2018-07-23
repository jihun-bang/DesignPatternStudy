package dra.com.mvvmpatternstudy.Model;

import java.util.Observable;
import java.util.Observer;

import dra.com.mvvmpatternstudy.ViewModel.ServerObservable;

public class SharedInstance implements Observer{         // TODO 서버를 옵저버로 / 완료
    // TODO Observable로 만들어서. MVVM 적용 //완료

    private String serverState;


    // Singleton
    private SharedInstance() {}
    private static class SharedInstanceHolder {
        private static final SharedInstance instance = new SharedInstance();
    }
    public static SharedInstance getInstance() {
        return SharedInstanceHolder.instance;
    }

    // Observables
    public static ServerObservable serverObservable = new ServerObservable();


    private void serverStateChange(String serverState) {
        SharedInstanceHolder.instance.serverState = serverState;
    }

    // 서버 상태값 반환
    public String getServerState() {

        return SharedInstanceHolder.instance.serverState;
    }

    // TODO 리스닝 함수 추가 // 완료

    public void update(Observable o, Object arg) {

        if( o instanceof ServerObservable) {
            this.serverStateChange("변경 감지");
        }
    }
}
