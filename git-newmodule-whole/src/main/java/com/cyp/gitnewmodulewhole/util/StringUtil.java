package com.cyp.gitnewmodulewhole.util;

public class StringUtil {
    public static void main(String[] args) {
        String line="13262828891,4G全国流量王76元套餐,128.4, ,";
        String[] str =line.split(",");
        System.out.println(str.length);
        for (int i = 0; i <str.length ; i++) {
            System.out.println(str[i]);

        }
        System.out.println(str[3]);

    }
}
