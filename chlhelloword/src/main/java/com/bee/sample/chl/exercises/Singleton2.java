package com.bee.sample.chl.exercises;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Singleton2.java
 * @Description TODO
 * @createTime 2022年12月14日 17:30:00
 */
public class Singleton2 {

        private static Singleton2 instance = null;
        public static synchronized Singleton2 getInstance() {
            // 使用时生成实例，提高了效率！
            if (instance == null){
                instance = new Singleton2();
            }
            return instance;
        }

}
