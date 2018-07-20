package dra.com.mvvmpatternstudy.Model;

import java.util.Observable;

public class SharedInstance extends Observable{         // TODO 서버를 옵저버로 / 완료

    private static SharedInstance instance;

    // TODO Observable로 만들어서. MVVM 적용 //완료
    private String serverState;

    public static SharedInstance getInstance() {
        if (instance == null) {
            instance = new SharedInstance();
        }
        return instance;
    }

    // 새로운 데이터를 전달 받아 갱신 및 알람
    // SharedInstance 에서는 주기적으로 이 함수를 사용해 최신 데이터를 전달
    public void setServerState(String serverState) {

        this.serverState = serverState;
        serverStateChanged();
    }

    // 갱신할 새로운 데이터 여부의 플래그 값을 변경하고(setChanged())
    // 옵저버들에게 새로운 데이터를 전달한다. (notifyObservers())
    private void serverStateChanged() {
        setChanged();
        notifyObservers();
    }

    // 서버 상태값 반환
    public String getServerState() {

        return instance.serverState;
    }
    // TODO 리스닝 함수 추가 // 완료
}
