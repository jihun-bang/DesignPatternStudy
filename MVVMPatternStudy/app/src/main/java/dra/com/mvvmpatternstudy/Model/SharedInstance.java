package dra.com.mvvmpatternstudy.Model;

import java.util.Observable;

public class SharedInstance{         // TODO 서버를 옵저버로 / 완료

    private static SharedInstance instance;

    // TODO Observable로 만들어서. MVVM 적용 //완료
    private String serverState;

    public static SharedInstance getInstance() {
        if (instance == null) {
            instance = new SharedInstance();
        }
        return instance;
    }

    // 서버 상태값 반환
    public String getServerState() {

        return instance.serverState;
    }
    // TODO 리스닝 함수 추가 // 완료
}
