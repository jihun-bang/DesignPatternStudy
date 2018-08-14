package dra.com.mvvmpatternstudy.Model.Interpreter.Adpater;

import java.util.ArrayList;

public class CommandInstance {

    private ArrayList<CommandListItem> commandListItems;

    private CommandInstance() {
        commandListItems = new ArrayList<>();
    }

    private static class CommandInstanceHolder {
        private static final CommandInstance instance = new CommandInstance();
    }
    public static CommandInstance getInstance() {
        return CommandInstanceHolder.instance;
    }

    public void add(String command, int IndentationLevel) {
        commandListItems.add(new CommandListItem(command, IndentationLevel));
        //Log.i("add : ", "add");
    }

    public void add(String command) {
        commandListItems.add(new CommandListItem(command));
        //Log.i("add : ", "add");
    }

    public String getCommandListItemCommand(int index) {
        return commandListItems.get(index).getCommand();
    }

    public int getCommandListItemIndentation(int index) {
        return commandListItems.get(index).getIndentationLevel();
    }
}
