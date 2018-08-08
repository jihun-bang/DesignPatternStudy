package dra.com.mvvmpatternstudy.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.InterpreterViewModel;

public class InterpreterActivity extends AppCompatActivity implements Button.OnClickListener{

    InterpreterViewModel interpreterViewModel = new InterpreterViewModel();
    public static Button btnGo, btnLeft, btnRight, btnRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpreter);

        btnGo = findViewById(R.id.btn_interpreter_go);
        btnGo.setOnClickListener(this);
        btnLeft = findViewById(R.id.btn_interpreter_left);
        btnLeft.setOnClickListener(this);
        btnRight = findViewById(R.id.btn_interpreter_right);
        btnRight.setOnClickListener(this);
        btnRepeat = findViewById(R.id.btn_interpreter_repeat);
        btnRepeat.setOnClickListener(this);
    }

    // 1. 버튼 의 클릭 리스너가 이벤트 발생 체크
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_interpreter_go :
                interpreterViewModel.setInterpreter("go");
                break;

            case R.id.btn_interpreter_left :
                interpreterViewModel.setInterpreter("left");
                break;

            case R.id.btn_interpreter_right :
                // 2. ViewModel 에게 noti
                interpreterViewModel.setInterpreter("right");
                break;
            case R.id.btn_interpreter_repeat :
                // 2. ViewModel 에게 noti
                interpreterViewModel.setInterpreter("repeat");
                break;
        }
    }
}
