package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.Context;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <primitive command> ::= go | right | left 중 <primitive command>
- parse() : 다른 parse() 메소드 호출 않함
            현재 토큰을 얻고 다음토큰으로 이동
 */
public class PrimitiveCommandNode extends RootNode {

    private String name;

    public void parse(Context context) throws NodeParseException {

        name = context.currentToken();
        context.skipToken(name);

        // 기능 command 외 예외처리
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new NodeParseException(name + " is undefined");
        }
    }
    public String toString() {
        return name;
    }
}