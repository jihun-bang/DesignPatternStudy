package dra.com.mvvmpatternstudy.Model.Interpreter.Context;

import java.util.StringTokenizer;

/*
구문 해석을 위해 필요한 메소드 제공 (Model)

- 필요할 때마다 토큰으로 잘라서(lexical analysis) 그 토큰을 반환

- StringTokenizer : 주어진 문자열을 토큰으로 분할해 주는 클래스
  구분 문자 : 스페이스(' ') / 탭('\t'), 뉴라인('\n'), 캐리지 리턴('\r'), 폼피드('\f')
 */

public class Context{
    private StringTokenizer tokenizer; // 토큰 분할
    private String currentToken; // 현재 토큰

    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    // 다음 토큰
    public String nextToken() {
        // hasMoereTokens : 다음 토큰이 있는지 없는지 조사
        if ( tokenizer.hasMoreTokens() ) {
            currentToken = tokenizer.nextToken();
        }
        else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    // 현재 토큰을 체크 후 다음 토큰
    public void skipToken(String token) throws NodeParseException {
        if (!token.equals(currentToken)) {
            throw new NodeParseException("Warning : " + token + "is expected But \n Current Token : " + currentToken );
        }
        nextToken();
    }

    // 현재 토큰을 정수 수치로
    public int currentNumber() throws NodeParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new NodeParseException(("Waring : " + e));
        }
        return number;
    }
}
