package com.wmk.testcase.duotai;


import org.junit.jupiter.api.Test;

public class TestUse {

    @Test

    public void test11() throws Exception {
        System.out.println("\nDataMaskTest: " + DB2Config.getDbConfig().getHost());
        System.out.println("\nDataMaskTest: " + DB2Config.getDbConfig(1).getHost());
        System.out.println("\nDataMaskTest: " + DB2Config.getDbConfig(0).getHost());
        System.out.println("\nDataMaskTest: " + DB2Config.getDbConfigList().toArray());

    }
}
