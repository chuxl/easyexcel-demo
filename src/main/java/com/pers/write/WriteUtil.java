package com.pers.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.pers.common.DataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Carson Chu
 * @email 1965704869@qq.com
 * @date 2020/1/29 12:33
 * @description
 */
public class WriteUtil {
    public static void main(String[] args) {
        try {
            new WriteUtil().simpleWrite();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void simpleWrite() throws Exception {
        // 写法1
        String fileName = "demo1.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DataModel.class).sheet("店铺每天营收数据").doWrite(dataGenerator());

        // 写法2，方法二需要手动关闭流
        fileName = "demo2.xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, DataModel.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("店铺每天营收数据").build();
        excelWriter.write(dataGenerator(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    /**
     * @description 手动生成数据写入Excel
     * @params []
     * @returns java.util.List<com.pers.common.DataModel>
     */
    private List<DataModel> dataGenerator() {
        Date curTime = new Date();
        List<DataModel> list = new ArrayList<DataModel>();
        for (int i = 0; i < 12; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setShopName("店铺名称" + i);
            dataModel.setDate(curTime);
            dataModel.setProfit(i * 66.6666);
            list.add(dataModel);
        }
        return list;
    }
}
