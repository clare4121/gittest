package com.cyp.newmapper.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cyp.newmapper.entity.ExcelPropertyIndexModel;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelListener extends AnalysisEventListener {

    public List<ExcelPropertyIndexModel> datas = new ArrayList<>();

    public List<ExcelPropertyIndexModel> getDatas() {
        return datas;
    }

    public void setDatas(List<ExcelPropertyIndexModel> datas) {
        this.datas = datas;
    }

    @Override
    public void invoke(Object object, AnalysisContext context) {
        ExcelPropertyIndexModel stringList = (ExcelPropertyIndexModel) object;
        datas.add(stringList);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //解析结束销毁不用的资源
        //datas.clear();
    }
}