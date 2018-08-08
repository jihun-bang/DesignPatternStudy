package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.Context;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

public class IfCommandNode extends RootNode {

    private RootNode commandListNode;

    public void parse(Context context) throws NodeParseException {
        context.skipToken("if");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    public String toString() {
        return "[program" + commandListNode + "]";
    }
}
