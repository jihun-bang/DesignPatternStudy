package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.Context;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <command> ::= <repeat command> | <primitive command> 중 <command>
- RepeatCommand | PrimitiveCommand 인스턴스를 넣어둠
- parse() : 현재 토큰이 'repeat' => RepeatCommandNode 인스턴스 생성 -> parse() 호출
            현재 토큰이 '!repeat' => PrimitiveCommandNode 인스턴스 생서 -> parse() 호출
 */

public class CommandNode extends RootNode {

    private RootNode node;

    public void parse(Context context) throws NodeParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        } else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }
    public String toString() {
        return node.toString();
    }
}
