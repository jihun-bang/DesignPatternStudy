package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <program> ::= program <command list> 중 <program>
- CommandListNode 에 대응하는 노드를 보관

- parse() : InterpreterContext 객체에게 'program' 토큰 체크
- <command list> 에 대응하는 인스턴스 생성 후 parse() 호출
 */

public class ProgramNode extends RootNode {

    private RootNode commandListNode;

    public void parse(InterpreterContext interpreterContext) throws NodeParseException {
        interpreterContext.skipToken("program");
        commandListNode = new CommandListNode(0, 0);
        commandListNode.parse(interpreterContext);
    }

    public void setCommandListItem() {}

    public String toString() {
        return "[program " + commandListNode + " ] ";
    }
}
