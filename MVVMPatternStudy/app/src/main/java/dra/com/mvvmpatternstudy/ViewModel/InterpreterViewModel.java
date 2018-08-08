package dra.com.mvvmpatternstudy.ViewModel;

import android.util.Log;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.Context;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.ProgramNode;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.RootNode;
import dra.com.mvvmpatternstudy.View.TestActivity;

public class InterpreterViewModel implements BaseViewModel {

    RootNode rootNode = new ProgramNode();

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

    public void setInterpreter(String command) {

        // 3. TestActivity(View) 에게서 데이터를 전달 받고 Interpreter - node 에 데이터 전달
        try {
            Log.i("setInterpreter", "RootNode Load");
            rootNode.parse(new Context(command));
        } catch (NodeParseException e) {
            e.printStackTrace();
        }

        // 5. rootNode 의 변경값을 TestActivity(View) 에게 View 갱신
        TestActivity.editText.setText(rootNode.toString());
        System.out.println("node = " + rootNode);
    }
}
