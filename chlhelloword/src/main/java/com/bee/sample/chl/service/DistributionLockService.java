package com.bee.sample.chl.service;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName DistributionLockService.java
 * @Description TODO
 * @createTime 2023年02月07日 16:26:00
 */
public interface DistributionLockService {
    boolean getLock(String lockName, String uniqueCode, int expireTime);
    void releaseLock(String lockName, String uniqueCode);
}
