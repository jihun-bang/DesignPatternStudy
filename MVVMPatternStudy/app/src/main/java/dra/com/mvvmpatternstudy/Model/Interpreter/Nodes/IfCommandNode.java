package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

public class IfCommandNode extends RootNode {

    private RootNode commandListNode;

    public void parse(InterpreterContext interpreterContext) throws NodeParseException {
        interpreterContext.skipToken("if");
        commandListNode = new CommandListNode(1);
        commandListNode.parse(interpreterContext);
    }

    public void setCommandListItem () {}

    public String toString() {
        return "[program" + commandListNode + "]";
    }
}
