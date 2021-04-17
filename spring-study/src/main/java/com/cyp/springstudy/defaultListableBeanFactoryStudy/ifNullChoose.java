package com.cyp.springstudy.defaultListableBeanFactoryStudy;

public class ifNullChoose {
    public ifNullChoose(String str)  {
        this(str, (String)null);
    }

    public ifNullChoose(String str, String str2){
        str2="默认值";
        System.out.println(str2+str);
    }
}
