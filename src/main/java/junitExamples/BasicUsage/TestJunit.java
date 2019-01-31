package junitExamples.BasicUsage;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestJunit {
    private String message = "New world";
    private MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        message = "Hello World";
        assertEquals(message, messageUtil.returnMessage());
    }


}
