package com.wmk.testcase.demo2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class JsonTest {
    @Test
    public void test_write() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DataMaskConfig dataMaskConfig = new DataMaskConfig();
//            dataMaskConfig.setMask_col("aaa");
//            dataMaskConfig.setExpect_value("bbb");
//            dataMaskConfig.setExpect_value("ccc");
//            dataMaskConfig.setSet_data("ddd");
//            dataMaskConfig.setMask_databse("eee");
            mapper.writeValue(new File("test_json.json"), dataMaskConfig);
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new DataMaskConfig());
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test_read() {
//            System.out.println(System.getProperty("user.dir")+"\\test_json.json");
//            System.out.println((JsonTest.class.getResource("/").getPath()+"test_json.json").replaceFirst("/",""));
        try {
            ObjectMapper mapper = new ObjectMapper();
            DataMaskConfig dataMaskConfig = mapper.readValue("test_json.json", DataMaskConfig.class);
            System.out.println(dataMaskConfig);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
