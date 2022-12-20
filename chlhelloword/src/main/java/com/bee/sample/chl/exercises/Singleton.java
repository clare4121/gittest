package com.bee.sample.chl.exercises;

public class Singleton {
        private Singleton() {
        }
        // 注意这是private 只供内部调用
        private final static Singleton instance = new Singleton();
        // 这里提供了一个供外部访问本class的静态方法，可以直接访问
        public static Singleton getInstance() {
              return instance;
        }
  }


