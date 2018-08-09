package dra.com.mvvmpatternstudy.ViewModel;

import android.content.Context;

import java.util.ArrayList;

import dra.com.mvvmpatternstudy.Model.Adpater.CommandListAdapter;
import dra.com.mvvmpatternstudy.Model.Adpater.CommandListItem;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.ProgramNode;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.RootNode;
import dra.com.mvvmpatternstudy.Model.Singleton.SharedInstance;
import dra.com.mvvmpatternstudy.View.InterpreterActivity;

public class InterpreterViewModel implements BaseViewModel {

    RootNode rootNode = new ProgramNode();

    Context mContext;
    private CommandListAdapter mAdapter;
    private ArrayList<CommandListItem> commandListItems;

    public InterpreterViewModel(Context context) {
        mContext = context;
        commandListItems = new ArrayList<>();

        commandListItems.add(new CommandListItem("program"));
        commandListItems.add(new CommandListItem("end"));

        ((InterpreterActivity) mContext).getRecyclerView().setLayoutManager(((InterpreterActivity) mContext).getLayoutManager());
        // 어댑터에 추가 후 InterpreterActivity 의 RecyclerView 갱신
        mAdapter = new CommandListAdapter(commandListItems);
        ((InterpreterActivity) mContext).getRecyclerView().setAdapter(mAdapter);
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

    public void parseInterpreter() {

        // 현재 텍스트
        String fullTxt = InterpreterActivity.editInterpreterText.getText().toString();

        // 3. TestActivity(View) 에게서 데이터를 전달 받고 Interpreter - node 에 데이터 전달
        try {
            rootNode.parse(new InterpreterContext(fullTxt));
        } catch (NodeParseException e) {
            e.printStackTrace();
        }

        // 5. rootNode 의 변경값을 TestActivity(View) 에게 View 갱신
        InterpreterActivity.textInterpreterResult.setText(rootNode.toString());

    }

    public void setCommandData(String command) {
        // CommandList 아이템 추가
        commandListItems.add(SharedInstance.getInstance().getTaskPostion(), new CommandListItem(command));
        // CommandListItems 포지션 1 증가
        SharedInstance.getInstance().setTaskPostion(SharedInstance.getInstance().getTaskPostion() + 1);

        // 어댑터에 추가 후 InterpreterActivity 의 RecyclerView 갱신
        ((InterpreterActivity) mContext).getRecyclerView().setLayoutManager(((InterpreterActivity) mContext).getLayoutManager());
        mAdapter = new CommandListAdapter(commandListItems);
        ((InterpreterActivity) mContext).getRecyclerView().setAdapter(mAdapter);

        setInterpreter();
    }

    public void setLogicCommandData(String command, int repeatCount) {
        // CommandList 아이템 추가
        commandListItems.add(SharedInstance.getInstance().getTaskPostion(), new CommandListItem(command, repeatCount));
        // CommandListItems 포지션 1 증가
        commandListItems.add(SharedInstance.getInstance().getTaskPostion()+1, new CommandListItem("end"));
        SharedInstance.getInstance().setTaskPostion(SharedInstance.getInstance().getTaskPostion() + 1);

        // 어댑터에 추가 후 InterpreterActivity 의 RecyclerView 갱신
        ((InterpreterActivity) mContext).getRecyclerView().setLayoutManager(((InterpreterActivity) mContext).getLayoutManager());
        mAdapter = new CommandListAdapter(commandListItems);
        ((InterpreterActivity) mContext).getRecyclerView().setAdapter(mAdapter);

        setInterpreter();
    }

    //TODO 테스트케이스 기반으로
    public void setInterpreter() {

        String fullTxt = "";
        int commandListItemsLength = commandListItems.size();
        for( int i = 0; i < commandListItemsLength; i++ ) {
            fullTxt = fullTxt + " " + commandListItems.get(i).getCommand();
            // 추가할 포지션의 커맨드가 repeat 일 경우 그 다음 count 추가
            if(commandListItems.get(i).getCommand().equals("repeat")) {
                fullTxt = fullTxt + " " + commandListItems.get(i).getRepeatCount();
            }
            InterpreterActivity.editInterpreterText.setText(fullTxt);
        }

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
        parseInterpreter();
    }
}
