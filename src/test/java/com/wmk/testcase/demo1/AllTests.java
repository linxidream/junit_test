package com.wmk.testcase.demo1;

import com.wmk.testcase.TestReport;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AllTests {
    private TestSuite suite;
    private TestResult result;
    private static String fileName = null;
    private static String package_name = "demo_test";

    @BeforeClass
    public static void setUpBeforeClass(){
        fileName = TestReport.create(package_name);
    }

    @AfterClass
    public static void tearDownAfterClass(){
        TestReport.close();
    }

    public void run(Class clazz){
        suite = new TestSuite();
        result = new TestResult();
        suite.runTest(new JUnit4TestAdapter(clazz),result);

        TestReport.output(fileName,clazz.getName().substring(23) + ": " + package_name);
        TestReport.getResult(result,fileName);
    }

    @Test
    public void test_all(){
        run(Test1.class);
        run(Test2.class);
    }

}
