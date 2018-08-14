package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Adpater.CommandInstance;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <primitive command> ::= go | right | left 중 <primitive command>
- parse() : 다른 parse() 메소드 호출 않함
            현재 토큰을 얻고 다음토큰으로 이동
 */
public class PrimitiveCommandNode extends RootNode {

    private String name;
    private int indentation;

    public void parse(InterpreterContext interpreterContext) throws NodeParseException {

        name = interpreterContext.currentToken();
        setCommandListItem();
        interpreterContext.skipToken(name);

        // 기능 command 외 예외처리
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new NodeParseException(name + " is undefined");
        }
    }

    public void setCommandListItem() {
        CommandInstance.getInstance().add(name, indentation);
    }

    PrimitiveCommandNode(int indentation) {
        this.indentation = indentation;
    }

    public String toString() {
        return name;
    }
}
