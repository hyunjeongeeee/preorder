package com.preorder.web.product.redis;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class DistributedLockService {

    private final RedissonClient redissonClient;

    @Transactional
    public void DistributedLock (String keyName) throws InterruptedException {
        RLock lock = redissonClient.getLock(keyName);

        try {
            // 각각 waitTime, leaseTime, time unit
            boolean isLocked = lock.tryLock(2, 3, TimeUnit.SECONDS);
            if (!isLocked) {
                // 락 획득에 실패시
                throw new RuntimeException( "[락획득실패]");
            }

            // ...

        } catch (InterruptedException e) {
            // interrupted
        } finally {
            // 락 release
            lock.unlock();
        }
    }
}
