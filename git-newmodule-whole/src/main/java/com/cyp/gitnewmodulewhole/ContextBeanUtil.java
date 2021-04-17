package com.cyp.gitnewmodulewhole;

import com.cyp.gitnewmodulewhole.service.GongjuPeople;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("register")
public class ContextBeanUtil implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Map<String, GongjuPeople> serviceImplMap = new HashMap<String, GongjuPeople>();
    @Override
    public void afterPropertiesSet()  {
           Map<String, GongjuPeople> beanMap = applicationContext.getBeansOfType(GongjuPeople.class);
        String name = null;
        for (GongjuPeople gongjuPeople : beanMap.values()) {

            name = gongjuPeople.getClass().getSimpleName();

            System.out.println("---key:\t" + name);
            // 将类名，作为 key,
            serviceImplMap.put(name, gongjuPeople);
        }
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }



    public GongjuPeople getStorageType(String name) {
        return serviceImplMap.get(name);
    }
}
