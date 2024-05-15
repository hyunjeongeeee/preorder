package com.preorder.web.product.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * AOP에서 트랜잭션 분리를 위한 클래스
 *   => @DistributedLock 이 선언된 메서드는 Propagation.REQUIRES_NEW 옵션을 지정해
 *    부모 트랜잭션의 유무에 관계없이 별도의 트랜잭션으로 동작하게끔 설정함
 *    그리고 반드시 트랜잭션 커밋 이후 락이 해제되게끔 처리함
 *
 * 트랜잭션 커밋 이후 락이 해제되어야 하는이유?
 *   => 바로 동시성 환경에서 데이터의 정합성을 보장하기 위해서
 */
@Component
public class AopForTransaction {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Object proceed(final ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
