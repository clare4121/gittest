package com.cyp.newmapper.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ExcelPropertyIndexModel.java
 * @Description TODO
 * @createTime 2022年03月15日 14:12:00
 */
@Data
public class ExcelPropertyIndexModelBak {
    @ExcelProperty(value = "政策编码", index = 0)
    private String policyId;
    @ExcelProperty(value = "批次编码", index = 1)
    private String batchId;
    @ExcelProperty(value = "客户ID", index = 2)
    private String customerId;
    @ExcelProperty(value = "客户名称", index = 3)
    private String customerName;
    @ExcelProperty(value = "执行人ID", index = 4)
    private String executeId;
    @ExcelProperty(value = "'客户类型", index = 5)
    private String executeName;
    @ExcelProperty(value = "写入时间", index = 6)
    private String insertTime;
    @ExcelProperty(value = "写入人", index = 7)
    private String  insertBy;
    @ExcelProperty(value = "数据同步状态", index = 8)
    private String  syncStatus;
    @ExcelProperty(value = "备用字段1", index = 9)
    private String  space1;
    @ExcelProperty(value = "备用字段2", index = 10)
    private String  space2;
    @ExcelProperty(value = "备用字段3", index = 11)
    private String  space3;
    @ExcelProperty(value = "备用字段4", index = 12)
    private String  space4;
    @ExcelProperty(value = "备用字段5", index = 13)
    private String  space5;

}
