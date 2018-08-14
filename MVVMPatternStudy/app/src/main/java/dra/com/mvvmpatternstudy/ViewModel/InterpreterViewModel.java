package dra.com.mvvmpatternstudy.ViewModel;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import dra.com.mvvmpatternstudy.Model.Interpreter.Adpater.CommandListAdapter;
import dra.com.mvvmpatternstudy.Model.Singleton.SharedInstance;
import dra.com.mvvmpatternstudy.View.InterpreterActivity;

public class InterpreterViewModel implements BaseViewModel {

    Context mContext;
    private CommandListAdapter mAdapter;
    public static ArrayList<String> commandListItems;

    String fullTxt = "";

    public InterpreterViewModel(Context context) {
        mContext = context;
        commandListItems = new ArrayList<>();

        commandListItems.add(("program"));
        commandListItems.add(("end"));

        refreshView();
    }

    @Override
    public void onCreate() {

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

    public void setCommandData(String command) {
        // CommandList 아이템 추가
        commandListItems.add(SharedInstance.getInstance().getTaskPostion(), command);

        // CommandListItems 포지션 1 증가
        SharedInstance.getInstance().setTaskPostion(SharedInstance.getInstance().getTaskPostion() + 1);

        // 어댑터에 추가 후 InterpreterActivity 의 RecyclerView 갱신
        refreshView();

        setInterpreter();
    }

    public void setLogicCommandData(String command, String repeatCount) {
        // CommandList 아이템 추가
        commandListItems.add(SharedInstance.getInstance().getTaskPostion(), command);
        commandListItems.add(SharedInstance.getInstance().getTaskPostion() + 1, repeatCount);
        commandListItems.add(SharedInstance.getInstance().getTaskPostion() + 2, "end");

        // CommandListItems 포지션 1 증가
        SharedInstance.getInstance().setTaskPostion(SharedInstance.getInstance().getTaskPostion() + 1);

        // 어댑터에 추가 후 InterpreterActivity 의 RecyclerView 갱신
        refreshView();

        setInterpreter();
    }

    //TODO 테스트케이스 기반으로
    public void setInterpreter() {
        fullTxt = "";

        for( int i = 0; i < commandListItems.size(); i++ ) {
            fullTxt = fullTxt + " " + commandListItems.get(i);

            //InterpreterActivity.editInterpreterText.setText(fullTxt);
        }

        Log.i("setInterpreter : ", fullTxt);

        //parseInterpreter(fullTxt);

//        // 커서의 현재 위치
//        int pos = InterpreterActivity.editInterpreterText.getSelectionStart();
//
//        // 현재 텍스트
//        String fullTxt = InterpreterActivity.editInterpreterText.getText().toString();
//
//        // 에디트에 텍스트가 하나도 없는 경우
//        if (fullTxt.isEmpty()) {
//            InterpreterActivity.editInterpreterText.setText("program " + command + " end");
//            InterpreterActivity.editInterpreterText.setSelection(8);
//        }
//        else {
//            // 에디트에 텍스트가 이미 있는 경우 - 커서 위치에 삽입
//            InterpreterActivity.editInterpreterText.setText(fullTxt.substring(0,pos) + command + fullTxt.substring(pos));
//            // 편집이 편하도록 커서를 삽입한 텍스트 끝에 위치시킨다.
//
//            if(command.indexOf("end") > -1) {
//                InterpreterActivity.editInterpreterText.setSelection(pos + command.length() - 4);
//            }
//            else {
//                InterpreterActivity.editInterpreterText.setSelection(pos + command.length());
//            }
//        }
    }


    // RecyclerView 갱신
    public void refreshView() {
        setInterpreter();
        //parseInterpreter(fullTxt);
        ((InterpreterActivity) mContext).getRecyclerView().setLayoutManager(((InterpreterActivity) mContext).getLayoutManager());
        mAdapter = new CommandListAdapter(commandListItems);
        ((InterpreterActivity) mContext).getRecyclerView().setAdapter(mAdapter);
    }


//    public void setCommandListItem(int index, int indentationLevel) {
//        commandListItems.get(index).getIndentationLevel() = indentationLevel;
//    }
}
