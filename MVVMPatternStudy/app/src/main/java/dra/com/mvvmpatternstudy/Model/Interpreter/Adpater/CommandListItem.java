package dra.com.mvvmpatternstudy.Model.Interpreter.Adpater;

public class CommandListItem {
    private String command;
    private int indentationLevel;

    public CommandListItem (String command) {
        this.command = command;
    }

    public CommandListItem (String command, int indentationLevel) {
        this.command = command;
        this.indentationLevel = indentationLevel;
    }

    public String getCommand() {
        return command;
    }

    public int getIndentationLevel() {
        return indentationLevel;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setIndentationLevel(int indentationLevel) {
        this.indentationLevel = indentationLevel;
    }
}