package com.pers.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.pers.common.DataModel;

/**
 * @author Carson Chu
 * @email 1965704869@qq.com
 * @date 2020/1/29 13:20
 * @description
 */
public class ReadUtil {
    public static void main(String[] args) {
        new ReadUtil().simpleRead();
    }

    public void simpleRead() {
        // 写法1：
        String fileName = "demo1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DataModel.class, new DataListenerModel()).sheet().doRead();

        // 写法2：
        fileName = "demo2.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, DataModel.class, new DataListenerModel()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}
