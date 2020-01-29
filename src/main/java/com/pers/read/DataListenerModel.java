package com.pers.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.pers.common.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carson Chu
 * @email 1965704869@qq.com
 * @date 2020/1/29 13:18
 * @description
 */
public class DataListenerModel extends AnalysisEventListener<DataModel> {

    List<DataModel> list = new ArrayList<DataModel>();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public DataListenerModel() {
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     * @param context
     */
    @Override
    public void invoke(DataModel data, AnalysisContext context) {
        System.out.printf("解析到一条数据:{%s}", JSON.toJSONString(data));
        System.out.println();
        list.add(data);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println(JSON.toJSONString(list));
    }
}
