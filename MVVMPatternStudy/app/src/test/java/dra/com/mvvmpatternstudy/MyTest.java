package dra.com.mvvmpatternstudy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dra.com.mvvmpatternstudy.Model.Singleton.SharedInstance;

@RunWith(JUnit4.class)
public class MyTest {

    @Test
    public void test()
    {
        //SharedInstance.getInstance().setServerState("a");

        Assert.assertTrue(SharedInstance.getInstance().getServerState() == "a");

        //SharedInstance s1 = new SharedInstance.getInstance();
        //SharedInstance s2 = new SharedInstance.getInstance();

        //System.out.println(s2);
//        System.out.println(s1);

        //싱글톤 적용 완료

  //      SharedInstance s1 = new SharedInstance.getInstance();
    }
}