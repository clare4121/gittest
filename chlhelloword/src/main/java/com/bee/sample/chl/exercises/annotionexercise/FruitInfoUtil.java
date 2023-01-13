package com.bee.sample.chl.exercises.annotionexercise;

import java.lang.reflect.Field;


public  class  FruitInfoUtil  {
    public  static  void  getFruitInfo(Class<? >  clazz)  {
      String strFruitProvicer = "供应商信息：";
      Field[] fields = clazz.getDeclaredFields();
      //通过反射获取处理注解
      for  (Field  field  :  fields)  {
          if  (field.isAnnotationPresent(FruitProvider.class))  {
                FruitProvider  fruitProvider  = field.getAnnotation(FruitProvider.class);
              strFruitProvicer = " 供应商编号：" + fruitProvider.id() +
                    " 供应商名称："+ fruitProvider.name() + " 供应商地址："+
                      fruitProvider.address();
            System.out.println(strFruitProvicer);
          }
      }
  }

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
