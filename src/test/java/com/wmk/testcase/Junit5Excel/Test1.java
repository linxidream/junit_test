package com.wmk.testcase.Junit5Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Test1
{
    static Stream<Arguments> ExcelMethod() {
        return getTestDataStreamFromExcelFile("TestExcel.xlsx","sheet1");
    }

    @ParameterizedTest
    @MethodSource("ExcelMethod")
    public void test1(String person, int age, float salary){
        System.out.println(person + " " + age +" "+ salary);
        Assert.assertEquals(4,age);
    }

    public static Stream<Arguments> getTestDataStreamFromExcelFile(String excelFullPath, String sheetName){

        Stream<Arguments> returnStream = Stream.empty();
        //定义单元格数据格式处理对象
        DataFormatter myDataFormatter = new DataFormatter();

        //获取工作簿对象
        try(Workbook excelFile = WorkbookFactory.create(new File(excelFullPath),null,true)) {
            //获取工作表
            Sheet excelSheet1 = excelFile.getSheet(sheetName);
            //行数据处理，忽略标题行，行数据作为后续参数List
            for(Row row: excelSheet1){
                if(row.getRowNum()==0) {continue;}
                ArrayList<Object> rowArrayList = new ArrayList<>();
                //获取单元格数值，存入行List
                for (Cell cell : row) {
                    rowArrayList.add(myDataFormatter.formatCellValue(cell));
                }
                System.out.println(rowArrayList);
                //转换为MethodSource的Arguments对象
                Arguments arguments = Arguments.of(rowArrayList.toArray());
                //Arguments转换为Stream
                returnStream = Stream.concat(returnStream,Stream.of(arguments));
            }
            return returnStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnStream;
    }
}
