package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <repeat command> ::= repeat <number> <command list> 중 <repeat command>
- parse() : 재귀성. PrimitiveCommand 의 parse() 호출 전까지 재귀.
 */

public class RepeatCommandNode extends RootNode {

    private RootNode commandListNode;
    private int number;

    // 재귀
    public void parse(InterpreterContext interpreterContext) throws NodeParseException {
        interpreterContext.skipToken("repeat");
        number = interpreterContext.currentNumber();
        interpreterContext.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(interpreterContext);
    }

    public String toString() {
        return " [ repeat " + number + commandListNode + " ] ";
    }
}
