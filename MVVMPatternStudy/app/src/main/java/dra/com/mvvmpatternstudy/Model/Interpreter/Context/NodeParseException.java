package dra.com.mvvmpatternstudy.Model.Interpreter.Context;

// 예외처리 클래스
public class NodeParseException extends Exception {
    public NodeParseException(String msg) {
        super(msg);
    }
}
