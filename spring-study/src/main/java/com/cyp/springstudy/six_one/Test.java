package com.cyp.springstudy.six_one;

import org.springframework.util.Assert;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年07月05日 10:40:00
 */
public class Test {
    public void setConfigLocations(String[] locations){


        if(locations!=null){
            Assert.noNullElements(locations,"Config locations must not be null");
        }

    }
}
