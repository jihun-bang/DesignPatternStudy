package dra.com.mvvmpatternstudy;

import org.junit.Test;

import dra.com.mvvmpatternstudy.Model.SharedInstance;

import static org.junit.Assert.*;


public class MyTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test()
    {
        SharedInstance.getInstance().serverStateChange("안녕");
        SharedInstance.getInstance().getServerState();
    }
}