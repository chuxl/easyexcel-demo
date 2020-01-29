package com.pers.common;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.util.Date;

/**
 * @author Carson Chu
 * @email 1965704869@qq.com
 * @date 2020/1/29 12:08
 * @description 数据模型
 */
@ContentRowHeight(18)
@HeadRowHeight(25)
@ColumnWidth(25)
public class DataModel {
    /**
     * 复杂标题 将整合为一个单元格效果如下：
     * —————————————————————————
     * |          天猫        |
     * —————————————————————————
     * |旗舰店名称|日期|营收|
     * —————————————————————————
     */
    /* 旗舰店名称 */
    @ExcelProperty({"天猫", "旗舰店名称"})
    private String shopName;
    /* 日期 */
    @ExcelProperty({"天猫", "日期"})
    private Date date;
    /* 营收数据（小数型） */
    @ExcelProperty({"天猫", "营收"})
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
