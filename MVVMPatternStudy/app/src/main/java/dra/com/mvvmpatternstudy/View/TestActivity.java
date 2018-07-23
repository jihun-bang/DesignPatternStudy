package dra.com.mvvmpatternstudy.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.MainViewModel;

public class TestActivity extends AppCompatActivity {
    MainViewModel mainViewModel = new MainViewModel();
    public static Button btnTest;
    public static EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnTest = findViewById(R.id.btnTest);
        editText = findViewById(R.id.editText);

        // 1. btnTest 의 클릭 리스너가 이벤트 발생 체크
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. ViewModel 에게 noti
                mainViewModel.setServerState();
            }
        });
    }
}
