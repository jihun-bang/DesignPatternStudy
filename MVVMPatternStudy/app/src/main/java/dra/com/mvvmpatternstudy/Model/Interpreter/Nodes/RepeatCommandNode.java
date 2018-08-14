package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import java.util.ArrayList;

import dra.com.mvvmpatternstudy.Model.Interpreter.Adpater.CommandInstance;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <repeat command> ::= repeat <number> <command list> 중 <repeat command>
- parse() : 재귀성. PrimitiveCommand 의 parse() 호출 전까지 재귀.
 */

public class RepeatCommandNode extends RootNode {

    private RootNode commandListNode;

    private int number;
    private int indentation;

    // 재귀
    public void parse(InterpreterContext interpreterContext) throws NodeParseException {
        interpreterContext.skipToken("repeat");
        number = interpreterContext.currentNumber();
        setCommandListItem();
        interpreterContext.nextToken();

        commandListNode = new CommandListNode(indentation ++);
        commandListNode.parse(interpreterContext);

    }

    RepeatCommandNode (int indentation) {
        this.indentation = indentation;
    }

    public void setCommandListItem() {
        CommandInstance.getInstance().add("repeat", indentation);
        CommandInstance.getInstance().add( String.valueOf(number));
        indentation ++;
    }

    public String toString() {
        return " [ repeat " + number + commandListNode + " ] ";
    }

    public ArrayList toArray() {
        return
    }
}
