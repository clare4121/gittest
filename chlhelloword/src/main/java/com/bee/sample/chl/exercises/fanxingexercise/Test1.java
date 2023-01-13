package com.bee.sample.chl.exercises.fanxingexercise;
/**
 *
 *
 * 对于声明了<T>的类(Test1<T>就是声明了<T>的类)不需要声明泛型方法,
 * 对于带了static的方法,它并不属于类的一部分,
 * 所以相当于没有声明<T>的类,所以需要声明为泛型方法.
 * 像Test2这样的类就必须声明泛型方法
 */
public class Test1<T> {
    private T name;
    public T getName(T name){
        return name;
    }
    public static <T> void printA(T a){
        System.out.println(a);
    }


   class Test2 {
       public <T> T test1(T A) {
           System.out.println(A);
           System.out.println(A.getClass());
           return A;
       }
   }


 
}