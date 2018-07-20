package dra.com.mvvmpatternstudy.Model;

public class SharedInstance{         // TODO 서버를 옵저버로 / 완료

    private static SharedInstance instance;

    // TODO Observable로 만들어서. MVVM 적용 //완료
    private String serverState = "Ready", serverStateBtn = "Server On";

    public static SharedInstance getInstance() {
        if (instance == null) {
            instance = new SharedInstance();
        }
        System.out.println("SharedInstance load");
        return instance;
    }

    public void serverStateChange(String serverStateBtn) {
        if( serverStateBtn == "Server ON") {
            this.serverStateBtn = "Server OFF";
            this.serverState = "Servo On";
        }
        else
        {
            this.serverStateBtn = "Server ON";
            this.serverState = "Ready";
        }
    }

    // 서버 상태값 반환
    public String getServerState() {

        return instance.serverState;
    }

    public String getServerStateBtn() {

        return instance.serverStateBtn;
    }
    // TODO 리스닝 함수 추가 // 완료
}
