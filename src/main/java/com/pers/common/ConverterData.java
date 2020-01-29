package com.pers.common;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;

import java.util.Date;

/**
 * @author Carson Chu
 * @email 1965704869@qq.com
 * @date 2020/1/29 12:21
 * @description 基础数据类.这里的排序和excel里面的排序一致
 */
public class ConverterData {
    /**
     * 我想所有的 字符串起前面加上"格式化："三个字
     */
    @ExcelProperty(value = "店铺名称", converter = CustomStringStringConverter.class)
    private String shopName;
    /**
     * 我想写到excel 用年月日时分秒的格式
     */
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty("日期")
    private Date date;
    /**
     * 我想写到excel 用小数表示
     */
    @NumberFormat("#.##")
    @ExcelProperty(value = "营收")
    private Double profit;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
