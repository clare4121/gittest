package com.cyp.newmapper.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.cyp.newmapper.entity.ExcelPropertyIndexModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ExcelUtils.java
 * @Description TODO
 * @createTime 2022年03月15日 14:17:00
 */
public class ExcelUtils {

    /**
     * 解析excel文件内容
     *
     * @param file
     * @return
     */
    public static List<ExcelPropertyIndexModel> readExcel(MultipartFile file) {

        //File file = new File(fileName);
        InputStream inputStream = null;
        try {
            //inputStream = new FileInputStream(file);
            inputStream = file.getInputStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener();

        ExcelReader excelReader1 = EasyExcelFactory.read(inputStream)
                .registerReadListener(listener)
                .head(ExcelPropertyIndexModel.class)
                .excelType(ExcelTypeEnum.XLSX).build();

        excelReader1.readAll();
        List<ExcelPropertyIndexModel> datas = listener.getDatas();
        return datas;
    }
}
