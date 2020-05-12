package com.wmk.testcase.demo1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1
{
    Logger log = LoggerFactory.getLogger(Test1.class);

    @Test
    public void test1(){
        log.info("test1 运行");
        Assert.assertNull("");
    }

    @Test
    public void test2(){
        Assert.assertNull(null);
    }

    @Test
    public void test3(){
        Assert.assertNull(0);
    }
}
