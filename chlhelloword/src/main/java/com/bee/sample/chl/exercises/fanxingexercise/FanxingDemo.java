package com.bee.sample.chl.exercises.fanxingexercise;

import javafx.concurrent.Worker;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import sun.security.smartcardio.SunPCSC;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FanxingDemo.java
 * @Description TODO
 * @createTime 2022年12月22日 16:02:00
 */
public class FanxingDemo {
    /**
     * E 在集合中使用 表示集合中存放得元素
     * T 表示java类 基本得类和我们自定义得类
     * K  表示建 如map中得key
     * V  表示值
     * N  表示数值类型
     * ? 表示不确定得java类型
     */


    public static void main(String[] args) {
    geneerMethod("1",2);

    }
   //...代表可变参数
   //它的入参是Class<T>  requiredType,也就是说这个方法需要传入一个泛型类的参数，所以前面的<T> T中的<T>代表的是 返回值T的类型，也就是入参为class的时候，
   //返回值类型的呃前面需要加一个<T> 来限定 后面泛型T的类型，告诉后面返回值T的类型是什么，返回值为void，也不能不写<T>，因为需要和入参的类型保持一致
    public static <T>  void geneerMethod(T... inputArray) {
        for (T element : inputArray) {
         if (element instanceof Integer){
             System.out.println("-处理integer类型中");
         }
         if(element instanceof  String){
             System.out.println("-处理String类型中");
         }
         else if(element instanceof Worker){
             System.out.println("处理worlk乐心数据中");
            }



        }
    }

    public static <T> T getBean(Class<T> requiredType) {
        return getBean(requiredType);
    }
}
