package com.wmk.testcase.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class YamlTest {
    @Test
    void readYaml(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        DataMaskConfig dataMaskConfig = null;
        try {
            dataMaskConfig = mapper.readValue("yaml_test.yaml", DataMaskConfig.class);
            System.out.println(dataMaskConfig);
            System.out.println(dataMaskConfig.expect_value);
            System.out.println(dataMaskConfig.mask_col);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    void prettyPrintYaml(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        // pretty print
        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new DataMaskConfig());
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
