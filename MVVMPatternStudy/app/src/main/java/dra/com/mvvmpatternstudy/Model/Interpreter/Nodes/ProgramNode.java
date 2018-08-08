package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.Context;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <program> ::= program <command list> 중 <program>
- CommandListNode 에 대응하는 노드를 보관

- parse() : Context 객체에게 'program' 토큰 체크
- <command list> 에 대응하는 인스턴스 생성 후 parse() 호출
 */

public class ProgramNode extends RootNode {

    private RootNode commandListNode;

    public void parse(Context context) throws NodeParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    public String toString() {
        return "[program" + commandListNode + "]";
    }
}
