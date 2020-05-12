package com.wmk.testcase;

import com.wmk.testcase.listeners.ZTestReportListener;
import junit.framework.TestFailure;
import junit.framework.TestResult;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestReport {
	private static String fileName = null;
	public static boolean isfinalResult;
	public static String finalResult;
	public static int failedTestCount = 0;
	public static int allTestCount = 0;

	public static String create(String dbName) {
    	isfinalResult = true;
		fileName = System.getProperty("user.dir") + "/report/" + dbName + "/";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
    	fileName = fileName+ df.format(new Date()) + ".txt";
    	File file = new File(fileName);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    	return fileName;
	}
	
	public static void close() {
		if(isfinalResult) {
			finalResult = "Pass";
		}
		else
			finalResult = "Fail";
	
		TestReport.output(fileName, "AllTest: " + allTestCount + "  FailedTest: " + failedTestCount);
		TestReport.output(fileName, "\r\nReport Result: " + finalResult);
		System.out.println("\nAllTest: " + allTestCount + "  FailedTest: " + failedTestCount);
		System.out.println("Report Result: " + finalResult);
	}
	
    public static void output(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void getResult(TestResult result, String fileName) {
    	allTestCount++;
		TestReport.output(fileName, "RUN: " + result.runCount() + "   ERROR: " + result.failureCount() + "   FAILURE: " + result.errorCount());
		if (result.failureCount() != 0 || result.errorCount() != 0)
			failedTestCount++;
		if (result.errors() != null) outputTestFailure(result.errors());
		if (result.failures() != null) outputTestFailure(result.failures());
		System.out.println("result: " + result.wasSuccessful());
		TestReport.output(fileName, "RESULT: " + result.wasSuccessful() + "\r\n");
	}
    
    
    public static void outputTestFailure(Enumeration<TestFailure> testFailures) {
    	TestFailure testFailure;
    	while (testFailures.hasMoreElements()) {
        	isfinalResult = false;
			testFailure = testFailures.nextElement();
			String failedTest = testFailure.failedTest().toString();
			if(failedTest.indexOf("(") != -1) {
				System.out.println("failedTest(): " + failedTest.substring(0,failedTest.indexOf("(")));
				TestReport.output(fileName, "failedTest(): " + failedTest.substring(0,failedTest.indexOf("(")));
			}
			else {
				System.out.println("failedTest(): " + failedTest);
				TestReport.output(fileName, "failedTest(): " + failedTest);
			}
			System.out.println("thrownException(): " + testFailure.thrownException());
			TestReport.output(fileName, "	thrownException(): " + testFailure.thrownException());
		}
    }

	public static void report_out(Class class_name,String filePath,String fileName){
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
				.request()
				.selectors(selectClass(class_name))
				.build();
		Launcher launcher = LauncherFactory.create();

		// 注册执行结果监听器
		// html测试报告生成
		ZTestReportListener listener = new ZTestReportListener(TestReport.class.getClassLoader().getResource("report.template").toString().substring(6));
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		listener.outputResult(System.getProperty("user.dir") + "/report/"+ filePath,fileName);
	}

	public static void report_out(Class[] class_names,String filePath,String fileName){
		ZTestReportListener listener = new ZTestReportListener(TestReport.class.getClassLoader().getResource("report.template").toString().substring(6));
		Launcher launcher = LauncherFactory.create();
		// 注册执行结果监听器
		launcher.registerTestExecutionListeners(listener);
		for(int i=0;i<class_names.length;i++){
			LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
					.request()
					.selectors(selectClass(class_names[i]))
					.build();
			launcher.execute(request);
		}
		// html测试报告生成
		listener.outputResult(System.getProperty("user.dir") + "/report",fileName);
	}
}
