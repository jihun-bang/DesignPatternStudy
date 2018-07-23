package dra.com.mvvmpatternstudy.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dra.com.mvvmpatternstudy.Model.SharedInstance;
import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.MainViewModel;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final Button btnTest = (Button) findViewById(R.id.btnTest);

        // btnTest 의 클릭 리스너가 옵저버
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO sned noti to observer
                MainViewModel mainViewModel = new MainViewModel();
                mainViewModel.setServerState(btnTest.toString());
                //SharedInstance.getInstance().serverObservable.action(btnTest.toString());
            }
        });
    }
}
