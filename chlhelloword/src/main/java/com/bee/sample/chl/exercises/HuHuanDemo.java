package com.bee.sample.chl.exercises;

import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  public class HuHuanDemo {
        public static void main(String args[]) {
            print();
        }
        public static int[] write() {
            BufferedReader[] buf = new BufferedReader[10];
            /* 申请缓冲数组 */
            int n;
            /* 开关量 和 中间量 */
            int array[] = new int[10];
            for (int i = 0; i < 10; i++) {
                /* 赋值 */
                buf[i] = new BufferedReader(new InputStreamReader(System.in));
                /* 给每个缓冲区定义 */
                do {
                    /* 判断是否是空串，如是则重新输入 */
                    n = 1;
                    System.out.print("请输入第" + (i + 1) + "个整数:");
                    try { /* 建立一个异常捕获 */
                        array[i] = Integer.parseInt(buf[i].readLine());
                        /* 执行串变整数 */
                        /*
                        * Integer.parseInt(str) - str 转成 int型 buf[i].readLine() -
                        * 从系统输入缓冲区读入字符流给buf缓冲区并返回字符串
                        */
                    } catch (NumberFormatException e) {
                        /* 捕获异常 */
                        System.out.println("数据输入错误请重新输入");
                        /* 处理异常 */
                        n = 0;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } while (n == 0);
            }
            return array;
        }
        public static void print() {
            int[] ary = write();
            int s;
            System.out.println("\n你输入的数组是:");
            for (int i = 0; i < 10; i++) {
                /* 输出原数组 */
                System.out.print(ary[i] + " ");
            }
            for (int i = 0; i < 5; i++)
                /* 对换 */
                {
                s = ary[i];
                ary[i] = ary[9 - i];
                ary[9 - i] = s;
            }
            System.out.println("\n对换后的数组是:");
            for (int i = 0; i < 10; i++) {
                /* 输出对换后数组 */
                System.out.print(ary[i] + " ");
            }
            System.out.println();
        }
  }