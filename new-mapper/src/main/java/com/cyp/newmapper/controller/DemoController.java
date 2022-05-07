package com.cyp.newmapper.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cyp.newmapper.entity.ExcelPropertyIndexModel;
import com.cyp.newmapper.util.DateUtil;
import com.cyp.newmapper.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author cyp
 * @version 1.0.0
 * @ClassName DemoController.java
 * @Description TODO
 * @createTime 2022年01月27日 17:03:00
 */
@RestController
@RequestMapping("/api/test")
@Slf4j
public class DemoController {
    public ModelAndView index(){
        return new ModelAndView(){{
            setViewName("demo/testFTl");
        }};
    }
    @PostMapping("/upload")
    @ResponseBody
    public void demo(@RequestParam("file") MultipartFile file,String policyId){
        System.out.println(file);
        String batchId = "batchId"+ DateUtil.dateTime4String(new Date());
        List<ExcelPropertyIndexModel> lists = ExcelUtils.readExcel(file);
        for (int i = 0; i < lists.size() ; i++) {
            ExcelPropertyIndexModel excelPropertyIndexModel =lists.get(i);
            excelPropertyIndexModel.setBatchId(batchId);
            excelPropertyIndexModel.setPolicyId(policyId);
            excelPropertyIndexModel.setSyncStatus("0");
        }
        System.out.println(lists);
        if (lists != null) {
            log.info("表数据：" + lists);
        } else {
            log.info("空异常！");
        }
        saveWorkOrder(lists,policyId);
        String fileName = file.getOriginalFilename();
        System.out.println("文件名称为"+fileName);
    }

    @PostMapping("/listFilter")
    @ResponseBody
    public void demo2(@RequestParam("file") MultipartFile file,String policyId){
        System.out.println(file);
        String batchId = "batchId"+ DateUtil.dateTime4String(new Date());
        List<ExcelPropertyIndexModel> lists = ExcelUtils.readExcel(file);
        for (int i = 0; i < lists.size() ; i++) {
            ExcelPropertyIndexModel excelPropertyIndexModel =lists.get(i);
            excelPropertyIndexModel.setBatchId(batchId);
            excelPropertyIndexModel.setPolicyId(policyId);
            excelPropertyIndexModel.setSyncStatus("0");
        }
        System.out.println(lists);
        if (lists != null) {
            log.info("表数据：" + lists);
        } else {
            log.info("空异常！");
        }
        saveWorkOrder(lists,policyId);
        String fileName = file.getOriginalFilename();
        System.out.println("文件名称为"+fileName);
    }
    @GetMapping("/writerExcel")
    public List<ExcelPropertyIndexModel> writerExcel() {
//        List<ExcelPropertyIndexModel> lists = ExcelUtils.readExcel();
//        if (lists != null) {
//            log.info("表数据：" + lists);
//        } else {
//            log.info("空异常！");
//        }
        return null;
    }



    @Transactional(rollbackFor = Exception.class)
    public boolean saveWorkOrder(List<ExcelPropertyIndexModel> data, String policyId) {
        try {
            StringBuilder sb = new StringBuilder();//存放直接下发的id
            if (data.size() != data.size()) {
                return false;
            }
            deleteWorkOrder(policyId);
            
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    public boolean deleteWorkOrder(String policyId) {
        return true;
    }


}
