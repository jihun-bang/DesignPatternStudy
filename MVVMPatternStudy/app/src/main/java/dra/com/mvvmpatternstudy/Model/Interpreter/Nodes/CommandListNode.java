package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import java.util.Vector;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
- <command list> ::= <command>* end 중 <command list>
- Vector list : <command> 에 대응하는 CommandNode 인스턴스 보관
- parse() : 남은 토큰 없다면 null => 'end'가 빠졌으면 예외처리
            현재 토큰 end => 'end' 뒤로 이동 후 while 루트 break
            현재 토큰 !end => '<command>' 를 의미. CommandNode 인스턴스 생성 -> parse() 호출 -> list 에 보관
 */

public class CommandListNode extends RootNode {

    private Vector list = new Vector();
    private int indentation;
    private int index;

    public void parse(InterpreterContext interpreterContext) throws NodeParseException {
        while (true) {
            if (interpreterContext.currentToken() == null) {

                throw new NodeParseException("Missing 'end'");
            }
            else if (interpreterContext.currentToken().equals("end")) {
                interpreterContext.skipToken("end");
                break;
            }
            else {
                RootNode commandNode = new CommandNode(index++, indentation);
                commandNode.parse(interpreterContext);
                list.add(commandNode);

            }
        }
    }

    public void setCommandListItem() {}

    CommandListNode (int index, int indentation) {
        this.index = index;
        this.indentation = indentation;
    }

    public String toString() {
        return " " + list + " ";
    }
}
