package dra.com.mvvmpatternstudy.Model.Adpater;

public class CommandListItem {
    private String command;
    private int repeatCount;

    public CommandListItem(String command) {
        this.command = command;
    }

    public CommandListItem(String command, int repeatCount) {
        this.command = command;
        this.repeatCount = repeatCount;
    }

    public String getCommand() {
        return this.command;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }
}