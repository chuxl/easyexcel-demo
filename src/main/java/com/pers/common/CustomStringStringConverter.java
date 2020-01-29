package com.pers.common;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author Carson Chu
 * @email 1965704869@qq.com
 * @date 2020/1/29 12:24
 * @description
 */
public class CustomStringStringConverter implements Converter<String> {
    public Class supportJavaTypeKey() {
        return String.class;
    }

    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里是读的时候会调用 不用管
     *
     * @param cellData            NotNull
     * @param contentProperty     Nullable
     * @param globalConfiguration NotNull
     * @return
     */
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) {
        return cellData.getStringValue();
    }

    /**
     * 这里是写的时候会调用 不用管
     *
     * @param value               NotNull
     * @param contentProperty     Nullable
     * @param globalConfiguration NotNull
     * @return
     */
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        return new CellData("格式化：" + value);
    }
}
