package com.wmk.testcase.demo3;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

//junit4 搭载 easycore数据驱动
@RunWith(DataDrivenTestRunner.class)
public class CsvTest
{
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    @DataLoader(filePaths = "test.csv", loaderType = LoaderType.CSV)
    public String functionName(@Param(name = "a") Integer a,
                                 @Param(name = "b") Integer b) {
        Assert.assertEquals(a, b);
        return "success";
    }
    @Test
    @DataLoader(filePaths = "test.csv")
    public void testNew(@Param(name = "a") Integer a, @Param(name = "b")Integer b){
        Assert.assertEquals(b, a);
    }
}
