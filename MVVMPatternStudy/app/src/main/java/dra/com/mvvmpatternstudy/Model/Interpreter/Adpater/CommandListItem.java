package dra.com.mvvmpatternstudy.Model.Interpreter.Adpater;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;

public class CommandListItem {
    private String command;

    public CommandListItem(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    // Singleton
    private CommandListItem() {}

    private static class InterpreterContextInstanceHolder {
        private static final InterpreterContext instance = new InterpreterContext();
    }
    public static InterpreterContext getInstance() {
        return InterpreterContextInstanceHolder.instance;
    }

//    public void setIndentationLevel(int indentationLevel) {
//        this.indentationLevel = indentationLevel;
//    }
//
//    public int getIndentationLevel() {
//        return this.indentationLevel;
//    }
}