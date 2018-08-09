package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

public class IfCommandNode extends RootNode {

    private RootNode commandListNode;

    public void parse(InterpreterContext interpreterContext) throws NodeParseException {
        interpreterContext.skipToken("if");
        commandListNode = new CommandListNode();
        commandListNode.parse(interpreterContext);
    }

    public String toString() {
        return "[program" + commandListNode + "]";
    }
}
