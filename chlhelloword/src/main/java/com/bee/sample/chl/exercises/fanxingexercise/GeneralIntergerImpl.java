package com.bee.sample.chl.exercises.fanxingexercise;

import java.util.Random;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName GeneralIntergerImpl.java
 * @Description TODO
 * @createTime 2022年12月26日 13:57:00
 */

//定义泛型接口的实现类
public  class  GeneralIntergerImpl  implements  IGeneral<Integer>{
        @Override
        public  Integer  getId()  {
            Random random  =  new  Random(100);
            return  random.nextInt();
        }
        public  static  void  main(String[]  args)  {
            //使用泛型
            GeneralIntergerImpl gen  =  new GeneralIntergerImpl();
            System.out.println(gen.getId());
        }
    }

