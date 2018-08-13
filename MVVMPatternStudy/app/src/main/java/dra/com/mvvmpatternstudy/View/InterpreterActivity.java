package dra.com.mvvmpatternstudy.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import dra.com.mvvmpatternstudy.Model.Interpreter.Adpater.CommandListAdapter;
import dra.com.mvvmpatternstudy.Model.Interpreter.Adpater.CommandListItem;
import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.InterpreterViewModel;

public class InterpreterActivity extends AppCompatActivity implements Button.OnClickListener{

    private InterpreterViewModel interpreterViewModel ;

    private RecyclerView mRecyclerView;
    private CommandListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<CommandListItem> commandListItems;

    public static Button btnGo, btnLeft, btnRight, btnRepeat;
    public static EditText editInterpreterText, editRepeatCount;
    public static TextView textInterpreterResult;

    private String repeatCount;

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

        editInterpreterText = findViewById(R.id.editInterpreterText);
        editRepeatCount = findViewById(R.id.edit_repeatCnt);

        textInterpreterResult = findViewById(R.id.tx_InterpreterResult);

        mRecyclerView = findViewById(R.id.re_InterpreterResult);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        interpreterViewModel = new InterpreterViewModel(this);
    }

    // 1. 버튼 의 클릭 리스너가 이벤트 발생 체크
    @Override
    public void onClick(View view){
        // 2. ViewModel 에게 noti
        switch (view.getId()) {
            case R.id.btn_interpreter_go :
                interpreterViewModel.setCommandData("go");
                break;

            case R.id.btn_interpreter_left :
                interpreterViewModel.setCommandData("left");
                break;

            case R.id.btn_interpreter_right :
                interpreterViewModel.setCommandData("right");
                break;

            case R.id.btn_interpreter_repeat :
                repeatCount = editRepeatCount.getText().toString();
                interpreterViewModel.setLogicCommandData("repeat", repeatCount);
                break;
        }
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public InterpreterViewModel getInterpreterViewModel() {
        return interpreterViewModel;
    }
}
