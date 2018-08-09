package dra.com.mvvmpatternstudy.Model.Interpreter.Nodes;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;

/*
구문 트리의 노드를 구성하는 루트 노드
- parse(InterpreterContext) : 구문 해석 이라는 처리를 실행하기 위한 메소드
- InterpreterContext : 현재 구문 해석을 실행하고 있는 '상황' 을 나타내는 클래스 (Model 로직)
- 에러 발생시 throw NodeParseException
*/

public abstract class RootNode {
    public abstract void parse(InterpreterContext interpreterContext) throws NodeParseException;
}
