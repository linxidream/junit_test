package com.wmk.testcase.demo1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2 {
    Logger log = LoggerFactory.getLogger(Test2.class);

    @Test
    public void testDemo1() {
        Assert.assertEquals("should be equals.", "a", "b");
    }

    @Test
    public void testDemo2() {
        Assert.assertEquals("should be equals.", 1, 1);
    }

    @Test
    public void testDemo3() {
        Assert.assertEquals("should be equals.", "a", "a");
    }
}
