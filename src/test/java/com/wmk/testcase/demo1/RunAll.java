package com.wmk.testcase.demo1;

import com.wmk.testcase.TestReport;
import org.junit.Test;

public class RunAll {

    public void run(Class[] class_names){
        TestReport.report_out(class_names,RunAll.class.getPackage().getName().substring(17), "report.html");
    }

    @Test
    public void test_all(){
        Class[] class_names = {Test1.class,Test2.class, com.wmk.testcase.Junit5Excel.Test1.class};
        run(class_names);
    }

}
