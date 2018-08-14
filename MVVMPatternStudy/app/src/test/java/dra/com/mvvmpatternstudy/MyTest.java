package dra.com.mvvmpatternstudy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dra.com.mvvmpatternstudy.Model.Interpreter.Adpater.CommandInstance;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.ProgramNode;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.RootNode;

@RunWith(JUnit4.class)
public class MyTest {

    @Test
    public void test() throws NodeParseException {
        RootNode rootNode = new ProgramNode();
        //SharedInstance.getInstance().setServerState("a");

        String program = "program go left repeat 2 right end end";

        InterpreterContext interpreterContext = new InterpreterContext(program);
        rootNode.parse(interpreterContext);

        System.out.println(rootNode);

        for(int i = 0; i < 8; i++) {
            System.out.println(CommandInstance.getInstance().getCommandListItemIndentation(i) + " " + CommandInstance.getInstance().getCommandListItemCommand(i));
        }
        Assert.assertTrue(interpreterContext.currentIndentation() == 1);

        //SharedInstance s1 = new SharedInstance.getInstance();
        //SharedInstance s2 = new SharedInstance.getInstance();

        //System.out.println(s2);
//        System.out.println(s1);

        //싱글톤 적용 완료

  //      SharedInstance s1 = new SharedInstance.getInstance();
    }
}